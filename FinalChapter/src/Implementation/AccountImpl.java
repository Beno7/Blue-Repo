/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import Logic.Account;

/**
 *
 * @author Win 7
 */
public class AccountImpl {

    private Connection connection;
    private DBconnection dBConnection;

    public void addAccount(Account a) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into accounts(firstName,lastName,position,birthday,username,password) values (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, a.getFirstName());
            preparedStatement.setString(2, a.getLastName());
            preparedStatement.setString(3, a.getPosition());
            preparedStatement.setDate(4, new Date(a.getBirthDay().getTime()));
            preparedStatement.setString(5, a.getUserName());
            preparedStatement.setString(6, a.getPassWord());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Account getAccount(String username, String password) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from accounts where username = ? and password = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                Account a = new Account();
                a.setFirstName(rs.getString("firstName"));
                a.setLastName(rs.getString("lastName"));
                a.setPosition(rs.getString("position"));
                a.setBirthDay(rs.getDate("birthday"));
                a.setUserName(rs.getString("username"));
                a.setPassWord(rs.getString("password"));
                return a;
            }
            else{
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean checkAccount(String username) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from accounts where username = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return true;
            }
            else{
                connection.close();
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
}

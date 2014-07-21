/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import Interfaces.OfficeInterface;
import Logic.Office;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Win 7
 */
public class OfficeImpl implements OfficeInterface {

    private Connection connection;
    private DBconnection dBConnection;

    public boolean addOffice(Office o) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into office(name,contactNo) values (?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, o.getName());
            preparedStatement.setString(2, o.getContact());
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Office getOffice(String name) {
        try {
               Office office = new Office();
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from office where name = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                office.setName(rs.getString("name"));
                office.setContact(rs.getString("contactNo"));
                return office;
            } else{
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OfficeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Office> getAllOffice(){   
            try {
                
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from office order by name;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Office> office = new ArrayList();
            while(rs.next()){
            Office o = new Office();
            o.setName(rs.getString("name"));
            o.setContact(rs.getString("contactNo"));
            office.add(o);
            }
            
            connection.close();

            return office;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

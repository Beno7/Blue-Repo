/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Logic.Transaction;
import Connection.DBconnection;
import Interfaces.WalkInInterface;
import java.sql.Connection;
import java.sql.Date;
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
public class WalkInImpl implements WalkInInterface {

    private Connection connection;
    private DBconnection dBConnection;

    @Override
    public boolean addWalkInTransaction(Transaction wT) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "insert into SalesTransaction(inVoice,date,dateOfPayment,dateReceived,total) "
                    + "values (?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, wT.getInVoice());
            preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
            preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));
            preparedStatement.setDate(4, new Date(new java.util.Date().getTime()));
            preparedStatement.setDouble(5, wT.getTotal());
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(WalkInImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Transaction getWalkInTransaction(String inVoice) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "select * from SalesTransaction where invoice = ? and officeid is null;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                Transaction wt = new Transaction();
                wt.setInVoice(inVoice);
                wt.setDateRecorded(rs.getDate("date"));
                wt.setTotal(rs.getDouble("total"));
                return wt;
            }
            connection.close();
            return null;

        } catch (SQLException ex) {
            Logger.getLogger(WalkInImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Transaction> getAllWalkInTransactions() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "select * from SalesTransaction where officeId is null order by date ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Transaction> walkTrans = new ArrayList();
            while (rs.next()) {
                Transaction wt = new Transaction();
                wt.setInVoice(rs.getString("inVoice"));
                wt.setDateRecorded(rs.getDate("date"));
                wt.setTotal(rs.getDouble("total"));
                walkTrans.add(wt);
            }
            connection.close();

            return walkTrans;
        } catch (SQLException ex) {
            Logger.getLogger(WalkInImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Transaction> getSortByInVoice() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "select * from SalesTransaction where officeId is null order by inVoice ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Transaction> walkTrans = new ArrayList();
            while (rs.next()) {
                Transaction wt = new Transaction();
                wt.setInVoice(rs.getString("inVoice"));
                wt.setDateRecorded(rs.getDate("date"));
                wt.setTotal(rs.getDouble("total"));
                walkTrans.add(wt);
            }
            connection.close();

            return walkTrans;
        } catch (SQLException ex) {
            Logger.getLogger(WalkInImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

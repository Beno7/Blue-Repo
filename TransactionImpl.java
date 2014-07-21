/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import Interfaces.TransactionInterface;
import Logic.STransaction;
import Logic.OTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Win 7
 */
public class TransactionImpl implements TransactionInterface {

    private Connection connection;
    private DBconnection dBConnection;

    public @Override boolean addSupplierTransaction(STransaction sT) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "insert into stransaction(name,inVoice,terms,deadline,total,date) "
                    + "values (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, sT.getTransacw());
            preparedStatement.setString(2, sT.getInVoice());
            preparedStatement.setInt(3, sT.getTerm());
            preparedStatement.setDate(4,  new Date(sT.getDeadLine().getTime()));
            preparedStatement.setDouble(5, sT.getTotal());
            preparedStatement.setDate(6, new Date(sT.getBuyDate().getTime()));
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public @Override STransaction getSupplierTransaction(String inVoice) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            STransaction sT = new STransaction();
            String query = "select * from stransaction where inVoice = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            sT.setTermNoDate(rs.getInt("terms"));
            sT.setBuyDate(rs.getDate("date"));
            sT.setDeadLine(rs.getDate("deadline"));
            sT.setTotal(rs.getDouble("total"));
            sT.setTransactw(rs.getString("name"));
            sT.setInVoice(inVoice);

            connection.close();

            return sT;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public @Override ArrayList<STransaction> getAllSupplierTransaction(String name) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from stransaction where name = ? order by date;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<STransaction> Transactions = new ArrayList<STransaction>();
            while (rs.next()) {
                STransaction sT = new STransaction();
                sT.setTermNoDate(rs.getInt("terms"));
                sT.setBuyDate(rs.getDate("date"));
                sT.setDeadLine(rs.getDate("deadline"));
                sT.setTotal(rs.getDouble("total"));
                sT.setTransactw(rs.getString("name"));
                sT.setInVoice(rs.getString("inVoice"));

                Transactions.add(sT);
            }
            connection.close();
            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public @Override boolean addOfficeTransaction(OTransaction oT) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "insert into otransaction(name,inVoice,terms,deadline,total,date) "
                    + "values (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, oT.getTransacw());
            preparedStatement.setString(2, oT.getInVoice());
            preparedStatement.setInt(3, oT.getTerm());
            preparedStatement.setDate(4, new Date(oT.getDeadLine().getTime()));
            preparedStatement.setDouble(5, oT.getTotal());
            preparedStatement.setDate(6, new Date(oT.getBuyDate().getTime()));
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public @Override OTransaction getOfficeTransaction(String inVoice) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            OTransaction oT = new OTransaction();
            String query = "select * from otransaction where inVoice = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            oT.setTerm(rs.getInt("terms"));
            oT.setBuyDate(rs.getDate("date"));
            oT.setDeadLine(rs.getDate("deadline"));
            oT.setTotal(rs.getDouble("total"));
            oT.setTransactw(rs.getString("name"));
            oT.setInVoice(inVoice);

            connection.close();

            return oT;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public @Override ArrayList<OTransaction> getAllOfficeTransaction(String name) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from otransaction where name = ? order by date;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<OTransaction> Transactions = new ArrayList<OTransaction>();
            while (rs.next()) {
                OTransaction oT = new OTransaction();
                oT.setTermNoDate(rs.getInt("terms"));
                oT.setBuyDate(rs.getDate("date"));
                oT.setDeadLine(rs.getDate("deadline"));
                oT.setTotal(rs.getDouble("total"));
                oT.setTransactw(rs.getString("name"));
                oT.setInVoice(rs.getString("inVoice"));

                Transactions.add(oT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public @Override ArrayList<OTransaction> getAllTransactionOffice() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from otransaction order by date;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<OTransaction> Transactions = new ArrayList<OTransaction>();
            while (rs.next()) {
                OTransaction oT = new OTransaction();
                oT.setTerm(rs.getInt("terms"));
                oT.setBuyDate(rs.getDate("date"));
                oT.setDeadLine(rs.getDate("deadline"));
                oT.setTotal(rs.getDouble("total"));
                oT.setTransactw(rs.getString("name"));
                oT.setInVoice(rs.getString("inVoice"));
                Transactions.add(oT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public @Override ArrayList<STransaction> getAllTransactionSupplier() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            STransaction sT = new STransaction();
            String query = "select * from stransaction order by date;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<STransaction> Transactions = new ArrayList<STransaction>();
            while (rs.next()) {
                sT.setTerm(rs.getInt("terms"));
                sT.setBuyDate(rs.getDate("date"));
                sT.setDeadLine(rs.getDate("deadline"));
                sT.setTotal(rs.getDouble("total"));
                sT.setTransactw(rs.getString("name"));
                sT.setInVoice(rs.getString("inVoice"));

                Transactions.add(sT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import Interfaces.OfficeTransInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import Logic.OfficeTransaction;
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
public class OfficeTransImpl implements OfficeTransInterface {

    private Connection connection;
    private DBconnection dBConnection;
    private OfficeImpl oI = new OfficeImpl();

    public @Override
    boolean addOfficeTransaction(OfficeTransaction oT) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "insert into SalesTransaction(officeId,inVoice,terms,date,DateOfPayment,DateReceived,Total) "
                    + "values (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, new BigDecimal(oT.getID()));
            preparedStatement.setString(2, oT.getInVoice());
            preparedStatement.setInt(3, oT.getTerms());
            preparedStatement.setDate(4, new Date(oT.getDateRecorded().getTime()));
            if(oT.getDateOfPayment()!=null)
                preparedStatement.setDate(5, new Date(oT.getDateOfPayment().getTime()));
            else
                preparedStatement.setDate(5, null);
            if(oT.getDateOfDelivery()!=null)
                preparedStatement.setDate(6, new Date(oT.getDateOfDelivery().getTime()));
            else
                preparedStatement.setDate(6, null);
            preparedStatement.setDouble(7, oT.getTotal());

            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public @Override
    OfficeTransaction getOfficeTransaction(String inVoice) {
        try {
            oI = new OfficeImpl();
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            OfficeTransaction oT = new OfficeTransaction();
            String query = "select * from SalesTransaction where inVoice = ? and officeid is not null;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                oT.setTerms(rs.getInt("terms"));
                oT.setDateRecorded(rs.getDate("date"));
                oT.setDateOfPayment(rs.getDate("dateOfPayment"));
                oT.setID(rs.getBigDecimal(("officeId")).toBigInteger());
                oT.setDateOfDelivery(rs.getDate("dateReceived"));
                oT.setInVoice(inVoice);
                oT.setTransactor(oI.getOffice(rs.getBigDecimal(("officeId")).toBigInteger()).getName());
                oT.setSBD(rs.getString("inVoice"));
                oT.setTotal(rs.getDouble("total")); 
                return oT;
            }
            else{
                connection.close();
                return null;            }
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public @Override
    ArrayList<OfficeTransaction> getAllOfficeTransaction(BigInteger officeId) {
        try {
            OfficeTransaction oT;
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from SalesTransaction where officeId = ? order by date;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, new BigDecimal(officeId));
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<OfficeTransaction> Transactions = new ArrayList<OfficeTransaction>();
            while (rs.next()) {
                oT = new OfficeTransaction();
                oT.setTerms(rs.getInt("terms"));
                oT.setDateRecorded(rs.getDate("date"));
                oT.setDateOfPayment(rs.getDate("dateOfPayment"));
                oT.setID(rs.getBigDecimal(("officeId")).toBigInteger());
                oT.setDateOfDelivery(rs.getDate("dateReceived"));
                oT.setInVoice(rs.getString("invoice"));
                oT.setTransactor(oI.getOffice(rs.getBigDecimal(("officeId")).toBigInteger()).getName());
                oT.setSBD(rs.getString("inVoice"));
                oT.setTotal(rs.getDouble("total"));
                Transactions.add(oT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public @Override
    ArrayList<OfficeTransaction> getAllTransactionOffice() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from SalesTransaction where officeId is not null order by date;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<OfficeTransaction> Transactions = new ArrayList<OfficeTransaction>();
            while (rs.next()) {
                OfficeTransaction oT = new OfficeTransaction();
                oT.setTerms(rs.getInt("terms"));
                oT.setDateRecorded(rs.getDate("date"));
                oT.setDateOfPayment(rs.getDate("dateOfPayment"));
                oT.setID(rs.getBigDecimal(("officeId")).toBigInteger());
                oT.setDateOfDelivery(rs.getDate("dateReceived"));
                oT.setInVoice(rs.getString("invoice"));
                oT.setTransactor(oI.getOffice(rs.getBigDecimal(("officeId")).toBigInteger()).getName());
                oT.setSBD(rs.getString("inVoice"));
                oT.setTotal(rs.getDouble("total"));
                Transactions.add(oT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public void insertDateOfPayment(String iV) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
	    java.util.Date d = new java.util.Date();

            String query = "update SalesTransaction set dateOfPayment = ? where inVoice = ? and officeid is not null;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, new Date(d.getTime()));
            preparedStatement.setString(2, iV);
            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insertDateOfDelivery(String iV) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            java.util.Date d = new java.util.Date();

            String query = "update SalesTransaction set dateReceived = ? where inVoice = ? and officeid is not null;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, new Date(d.getTime()));
            preparedStatement.setString(2, iV);
            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<OfficeTransaction> getAllOfficeTransactionByTerms() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from SalesTransaction where officeId is not null order by terms;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<OfficeTransaction> Transactions = new ArrayList<OfficeTransaction>();
            while (rs.next()) {
                OfficeTransaction oT = new OfficeTransaction();
                oT.setTerms(rs.getInt("terms"));
                oT.setDateRecorded(rs.getDate("date"));
                oT.setDateOfPayment(rs.getDate("dateOfPayment"));
                oT.setID(rs.getBigDecimal(("officeId")).toBigInteger());
                oT.setDateOfDelivery(rs.getDate("dateReceived"));
                oT.setInVoice(rs.getString("invoice"));
                oT.setTransactor(oI.getOffice(rs.getBigDecimal(("officeId")).toBigInteger()).getName());
                oT.setSBD(rs.getString("inVoice"));
                oT.setTotal(rs.getDouble("total"));
                Transactions.add(oT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<OfficeTransaction> getAllTransactionOfficeSortByInvoice() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from SalesTransaction where officeId is not null order by inVoice;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<OfficeTransaction> Transactions = new ArrayList<OfficeTransaction>();
            while (rs.next()) {
                OfficeTransaction oT = new OfficeTransaction();
                oT.setTerms(rs.getInt("terms"));
                oT.setDateRecorded(rs.getDate("date"));
                oT.setDateOfPayment(rs.getDate("dateOfPayment"));
                oT.setID(rs.getBigDecimal(("officeId")).toBigInteger());
                oT.setDateOfDelivery(rs.getDate("dateReceived"));
                oT.setInVoice(rs.getString("invoice"));
                oT.setTransactor(oI.getOffice(rs.getBigDecimal(("officeId")).toBigInteger()).getName());
                oT.setSBD(rs.getString("inVoice"));
                oT.setTotal(rs.getDouble("total"));
                Transactions.add(oT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<OfficeTransaction> getAllTransactionOfficeSortByTotal() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from SalesTransaction where officeId is not null order by total;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<OfficeTransaction> Transactions = new ArrayList<OfficeTransaction>();
            while (rs.next()) {
                OfficeTransaction oT = new OfficeTransaction();
                oT.setTerms(rs.getInt("terms"));
                oT.setDateRecorded(rs.getDate("date"));
                oT.setDateOfPayment(rs.getDate("dateOfPayment"));
                oT.setID(rs.getBigDecimal(("officeId")).toBigInteger());
                oT.setDateOfDelivery(rs.getDate("dateReceived"));
                oT.setInVoice(rs.getString("invoice"));
                oT.setTransactor(oI.getOffice(rs.getBigDecimal(("officeId")).toBigInteger()).getName());
                oT.setSBD(rs.getString("inVoice"));
                oT.setTotal(rs.getDouble("total"));
                Transactions.add(oT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
     public ArrayList<OfficeTransaction> getAllTransactionOfficeSortByName() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "SELECT * from SalesTransaction s,office o where s.officeId=o.officeId order by o.name;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<OfficeTransaction> Transactions = new ArrayList<OfficeTransaction>();
            while (rs.next()) {
                OfficeTransaction oT = new OfficeTransaction();
                oT.setTerms(rs.getInt("terms"));
                oT.setDateRecorded(rs.getDate("date"));
                oT.setDateOfPayment(rs.getDate("dateOfPayment"));
                oT.setID(rs.getBigDecimal(("officeId")).toBigInteger());
                oT.setDateOfDelivery(rs.getDate("dateReceived"));
                oT.setInVoice(rs.getString("invoice"));
                oT.setTransactor(oI.getOffice(rs.getBigDecimal(("officeId")).toBigInteger()).getName());
                oT.setSBD(rs.getString("inVoice"));
                oT.setTotal(rs.getDouble("total"));
                Transactions.add(oT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}

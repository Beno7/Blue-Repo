/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import Interfaces.SupplierTransInterface;

import Logic.SupplierTransaction;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Win 7
 */
public class SupplierTransImpl implements SupplierTransInterface {

    private Connection connection;
    private DBconnection dBConnection;

	private SupplierImpl sI = new SupplierImpl();

    public @Override
    boolean addSupplierTransaction(SupplierTransaction sT) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "insert into suppliertrans(supplierId,inVoice,terms,dateRecorded,dateOfPayment,dateReceived,total) "
                    + "values (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setBigDecimal(1, new BigDecimal(sT.getID()));
            preparedStatement.setString(2, sT.getInVoice());
            preparedStatement.setInt(3, sT.getTerms());
            preparedStatement.setDate(4, new Date(sT.getDateRecorded().getTime()));
            if(sT.getDateOfPayment()!=null)
                preparedStatement.setDate(5, new Date(sT.getDateOfPayment().getTime()));
            else
                preparedStatement.setDate(5, null);
            if(sT.getDateOfDelivery()!=null)
                preparedStatement.setDate(6, new Date(sT.getDateOfDelivery().getTime()));
            else
                preparedStatement.setDate(6, null);
            preparedStatement.setDouble(7, sT.getTotal());
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public SupplierTransaction getSupplierTransaction(String inVoice) {
        try {
            sI = new SupplierImpl();
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            SupplierTransaction sT = new SupplierTransaction();
            String query = "select * from suppliertrans where inVoice = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                sT.setTerms(rs.getInt("terms"));
                sT.setDateRecorded(rs.getDate("dateRecorded"));
                sT.setDateOfPayment(rs.getDate("dateOfPayment"));
                sT.setID(rs.getBigDecimal(("supplierId")).toBigInteger());
                sT.setDateOfDelivery(rs.getDate("dateReceived"));
                sT.setInVoice(inVoice);
                sT.setTransactor(sI.getSupplier(rs.getBigDecimal(("supplierId")).toBigInteger()).getName());
                sT.setSBD(rs.getString("inVoice"));
                sT.setTotal(rs.getDouble("total"));

                return sT;
            }
            else{
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<SupplierTransaction> getAllSupplierTransaction(BigInteger supplierId) {
        try {
			sI = new SupplierImpl();
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from suppliertrans where supplierId = ? order by dateRecorded;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, new BigDecimal(supplierId));
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<SupplierTransaction> Transactions = new ArrayList<SupplierTransaction>();
            while (rs.next()) {
                SupplierTransaction sT = new SupplierTransaction();
                sT.setTerms(rs.getInt("terms"));
                sT.setDateRecorded(rs.getDate("dateRecorded"));
                sT.setDateOfPayment(rs.getDate("dateOfPayment"));
                sT.setDateOfDelivery(rs.getDate("dateReceived"));
                sT.setID(rs.getBigDecimal("supplierId").toBigInteger());
                sT.setInVoice(rs.getString("inVoice"));
				sT.setTransactor(sI.getSupplier(rs.getBigDecimal(("supplierId")).toBigInteger()).getName());
                                sT.setSBD(rs.getString("inVoice"));
                sT.setTotal(rs.getDouble("total"));

                Transactions.add(sT);
            }
            connection.close();
            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<SupplierTransaction> getAllTransactionSupplier() {
        try {
			sI = new SupplierImpl();
			SupplierTransaction sT;
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from suppliertrans order by dateRecorded;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<SupplierTransaction> Transactions = new ArrayList<SupplierTransaction>();
            while (rs.next()) {
				sT = new SupplierTransaction();
                sT.setTerms(rs.getInt("terms"));
                sT.setDateRecorded(rs.getDate("dateRecorded"));
                sT.setDateOfPayment(rs.getDate("dateOfPayment"));
                sT.setDateOfDelivery(rs.getDate("dateReceived"));
                sT.setID(rs.getBigDecimal("supplierId").toBigInteger());
                sT.setInVoice(rs.getString("inVoice"));
				sT.setTransactor(sI.getSupplier(rs.getBigDecimal(("supplierId")).toBigInteger()).getName());
                                sT.setSBD(rs.getString("inVoice"));
                sT.setTotal(rs.getDouble("total"));

                Transactions.add(sT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public void insertDateOfPayment(String iV) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
			java.util.Date d = new java.util.Date();

            String query = "update suppliertrans set dateOfPayment = ? where inVoice = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, new Date(d.getTime()));
            preparedStatement.setString(2, iV);
            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SupplierTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertDateOfDelivery(String iV) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
			java.util.Date d = new java.util.Date();

            String query = "update suppliertrans set dateReceived = ? where inVoice = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, new Date(d.getTime()));
            preparedStatement.setString(2, iV);
            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SupplierTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<SupplierTransaction> getAllSupplierTransactionByTerms() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "SELECT * from supplierTrans order by terms";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<SupplierTransaction> Transactions = new ArrayList<SupplierTransaction>();
            while (rs.next()) {
                SupplierTransaction sT = new SupplierTransaction();
                sT.setTerms(rs.getInt("terms"));
                sT.setDateRecorded(rs.getDate("dateRecorded"));
                sT.setDateOfPayment(rs.getDate("dateOfPayment"));
                sT.setDateOfDelivery(rs.getDate("dateReceived"));
                sT.setID(rs.getBigDecimal("supplierId").toBigInteger());
                sT.setInVoice(rs.getString("inVoice"));
		sT.setTransactor(sI.getSupplier(rs.getBigDecimal(("supplierId")).toBigInteger()).getName());
                sT.setSBD(rs.getString("inVoice"));
                sT.setTotal(rs.getDouble("total"));
                Transactions.add(sT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<SupplierTransaction> getAllTransactionSupplierSortByInvoice() {
         try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "SELECT * from supplierTrans order by inVoice";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<SupplierTransaction> Transactions = new ArrayList<SupplierTransaction>();
            while (rs.next()) {
                SupplierTransaction sT = new SupplierTransaction();
                sT.setTerms(rs.getInt("terms"));
                sT.setDateRecorded(rs.getDate("dateRecorded"));
                sT.setDateOfPayment(rs.getDate("dateOfPayment"));
                sT.setDateOfDelivery(rs.getDate("dateReceived"));
                sT.setID(rs.getBigDecimal("supplierId").toBigInteger());
                sT.setInVoice(rs.getString("inVoice"));
		sT.setTransactor(sI.getSupplier(rs.getBigDecimal(("supplierId")).toBigInteger()).getName());
                sT.setSBD(rs.getString("inVoice"));
                sT.setTotal(rs.getDouble("total"));
                Transactions.add(sT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<SupplierTransaction> getAllTransactionSupplierSortByTotal() {
            try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "SELECT * from supplierTrans order by total";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<SupplierTransaction> Transactions = new ArrayList<SupplierTransaction>();
            while (rs.next()) {
                SupplierTransaction sT = new SupplierTransaction();
                sT.setTerms(rs.getInt("terms"));
                sT.setDateRecorded(rs.getDate("dateRecorded"));
                sT.setDateOfPayment(rs.getDate("dateOfPayment"));
                sT.setDateOfDelivery(rs.getDate("dateReceived"));
                sT.setID(rs.getBigDecimal("supplierId").toBigInteger());
                sT.setInVoice(rs.getString("inVoice"));
		sT.setTransactor(sI.getSupplier(rs.getBigDecimal(("supplierId")).toBigInteger()).getName());
                sT.setSBD(rs.getString("inVoice"));
                sT.setTotal(rs.getDouble("total"));
                Transactions.add(sT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    public ArrayList<SupplierTransaction> getAllTransactionSupplierSortByName() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "SELECT * from supplierTrans s,supplier sp where s.supplierId=sp.supplierId order by sp.name;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<SupplierTransaction> Transactions = new ArrayList<SupplierTransaction>();
            while (rs.next()) {
                SupplierTransaction sT = new SupplierTransaction();
                sT.setTerms(rs.getInt("terms"));
                sT.setDateRecorded(rs.getDate("dateRecorded"));
                sT.setDateOfPayment(rs.getDate("dateOfPayment"));
                sT.setDateOfDelivery(rs.getDate("dateReceived"));
                sT.setID(rs.getBigDecimal("supplierId").toBigInteger());
                sT.setInVoice(rs.getString("inVoice"));
		sT.setTransactor(sI.getSupplier(rs.getBigDecimal(("supplierId")).toBigInteger()).getName());
                sT.setSBD(rs.getString("inVoice"));
                sT.setTotal(rs.getDouble("total"));
                Transactions.add(sT);
            }
            connection.close();

            return Transactions;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    public ArrayList<HashMap<BigInteger,Integer>> getFastMoving() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select sd.itemId, count(sd.itemId) from supplierTrans st,\n"
                    + "supplierBundleList sd where st.inVoice = sd.inVoice group by \n"
                    + "sd.itemId order by count(sd.itemId) desc;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<HashMap<BigInteger,Integer>> ints = new ArrayList<>();
            for(int i=0;i<5;i++){
                if(rs.next()){
                    BigInteger p = rs.getBigDecimal("itemId").toBigInteger();
                    Integer count = rs.getInt("count(sd.itemId)");
                    HashMap<BigInteger,Integer> a = new HashMap();
                    a.put(p, count);

                  ints.add(a);
                }
                else
                    return ints;
            }
            
            return ints;

        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}

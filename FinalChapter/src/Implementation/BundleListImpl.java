/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import Interfaces.BundleListInterface;
import Logic.BreakDown;
import java.math.BigInteger;
import java.math.BigDecimal;
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
public class BundleListImpl{// implements BundleListInterface {

    private Connection connection;
    private DBconnection dBConnection;
    
    public boolean addSupplierBundle(BreakDown b) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into supplierBundleList(quantity,itemId,inVoice,price) values (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, b.getQuantity());
            preparedStatement.setBigDecimal(2, new BigDecimal(b.getBundleID()));
            preparedStatement.setString(3, b.getInVoice());
            preparedStatement.setDouble(4, b.getPrice());

            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean addSupplierBundle(String inVoice, BigInteger bundleId, int quantity) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into supplierBundleList(quantity,itemId,inVoice) values (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setBigDecimal(2, new BigDecimal(bundleId));
            preparedStatement.setString(3, inVoice);

            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public ArrayList<BreakDown> getSupplierBundle(String inVoice) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from supplierBundleList where inVoice = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<BreakDown> bDs = new ArrayList();
            while (rs.next()) {
                bDs.add(new BreakDown());
                bDs.get(bDs.size()-1).setBundleID(rs.getBigDecimal("itemId").toBigInteger());
                bDs.get(bDs.size()-1).setPrice(rs.getDouble("price"));
                bDs.get(bDs.size()-1).setQuantity(rs.getInt("quantity"));
                bDs.get(bDs.size()-1).setInVoice(rs.getString("inVoice"));
            }

            connection.close();

            return bDs;
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getSTransactionQuantity(String inVoice, BigInteger bundleId) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select quantity from supplierBundleList where inVoice = ? AND ItemId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            preparedStatement.setBigDecimal(2, new BigDecimal(bundleId));
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int p = rs.getInt("quantity");
                return p;
            } else {
                connection.close();
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public boolean addSalesTransDetails(BreakDown b) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into SalesTransDetail(qty,ItemId,inVoice,price) values (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, b.getQuantity());
            preparedStatement.setBigDecimal(2, new BigDecimal(b.getBundleID()));
            preparedStatement.setString(3, b.getInVoice());
            preparedStatement.setDouble(4, b.getPrice());

            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;

    }

    public ArrayList<Integer> getSalesTransDetails(String inVoice) {
      try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from SalesTransDetail where inVoice = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Integer> integers = new ArrayList();
            int b;
            while (rs.next()) {
              
                b=rs.getInt("ItemId");
                integers.add(b);
            }

            connection.close();

            return integers;
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<BreakDown> getSalesBD(String inVoice) {
      try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from SalesTransDetail where inVoice = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<BreakDown> integers = new ArrayList();
            while (rs.next()) {
              
                integers.add(new BreakDown(inVoice, rs.getInt("qty"), rs.getBigDecimal("itemId").toBigInteger(), rs.getDouble("price")));
            }

            connection.close();

            return integers;
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTransactionQuantity(String inVoice, BigInteger bundleId) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select qty from SalesTransDetail where inVoice = ? AND ItemID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            preparedStatement.setBigDecimal(2, new BigDecimal(bundleId));
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int p = rs.getInt("qty");
                return p;
            } else {
                connection.close();
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public double getSupplierPrice(String inVoice, BigInteger bundleId){
    try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select qty from supplierBundleList where inVoice = ? AND ItemID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            preparedStatement.setBigDecimal(2, new BigDecimal(bundleId));
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int p = rs.getInt("price");
                return p;
            } else {
                connection.close();
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0;
    
    }

     public double getPrice(String inVoice, int bundleId){
         try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select qty from SalesTransDetail where inVoice = ? AND ItemId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            preparedStatement.setInt(2, bundleId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int p = rs.getInt("price");
                return p;
            } else {
                connection.close();
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
     }


    

  
}

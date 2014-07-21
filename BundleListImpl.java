/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import Interfaces.BundleListInterface;
import Logic.Bundle;
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
public class BundleListImpl implements BundleListInterface {

    private Connection connection;
    private DBconnection dBConnection;

    public boolean addSupplierBundle(String inVoice, Bundle b, int quantity) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into sBundleList(quantity,measurement,packSellPrice,brandName,name,inVoice,unit) values (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, b.getMeasurement());
            preparedStatement.setDouble(3, b.getPackSellPrice());
            preparedStatement.setString(4, b.getBrandName());
            preparedStatement.setString(5, b.getName());
            preparedStatement.setString(6, inVoice);
            preparedStatement.setString(7, b.getUnit());

            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public ArrayList<Bundle> getSupplierBundle(String inVoice) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from sBundleList where inVoice = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Bundle> bundle = new ArrayList();
            Bundle b;
            while (rs.next()) {
                b = new Bundle();
                b.setPackSellPrice(rs.getDouble("packSellPrice"));
                b.setMeasurement(rs.getInt("measurement"));
                b.setUnit(rs.getString("unit"));
                b.setName(rs.getString("name"));
                b.setBrandName(rs.getString("brandName"));
                bundle.add(b);
            }

            connection.close();

            return bundle;
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getSTransactionQuantity(String inVoice,String brandName,String name,String unit) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select quantity from sBundleList where inVoice = ? AND brandName = ? AND name = ? AND unit = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            preparedStatement.setString(2, brandName);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, unit);
            ResultSet rs = preparedStatement.executeQuery();
          
            if(rs.next()){
                int p = rs.getInt("quantity");
                return p;
            }else{ 
                connection.close();
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


    public boolean addOfficeBundle(String inVoice, Bundle b, int quantity) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into oBundleList(quantity,measurement,packSellPrice,brandName,name,inVoice,unit) values (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, b.getMeasurement());
            preparedStatement.setDouble(3, b.getPackSellPrice());
            preparedStatement.setString(4, b.getBrandName());
            preparedStatement.setString(5, b.getName());
            preparedStatement.setString(6, inVoice);
            preparedStatement.setString(7, b.getUnit());

            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public ArrayList<Bundle> getOfficeBundle(String inVoice) {
        try {
            
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from oBundleList where inVoice = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Bundle> bundle = new ArrayList();
            while (rs.next()) {
                Bundle b = new Bundle();
                b.setPackSellPrice(rs.getDouble("packSellPrice"));
                b.setMeasurement(rs.getInt("measurement"));
                b.setUnit(rs.getString("unit"));
                b.setName(rs.getString("name"));
                b.setBrandName(rs.getString("brandName"));
                bundle.add(b);
            }

            connection.close();

            return bundle;
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public int getOTransactionQuantity(String inVoice,String brandName,String name, String unit) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select quantity from oBundleList where inVoice = ? AND brandName = ? AND name = ? AND unit = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            preparedStatement.setString(1, inVoice);
            preparedStatement.setString(2, brandName);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, unit);
            ResultSet rs = preparedStatement.executeQuery();
          
            if(rs.next()){
                int p = rs.getInt("quantity");
                return p;
            }else{ 
                connection.close();
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}

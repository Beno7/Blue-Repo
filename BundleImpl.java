/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import Interfaces.BundleInterface;
import Logic.Bundle;
import Logic.Supplier;

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
public class BundleImpl implements BundleInterface {

    private Connection connection;
    private DBconnection dBConnection;

    public boolean addBundle(Bundle b) {
        try {
            Supplier supplier = new Supplier();
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into Bundle(unit,measurement,packSellPrice,stock,brandName,name,supplierName) values (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, b.getUnit());
            preparedStatement.setInt(2, b.getMeasurement());
            preparedStatement.setDouble(3, b.getPackSellPrice());
            preparedStatement.setInt(4, b.getStocks());
            preparedStatement.setString(5, b.getBrandName());
            preparedStatement.setString(6, b.getName());
            preparedStatement.setString(7, b.getSupplier());
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public @Override Bundle getBundle(String brandName, String name, String unit) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            Bundle b = new Bundle();
            String query = "select * from bundle where brandName = ? AND name = ? AND unit = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, brandName);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, unit);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                b.setBrandName(brandName);
                b.setName(name);
                b.setMeasurement(rs.getInt("measurement"));
                b.setUnit(unit);
                b.setPackSellPrice(rs.getDouble("packSellPrice"));
                b.setStocks(rs.getInt("stock"));
                b.setSupplier(rs.getString("supplierName"));
            return b;
            } else{
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateStock(String brandName, String name, int stock, String unit) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "update Bundle SET stock = ? where brandName = ? AND name = ? AND unit = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, stock);
            preparedStatement.setString(2, brandName);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, unit);
            preparedStatement.executeUpdate();

            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public @Override boolean updateSupplier(String brandName, String name, String supplier, String unit) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "update Bundle SET supplierName = ? where brandName = ? AND name = ? AND unit = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, supplier);
            preparedStatement.setString(2, brandName);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, unit);
            preparedStatement.executeUpdate();

            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Bundle> getAllBundle() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "select * from bundle;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Bundle> bundle = new ArrayList();
            while (rs.next()) {
                Bundle b = new Bundle();
                b.setBrandName(rs.getString("brandName"));
                b.setName(rs.getString("name"));
                b.setMeasurement(rs.getInt("measurement"));
                b.setUnit(rs.getString("unit"));
                b.setPackSellPrice(rs.getDouble("packSellPrice"));
                b.setStocks(rs.getInt("stock"));
                b.setSupplier(rs.getString("supplierName"));
                bundle.add(b);
            }
            connection.close();
            return bundle;
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}

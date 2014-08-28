/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import Interfaces.BundleInterface;
import Logic.Item;
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
public class BundleImpl implements BundleInterface {

    private Connection connection;
    private DBconnection dBConnection;

    public @Override
    boolean addBundle(Item b) {
        try {

            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into Item(unit,QtyPerBundle,stock,brandName,name,IdealStock,Location,unitPrice) values (?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, b.getUnit());
            preparedStatement.setInt(2, b.getQtyPerBundle());
            preparedStatement.setInt(3, b.getStock());
            preparedStatement.setString(4, b.getBrandName());
            preparedStatement.setString(5, b.getName());
            preparedStatement.setInt(6, b.getIdealStock());
            preparedStatement.setString(7, b.getLocation());
            preparedStatement.setDouble(8, b.getUnitPrice());
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public @Override
    Item getBundle(String brandName, String name, String unit) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            Item b = new Item();
            String query = "select * from Item where brandName = ? AND name = ? AND unit = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, brandName);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, unit);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                b.setBrandName(brandName);
                b.setName(name);
                b.setQtyPerBundle(rs.getInt("QtyPerBundle"));
                b.setIdealStock(rs.getInt("IdealStock"));
                b.setUnit(unit);
                b.setStock(rs.getInt("stock"));
                b.setItemID(rs.getBigDecimal("ItemId").toBigInteger());
                b.setLocation(rs.getString("Location"));
                return b;
            } else {
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public @Override
    boolean updateStock(BigInteger itemId, int stock) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "update Item SET stock = ? where ItemId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, stock);
            preparedStatement.setBigDecimal(2, new BigDecimal(itemId));
            preparedStatement.executeUpdate();

            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    public @Override
    ArrayList<Item> getAllBundle() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "select * from Item where unit is not null;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Item> bundle = new ArrayList();
            while (rs.next()) {
                Item b = new Item();
                b.setBrandName(rs.getString("brandName"));
                b.setName(rs.getString("name"));
                b.setQtyPerBundle(rs.getInt("QtyPerBundle"));
                b.setIdealStock(rs.getInt("IdealStock"));
                b.setUnit(rs.getString("unit"));
                b.setStock(rs.getInt("stock"));
                b.setItemID(rs.getBigDecimal("ItemId").toBigInteger());
                b.setLocation(rs.getString("Location"));
                bundle.add(b);
            }
            connection.close();
            return bundle;
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Item getBundle(BigInteger bundleId) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            Item b = new Item();
            String query = "select * from Item where ItemId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, new BigDecimal(bundleId));

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                b.setBrandName(rs.getString("brandName"));
                b.setName(rs.getString("name"));
                b.setQtyPerBundle(rs.getInt("QtyPerBundle"));
                b.setIdealStock(rs.getInt("IdealStock"));
                b.setUnit(rs.getString("unit"));
                b.setStock(rs.getInt("stock"));
                b.setItemID(rs.getBigDecimal("ItemId").toBigInteger());
                b.setLocation(rs.getString("Location"));
                return b;
            } else {
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    @Override
    public boolean editBundle(Item b,String brandName, String name, String unit) {
       try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "update  Item set unit = ?,QtyPerBundle = ?,brandName = ?,name = ?,Location = ?,IdealStock= ? where brandName = ? and name = ? and unit = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, b.getUnit());
            preparedStatement.setInt(2, b.getQtyPerBundle());
            preparedStatement.setInt(3, b.getStock());
            preparedStatement.setString(4, b.getBrandName());
            preparedStatement.setString(5, b.getName());
            preparedStatement.setString(6, b.getLocation());
            preparedStatement.setInt(7, b.getIdealStock());
            preparedStatement.setString(8, brandName);
            preparedStatement.setString(9, name);
            preparedStatement.setString(10, unit);
           
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
	@Override
	public ArrayList<Item> groupBundle() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "select * from Item group by brandName,name;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Item> bundle = new ArrayList();
            while (rs.next()) {
                Item b = new Item();
                b.setBrandName(rs.getString("brandName"));
                b.setName(rs.getString("name"));
                b.setQtyPerBundle(rs.getInt("QtyPerBundle"));
                b.setUnit(rs.getString("unit"));
                b.setStock(rs.getInt("stock"));
                b.setItemID(rs.getBigDecimal("itemId").toBigInteger());
                b.setLocation(rs.getString("Location"));
                b.setIdealStock(rs.getInt("IdealStock"));
                bundle.add(b);
            }
            connection.close();
            return bundle;
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	
	@Override
    public ArrayList<Item> getAllBundle(String name,String brandName) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "select * from Item where name = ? and brandName = ? and unit is not null;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, brandName);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Item> bundle = new ArrayList();
            while (rs.next()) {
                Item b = new Item();
                b.setBrandName(rs.getString("brandName"));
                b.setName(rs.getString("name"));
                b.setQtyPerBundle(rs.getInt("QtyPerBundle"));
                b.setUnit(rs.getString("unit"));
                b.setStock(rs.getInt("stock"));
                b.setItemID(rs.getBigDecimal("itemId").toBigInteger());
                b.setLocation(rs.getString("Location"));
                b.setIdealStock(rs.getInt("IdealStock"));
                bundle.add(b);
            }
            connection.close();
            return bundle;
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Item getLeast(String name,String brandName){
    try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            Item b = new Item();
            String query = "select * from Item where name = ? and brandName =  ? and unit is not null and stock > 0 order by QtyPerBundle;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, brandName);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                b.setBrandName(rs.getString("brandName"));
                b.setName(rs.getString("name"));
                b.setQtyPerBundle(rs.getInt("QtyPerBundle"));
                b.setUnit(rs.getString("unit"));
                b.setStock(rs.getInt("stock"));
                b.setItemID(rs.getBigDecimal("itemId").toBigInteger());
                b.setLocation(rs.getString("Location"));
                b.setIdealStock(rs.getInt("IdealStock"));
                return b;
            } else {
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
    @Override
    public ArrayList<Item> getSortByBrand(){
     try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "select * from Item where unit is not null order by brandName;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Item> bundle = new ArrayList();
            while (rs.next()) {
                Item b = new Item();
                b.setBrandName(rs.getString("brandName"));
                b.setName(rs.getString("name"));
                b.setQtyPerBundle(rs.getInt("QtyPerBundle"));
                b.setUnit(rs.getString("unit"));
                b.setStock(rs.getInt("stock"));
                b.setItemID(rs.getBigDecimal("itemId").toBigInteger());
                b.setLocation(rs.getString("Location"));
                b.setIdealStock(rs.getInt("IdealStock"));
                bundle.add(b);
            }
            connection.close();
            return bundle;
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Item> getLowSupply() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "select * from Item where unit is not null and IdealStock > stock;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Item> bundle = new ArrayList();
            while (rs.next()) {
                Item b = new Item();
                b.setBrandName(rs.getString("brandName"));
                b.setName(rs.getString("name"));
                b.setQtyPerBundle(rs.getInt("QtyPerBundle"));
                b.setUnit(rs.getString("unit"));
                b.setStock(rs.getInt("stock"));
                b.setItemID(rs.getBigDecimal("itemId").toBigInteger());
                b.setLocation(rs.getString("Location"));
                b.setIdealStock(rs.getInt("IdealStock"));
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

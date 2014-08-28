/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import Interfaces.ItemInterface;
import Logic.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigInteger;
import java.math.BigDecimal;

/**
 *
 * @author Win 7
 */
public class ItemImpl implements ItemInterface {

    private Connection connection;
    private DBconnection dBConnection;

    @Override
    public boolean addItem(Item i) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into Item(unitPrice,stock,brandName,name,location) values (?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, i.getUnitPrice());
            preparedStatement.setInt(2, i.getStock());
            preparedStatement.setString(3, i.getBrandName());
            preparedStatement.setString(4, i.getName());
            preparedStatement.setString(5, i.getLocation());

            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ItemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Item getItem(String name, String brandName) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from Item where name = ? and brandName = ? and unit is null;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, brandName);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                Item i = new Item();
                i.setBrandName(brandName);
                i.setName(name);
                i.setUnitPrice(rs.getDouble("unitPrice"));
                i.setStock(rs.getInt("stock"));
                i.setLocation(rs.getString("location"));
                i.setItemID(rs.getBigDecimal("itemid").toBigInteger());
            return i;
            }
            connection.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ItemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Item getItem(BigInteger itemId) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from Item where ItemId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, new BigDecimal(itemId));
            
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                Item i = new Item();
                i.setBrandName(rs.getString("brandName"));
                i.setName(rs.getString("name"));
                i.setUnitPrice(rs.getDouble("unitPrice"));
                i.setStock(rs.getInt("stock"));
                    i.setItemID(rs.getBigDecimal("itemid").toBigInteger());
            return i;
            }
            
            connection.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ItemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public ArrayList<Item> getAllItems() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from Item where unit is null;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ArrayList<Item> items = new ArrayList<>();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Item i = new Item();
                i.setName(rs.getString("name"));
                i.setBrandName(rs.getString("brandName"));
                i.setUnitPrice(rs.getDouble("unitPrice"));
                i.setStock(rs.getInt("stock"));
                i.setItemID(rs.getBigDecimal("itemid").toBigInteger());
                items.add(i);
            }

            connection.close();

            return items;
        } catch (SQLException ex) {
            Logger.getLogger(ItemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    @Override
    public void updateStock(String name, String brandName,int stock) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "update Item SET stock = ? where brandName = ? AND name = ? and unit is null;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, stock);
            preparedStatement.setString(2, brandName);
            preparedStatement.setString(3, name);
           
            preparedStatement.executeUpdate();

            connection.close();

            
        } catch (SQLException ex) {
            Logger.getLogger(ItemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      

    }
	
    @Override
    public void updatePrice(String name, String brandName, int price) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "update Item SET unitPrice = ? where brandName = ? AND name = ? and unit is null;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, price);
            preparedStatement.setString(2, brandName);
            preparedStatement.setString(3, name);
           
            preparedStatement.executeUpdate();

            connection.close();

            
        } catch (SQLException ex) {
            Logger.getLogger(ItemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    @Override
    public ArrayList<Item> getSortByBrandName() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from Item where unit is null order by brandName;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ArrayList<Item> items = new ArrayList<>();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Item i = new Item();
                i.setName(rs.getString("name"));
                i.setBrandName(rs.getString("brandName"));
                i.setUnitPrice(rs.getDouble("unitPrice"));
                i.setStock(rs.getInt("stock"));
                i.setItemID(rs.getBigDecimal("itemid").toBigInteger());
                items.add(i);
            }

            connection.close();

            return items;
        } catch (SQLException ex) {
            Logger.getLogger(ItemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<Item> getSortByPrice() {
       try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from Item where unit is null order by unitPrice;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ArrayList<Item> items = new ArrayList<>();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Item i = new Item();
                i.setName(rs.getString("name"));
                i.setBrandName(rs.getString("brandName"));
                i.setUnitPrice(rs.getDouble("unitPrice"));
                i.setStock(rs.getInt("stock"));
                i.setItemID(rs.getBigDecimal("itemid").toBigInteger());
                items.add(i);
            }

            connection.close();

            return items;
        } catch (SQLException ex) {
            Logger.getLogger(ItemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    

}

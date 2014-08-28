/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Implementation;

import Connection.DBconnection;
import Interfaces.ItemListInterface;
import Logic.Item;
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
public class ItemListImpl implements ItemListInterface {
    private Connection connection;
    private DBconnection dBConnection;
    @Override
    public void addItemList(int itemId,String inVoice,int quantity,double price) {
         try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into ItemList(quantity,price,inVoice,itemId) values (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, inVoice);
            preparedStatement.setInt(4, itemId);
          

            preparedStatement.executeUpdate();
            connection.close();

           
        } catch (SQLException ex) {
            Logger.getLogger(ItemListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public ArrayList<Integer> getItemIdList(String inVoice) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from ItemList where inVoice = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Integer> Integer = new ArrayList();
            int i;
            while (rs.next()) {
                
               
                i = rs.getInt("ItemId");
                Integer.add(i);
            }

            connection.close();

            return Integer;
        } catch (SQLException ex) {
            Logger.getLogger(BundleListImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int getQuantity(String inVoice, int itemId) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select quantity from ItemList where inVoice = ? AND itemIdId= ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            preparedStatement.setInt(2, itemId);
;
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
    
    public double getPrice(String inVoice, int itemId){    
    try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select price from ItemList where inVoice = ? AND itemIdId= ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inVoice);
            preparedStatement.setInt(2, itemId);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                double p = rs.getDouble("price");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import Interfaces.PriceInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Win 7
 */
public class PriceImpl implements PriceInterface {

    private Connection connection;
    private DBconnection dBConnection;

    public boolean addPrice(double price, String brandName, String name, String unit, String supplier) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into prices(supplierName,price,brandName,name,unit) values (?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, supplier);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, brandName);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, unit);
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public double getPrice(String brandName,String name,String unit,String supplier){
     try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select price from prices where supplierName = ? and brandName = ? and name = ? and unit = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, supplier);
            preparedStatement.setString(2, brandName);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, unit);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                double p = rs.getDouble("price");
                return p;
            }else{ 
                connection.close();
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    
    }
}

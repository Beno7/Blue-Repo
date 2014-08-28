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
import Logic.PriceBean;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Win 7
 */
public class PriceImpl implements PriceInterface {

    private Connection connection;
    private DBconnection dBConnection;

    @Override
    public boolean addPrice(PriceBean pB) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into prices(supplierId,userprice,itemId,supplierPrice) values (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, new BigDecimal(pB.getSupplierID()));
            preparedStatement.setDouble(2, pB.getUserPrice());
            preparedStatement.setBigDecimal(3, new BigDecimal(pB.getBundleID()));
            preparedStatement.setDouble(4, pB.getSupplierPrice());

            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean updatePrice(PriceBean pB) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "update prices set supplierPrice = ?, userPrice = ? where itemID = ? and supplierID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(4, new BigDecimal(pB.getSupplierID()));
            preparedStatement.setDouble(2, pB.getUserPrice());
            preparedStatement.setBigDecimal(3, new BigDecimal(pB.getBundleID()));
            preparedStatement.setDouble(1, pB.getSupplierPrice());

            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public double getUserPrice(BigInteger bundleId, BigInteger supplierId) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select userprice from prices where supplierId = ? and itemId = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, new BigDecimal(supplierId));
            preparedStatement.setBigDecimal(2, new BigDecimal(bundleId));

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                double p = rs.getDouble("Userprice");
                return p;
            } else {
                connection.close();
                return 0.0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0;
    }

    @Override
    public ArrayList<PriceBean> getSupplierBundles(BigInteger supplierId) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select price from prices where supplierId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, new BigDecimal(supplierId));
            ArrayList<PriceBean> sBs = new ArrayList();
            PriceBean temp;
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                temp = new PriceBean();
                temp.setBundleID(rs.getBigDecimal("itemid").toBigInteger());
                temp.setSupplierID(supplierId);
                temp.setUserPrice(rs.getDouble("Userprice"));
                temp.setSupplierPrice(rs.getDouble("supplierprice"));
                sBs.add(temp);
            }
            if(sBs.size()>0)
                return sBs;
            else{
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public double getSupplierPrice(BigInteger bundleId, BigInteger supplierId) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from prices where supplierId = ? and itemId = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, new BigDecimal(supplierId));
            preparedStatement.setBigDecimal(2, new BigDecimal(bundleId));

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                double p = rs.getDouble("supplierprice");
                return p;
            } else {
                connection.close();
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    @Override
    public PriceBean getPriceBean(BigInteger bundleId, BigInteger supplierId) {
        try {
            PriceBean pB = new PriceBean();
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from prices where supplierId = ? and itemId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, new BigDecimal(supplierId));
            preparedStatement.setBigDecimal(2, new BigDecimal(bundleId));

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                pB.setSupplierID(supplierId);
                pB.setBundleID(bundleId);
                pB.setUserPrice(rs.getDouble("Userprice"));
                pB.setSupplierPrice(rs.getDouble("supplierprice"));
                return pB;
            } else {
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<PriceBean> getPriceBean(BigInteger bundleId) {
        try {

            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from prices where itemId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setBigDecimal(1, new BigDecimal(bundleId));
            ArrayList<PriceBean> prices = new ArrayList();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PriceBean pB = new PriceBean();
                pB.setSupplierID(BigInteger.valueOf(rs.getLong("supplierId")));
                pB.setBundleID(bundleId);
                pB.setUserPrice(rs.getDouble("Userprice"));
                pB.setSupplierPrice(rs.getDouble("supplierprice"));
                prices.add(pB);
            } 
                return prices;
        } catch (SQLException ex) {
            Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public ArrayList<PriceBean> getPriceSupplier(BigInteger supplierId) {
        try {

            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from prices where supplierId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setBigDecimal(1, new BigDecimal(supplierId));
            ArrayList<PriceBean> prices = new ArrayList();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PriceBean pB = new PriceBean();
                pB.setBundleID(BigInteger.valueOf(rs.getLong("itemId")));
                pB.setSupplierID(supplierId);
                pB.setUserPrice(rs.getDouble("Userprice"));
                pB.setSupplierPrice(rs.getDouble("supplierprice"));
                prices.add(pB);
            } 
                return prices;
        } catch (SQLException ex) {
            Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public ArrayList<PriceBean> sortPrice(){
    try {

            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from prices ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ArrayList<PriceBean> prices = new ArrayList();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PriceBean pB = new PriceBean();
                pB.setSupplierID(BigInteger.valueOf(rs.getLong("supplierId")));
                pB.setBundleID(BigInteger.valueOf(rs.getLong("ItemId")));
                pB.setUserPrice(rs.getDouble("Userprice"));
                pB.setSupplierPrice(rs.getDouble("supplierprice"));
                prices.add(pB);
            }
                connection.close();
                return prices;
        } catch (SQLException ex) {
            Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Connection.DBconnection;
import Interfaces.OfficeInterface;
import Logic.Office;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class OfficeImpl implements OfficeInterface {

    private Connection connection;
    private DBconnection dBConnection;

    @Override
    public boolean addOffice(Office o) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into office(name,contactNo,address,faxNo) values (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, o.getName());
            preparedStatement.setString(2, o.getContact());
            preparedStatement.setString(3, o.getAddress());
            preparedStatement.setString(4, o.getFaxNo());
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Office getOffice(String name) {
        try {
            Office office = new Office();
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from office where name = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                office.setName(rs.getString("name"));
                office.setContact(rs.getString("contactNo"));
                office.setFaxNo(rs.getString("faxNo"));
                office.setID(rs.getBigDecimal("officeId").toBigInteger());
                office.setAddress(rs.getString("address"));
                return office;
            } else {
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OfficeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Office> getAllOffice() {
        try {

            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from office order by name;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Office> office = new ArrayList();
            while (rs.next()) {
                Office o = new Office();
                o.setName(rs.getString("name"));
                o.setContact(rs.getString("contactNo"));
                o.setFaxNo(rs.getString("faxNo"));
                o.setID(rs.getBigDecimal("officeId").toBigInteger());
                o.setAddress(rs.getString("address"));
                office.add(o);
            }

            connection.close();

            return office;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Office getOffice(BigInteger officeId) {
        try {
            Office office = new Office();
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from office where officeId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1,new BigDecimal(officeId));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                office.setName(rs.getString("name"));
                office.setContact(rs.getString("contactNo"));
                office.setFaxNo(rs.getString("faxNo"));
                office.setID(officeId);
                office.setAddress(rs.getString("address"));
                return office;
            } else {
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OfficeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
    
    public ArrayList<Office> getAllOfficeSortByContactNo() {
        try {

            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from office order by contactNo;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Office> office = new ArrayList();
            while (rs.next()) {
                Office o = new Office();
                o.setName(rs.getString("name"));
                o.setContact(rs.getString("contactNo"));
                o.setFaxNo(rs.getString("faxNo"));
                o.setID(rs.getBigDecimal("officeId").toBigInteger());
                o.setAddress(rs.getString("address"));
                office.add(o);
            }

            connection.close();

            return office;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public ArrayList<Office> getAllOfficeSortByFaxNo() {
        try {

            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from office order by faxNo;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Office> office = new ArrayList();
            while (rs.next()) {
                Office o = new Office();
                o.setName(rs.getString("name"));
                o.setContact(rs.getString("contactNo"));
                o.setFaxNo(rs.getString("faxNo"));
                o.setID(rs.getBigDecimal("officeId").toBigInteger());
                o.setAddress(rs.getString("address"));
                office.add(o);
            }

            connection.close();

            return office;
        } catch (SQLException ex) {
            Logger.getLogger(OfficeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean editOffice(Office o) {
       try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "update office set address = ?,contactNo = ?,faxNo = ? where officeId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, o.getAddress());
            preparedStatement.setString(2, o.getContact());
            preparedStatement.setString(3, o.getFaxNo());
            preparedStatement.setBigDecimal(4, new BigDecimal(o.getID()));
            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SupplierTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
   
   
}

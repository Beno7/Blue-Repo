/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

/**
 *
 * @author Win 7
 */
import Interfaces.*;
import Connection.DBconnection;
import Logic.Supplier;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Logic.Supplier;
import java.math.BigDecimal;
import java.math.BigInteger;

public class SupplierImpl implements SupplierInterface {

    private Connection connection;
    private DBconnection dBConnection;

    public boolean addSupplier(Supplier s) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "insert into Supplier(name,contactNo,address,faxNo) values (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, s.getName());
            preparedStatement.setString(2, s.getContact());
            preparedStatement.setString(3, s.getAddress());
            preparedStatement.setString(4, s.getFaxNo());
            preparedStatement.executeUpdate();
            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public @Override
    Supplier getSupplier(String s) {
        try {
            Supplier supplier;
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from Supplier where name = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, s);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                supplier = new Supplier(rs.getString("name"), rs.getString("contactNo"), rs.getBigDecimal("supplierId").toBigInteger(), rs.getString("address"), rs.getString("faxNo"));
                return supplier;
            } else {
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Supplier> getAllSupplier() {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "select * from Supplier order by name;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Supplier> s = new ArrayList<Supplier>();
            while (rs.next()) {
                s.add(new Supplier(rs.getString("name"), rs.getString("contactNo"), rs.getBigDecimal("supplierId").toBigInteger(), rs.getString("address"), rs.getString("faxNo")));
            }
            connection.close();
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(SupplierImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Supplier getSupplier(BigInteger supplierId) {
        try {
            Supplier supplier;
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from Supplier where supplierId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, new BigDecimal(supplierId));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                supplier = new Supplier(rs.getString("name"), rs.getString("contactNo"), rs.getBigDecimal("supplierId").toBigInteger(), rs.getString("address"), rs.getString("faxNo"));
                return supplier;
            } else {
                connection.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	

    @Override
    public boolean editSupplier(Supplier s) {
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();

            String query = "update supplier set address = ?,contactNo = ?,faxNo = ? where supplierId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, s.getAddress());
            preparedStatement.setString(2, s.getContact());
            preparedStatement.setString(3, s.getFaxNo());
            preparedStatement.setBigDecimal(4, new BigDecimal(s.getID()));
            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(SupplierTransImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}

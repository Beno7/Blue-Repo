/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Connection.DBconnection;
import Implementation.BundleImpl;
import Implementation.OfficeImpl;
import Implementation.PriceImpl;
import Logic.BreakDown;
import Logic.Item;
import Logic.Manager;
import Logic.Office;
import Logic.OfficeTransaction;
import Logic.PriceBean;
import Logic.SBreakDownManager;
import Logic.Supplier;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raffy
 */
public class recordOT extends javax.swing.JFrame {

    /**
     * Creates new form recordOT
     */
    Item b;
    String s, s1, s2, b1, iV;
    int ctr, count, terms;
    Double d;
    Calendar c;
    Date d1;
    Supplier suppT;
    OfficeTransaction sT = null;
    Office otemp;
    String o, stemp;
    BigInteger bID=null, sID=null;
    DefaultTableModel tableQuery1 = new DefaultTableModel();
    DefaultTableModel tableQuery2 = new DefaultTableModel();
    DefaultTableModel tableQuery3 = new DefaultTableModel();
    DefaultTableModel tableQuery4 = new DefaultTableModel();
    private Connection connection;
    private DBconnection dBConnection;
                
    public recordOT() {
        initComponents();
        background2.setVisible(false);
        background3.setVisible(false);
        background4.setVisible(false);
        brand.setVisible(false);
        item.setVisible(false);
        next2.setVisible(false);
        pane3.setVisible(false);
        pack.setVisible(false);
        next3.setVisible(false);
        background3.setVisible(false);
        buysupp.setVisible(false);
        quantity.setVisible(false);
        confirm.setVisible(false);
        background4.setVisible(false);
        prev2.setVisible(false);
        try {
            tableQuery1 = (DefaultTableModel)officetable.getModel();
            tableQuery1.setRowCount(0); 
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            String query = "select * from office order by name;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Office> office = new ArrayList();
            while (rs.next()) {
                tableQuery1.insertRow(tableQuery1.getRowCount(), new Object[]{
                    rs.getString("name"),
                    rs.getString("contactNo"),
                    rs.getString("faxNo"),
                    rs.getString("address")
                });
            } 
        } catch (SQLException ex) {
            Logger.getLogger(OfficeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            dBConnection = DBconnection.getInstance();
            connection = dBConnection.getConnection();
            tableQuery2 = (DefaultTableModel)packtable2.getModel();
            tableQuery2.setRowCount(0); 
            String query = "select * from Item group by brandName,name;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Item> bundle = new ArrayList();
            while (rs.next()) {
                tableQuery2.insertRow(tableQuery2.getRowCount(), new Object[]{
                    rs.getString("brandName"),
                    rs.getString("name"),
                    rs.getInt("QtyPerBundle"),
                    rs.getString("unit"),
                    rs.getInt("stock"),
                    rs.getString("Location"),
                    rs.getInt("IdealStock")
                });
            } 
        } catch (SQLException ex) {
            Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        error = new javax.swing.JLabel();
        next1 = new javax.swing.JButton();
        prev1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        invoice = new javax.swing.JTextField();
        office = new javax.swing.JTextField();
        term = new javax.swing.JTextField();
        pane1 = new javax.swing.JScrollPane();
        officetable = new javax.swing.JTable();
        background1 = new javax.swing.JLabel();
        pane2 = new javax.swing.JScrollPane();
        packtable2 = new javax.swing.JTable();
        next2 = new javax.swing.JButton();
        brand = new javax.swing.JTextField();
        item = new javax.swing.JTextField();
        background2 = new javax.swing.JLabel();
        pane3 = new javax.swing.JScrollPane();
        bundletable = new javax.swing.JTable();
        pack = new javax.swing.JTextField();
        next3 = new javax.swing.JButton();
        prev2 = new javax.swing.JButton();
        background3 = new javax.swing.JLabel();
        pane4 = new javax.swing.JScrollPane();
        stockprice = new javax.swing.JTable();
        buysupp = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        background4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 720));
        setMinimumSize(new java.awt.Dimension(900, 720));
        setPreferredSize(new java.awt.Dimension(900, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        error.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(error);
        error.setBounds(580, 580, 260, 20);

        next1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        next1.setOpaque(false);
        next1.setContentAreaFilled(false);
        next1.setBorderPainted(false);
        next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next1ActionPerformed(evt);
            }
        });
        getContentPane().add(next1);
        next1.setBounds(580, 640, 90, 30);

        prev1.setOpaque(false);
        prev1.setContentAreaFilled(false);
        prev1.setBorderPainted(false);
        prev1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prev1ActionPerformed(evt);
            }
        });
        getContentPane().add(prev1);
        prev1.setBounds(270, 630, 100, 50);

        jLabel1.setFont(new java.awt.Font("Gotham Rounded Light", 0, 18)); // NOI18N
        jLabel1.setText("Term:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 460, 60, 30);

        invoice.setBorder(null);
        invoice.setBackground(new Color(217, 219, 223));
        getContentPane().add(invoice);
        invoice.setBounds(400, 570, 150, 20);

        office.setBorder(null);
        office.setBackground(new Color(217, 219, 223));
        getContentPane().add(office);
        office.setBounds(400, 510, 150, 20);

        term.setToolTipText("");
        term.setBorder(null);
        term.setBackground(new Color(217, 219, 223));
        getContentPane().add(term);
        term.setBounds(400, 460, 150, 20);

        officetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Office Name", "Contact Number", "Fax Number", "Address"
            }
        ));
        pane1.setViewportView(officetable);

        getContentPane().add(pane1);
        pane1.setBounds(60, 60, 780, 390);

        background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/office-transaction-1.jpg"))); // NOI18N
        getContentPane().add(background1);
        background1.setBounds(0, 0, 900, 700);

        packtable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Brand Name", "Item Name", "Quantity", "Unit", "Stock", "Location", "Ideal Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pane2.setViewportView(packtable2);

        getContentPane().add(pane2);
        pane2.setBounds(60, 60, 780, 390);

        next2.setOpaque(false);
        next2.setContentAreaFilled(false);
        next2.setBorderPainted(false);
        next2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        next2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next2ActionPerformed(evt);
            }
        });
        getContentPane().add(next2);
        next2.setBounds(580, 640, 90, 30);

        brand.setBorder(null);
        brand.setBackground(new Color(217, 219, 223));
        getContentPane().add(brand);
        brand.setBounds(390, 510, 150, 20);

        item.setBorder(null);
        item.setBackground(new Color(217, 219, 223));
        getContentPane().add(item);
        item.setBounds(390, 570, 150, 20);

        background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/office-transaction-2.jpg"))); // NOI18N
        getContentPane().add(background2);
        background2.setBounds(0, 0, 900, 700);

        bundletable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Brand Name", "Item Name", "Quantity", "Unit", "Stock", "Location", "Ideal Stock"
            }
        ));
        pane3.setViewportView(bundletable);

        getContentPane().add(pane3);
        pane3.setBounds(60, 60, 780, 390);

        pack.setBorder(null);
        pack.setBackground(new Color(217, 219, 223));
        getContentPane().add(pack);
        pack.setBounds(400, 530, 140, 20);

        next3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        next3.setOpaque(false);
        next3.setContentAreaFilled(false);
        next3.setBorderPainted(false);
        next3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next3ActionPerformed(evt);
            }
        });
        getContentPane().add(next3);
        next3.setBounds(580, 640, 90, 30);

        prev2.setOpaque(false);
        prev2.setContentAreaFilled(false);
        prev2.setBorderPainted(false);
        prev2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prev2ActionPerformed(evt);
            }
        });
        getContentPane().add(prev2);
        prev2.setBounds(270, 630, 100, 50);

        background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/office-transaction-3.jpg"))); // NOI18N
        getContentPane().add(background3);
        background3.setBounds(0, 0, 900, 700);

        stockprice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier Name", "Brand Name", "Item Name", "Price", "Unit"
            }
        ));
        pane4.setViewportView(stockprice);

        getContentPane().add(pane4);
        pane4.setBounds(60, 60, 780, 390);

        buysupp.setToolTipText("");
        buysupp.setBorder(null);
        buysupp.setBackground(new Color(217, 219, 223));
        getContentPane().add(buysupp);
        buysupp.setBounds(470, 510, 150, 20);

        quantity.setBorder(null);
        quantity.setBackground(new Color(217, 219, 223));
        getContentPane().add(quantity);
        quantity.setBounds(470, 570, 140, 20);

        confirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirm.setOpaque(false);
        confirm.setContentAreaFilled(false);
        confirm.setBorderPainted(false);
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm);
        confirm.setBounds(410, 630, 130, 50);

        background4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/office-transaction-4.jpg"))); // NOI18N
        getContentPane().add(background4);
        background4.setBounds(0, 0, 900, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void next1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next1ActionPerformed
        Manager mngr = new Manager();
        System.out.println("Offices:");
        o = office.getText().toUpperCase();
        iV = invoice.getText();
        if((mngr.getOT(iV)!=null)||(mngr.getST(iV)!=null)){
            //System.out.println("error, transaction with that invoice already exists");
            error.setText("Error! Invoice already exists");
        }
        else if(o.equals("") || iV.equals("") || term.getText().equals("")){
            error.setText("Error! Missing field or incorrect input");
        }
        else{
            otemp = mngr.getO(o);
            c = new GregorianCalendar();
            c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            d1 = c.getTime();
            System.out.print("Enter terms of payment: ");
            terms = Integer.parseInt(term.getText());
            sT = new OfficeTransaction(iV, 0.0, d1, otemp.getName(), terms, otemp.getID());
            next1.setVisible(false);
            invoice.setVisible(false);
            office.setVisible(false);
            pane1.setVisible(false);
            background1.setVisible(false);
            pane2.setVisible(true);
            next2.setVisible(true);
            brand.setVisible(true);
            item.setVisible(true);
            background2.setVisible(true);
            invoice.setVisible(false);
            office.setVisible(false);
            pane1.setVisible(false);
        }
    }//GEN-LAST:event_next1ActionPerformed

    private void next2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next2ActionPerformed
        Manager mngr = new Manager();
        System.out.print("Enter BrandName: ");
        s1 = brand.getText().toUpperCase();
        System.out.print("Enter Name: ");
        s2 = item.getText().toUpperCase();
        if(!mngr.checkBundle(s1, s2))
            error.setText("No results found!");
        else if(s1.equals("") || s2.equals("")){
            error.setText("Error! Missing/Blank Field!");
        }
        else{
                 pane2.setVisible(false);
                next2.setVisible(false);
                brand.setVisible(false);
                item.setVisible(false);
                background2.setVisible(false);
                pane3.setVisible(true);
                pack.setVisible(true);
                next3.setVisible(true);
                background3.setVisible(true);

                try {
                        String name, brandName;
                        name = s2;
                        brandName = s1;
                        dBConnection = DBconnection.getInstance();
                        connection = dBConnection.getConnection();
                        tableQuery3 = (DefaultTableModel)bundletable.getModel();
                        tableQuery3.setRowCount(0); 
                        String query = "select * from Item where name = ? and brandName = ? and unit is not null;";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, brandName);
                        ResultSet rs = preparedStatement.executeQuery();
                        ArrayList<Item> bundle = new ArrayList();
                        while (rs.next()) {
                            tableQuery3.insertRow(tableQuery3.getRowCount(), new Object[]{
                                rs.getString("brandName"),
                                rs.getString("name"),
                                rs.getInt("QtyPerBundle"),
                                rs.getString("unit"),
                                rs.getInt("stock"),
                                rs.getString("Location"),
                                rs.getInt("IdealStock")
                            });
                        } 
                    } catch (SQLException ex) {
                        Logger.getLogger(BundleImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }   
        }
               
    }//GEN-LAST:event_next2ActionPerformed

    private void next3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next3ActionPerformed
        Manager mngr = new Manager();
        System.out.println("Enter package: ");
        b1 = pack.getText();
        if(mngr.getB(s1, s2, b1)==null)
            error.setText("System cannot find input specified");
        else if(sT.checkBreakDown(s1, s2, b1))
            System.out.println("You have already add this item to the cart");
        else if(b1.equals("")){
            error.setText("Error! Missing/Blank Field");
        }
        else{
            pane3.setVisible(false);
            pack.setVisible(false);
            next3.setVisible(false);
            background3.setVisible(false);
            pane4.setVisible(true);
            buysupp.setVisible(true);
            quantity.setVisible(true);
            confirm.setVisible(true);
            background4.setVisible(true);
            b = mngr.getB(s1, s2, b1);
            mngr.printPriceBeanUser(b.getItemID());
            bID = b.getItemID();
            try {
                tableQuery4 = (DefaultTableModel)stockprice.getModel();
                tableQuery4.setRowCount(0); 
                dBConnection = DBconnection.getInstance();
                connection = dBConnection.getConnection();
                String query = "select s.name, item.brandName, item.name, item.unit, item.qtyperbundle, item.stock, p.supplierPrice, item.itemId, p.itemID from item "
                        + "inner join prices as p "
                        + "on item.itemID = p.itemID "
                        + "inner join supplier as s "
                        + "on p.supplierId = s.supplierID "
                        + "where item.itemID = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setBigDecimal(1, new BigDecimal(bID));
                //preparedStatement.setBigDecimal(2, new BigDecimal(bID));
                ArrayList<PriceBean> prices = new ArrayList();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    tableQuery4.insertRow(tableQuery4.getRowCount(), new Object[]{
                        rs.getString("s.name"),
                        rs.getString("brandName"),
                        rs.getString("item.name"),
                        rs.getDouble("supplierPrice"),
                        rs.getString("unit"),
                    });
                } 
            } catch (SQLException ex) {
                Logger.getLogger(PriceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }//GEN-LAST:event_next3ActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        Manager mngr = new Manager();
        stemp = buysupp.getText();
        sID = mngr.getS(stemp).getID();
        if(mngr.getS(stemp)==null)
            error.setText("No results found");
        else if(mngr.getUserPrice(bID, sID)==0.0)
            error.setText("no results found");
        else if(stemp.equals("")){
            error.setText("Error! Missing/Blank field");
        }
        else{
            d = mngr.getUserPrice(bID, sID);
            System.out.print("Enter how many will be bought: ");//int only
            count = Integer.parseInt(quantity.getText());
            sT.addBreakDownTemp(new BreakDown(iV, count, bID, mngr.getUserPrice(bID, sID)));
            sT.setTotal(sT.getTotal()+(count*mngr.getUserPrice(bID, sID)));
            mngr.addOTransaction(sT);
            sT.commitBreakDown();
            mngr.printAllOfficeTrans();
            this.dispose();   
        }
    }//GEN-LAST:event_confirmActionPerformed

    private void prev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prev1ActionPerformed
            next1.setVisible(true);
            invoice.setVisible(true);
            office.setVisible(true);
            pane1.setVisible(true);
            background1.setVisible(true);
            pane2.setVisible(false);
            next2.setVisible(false);
            brand.setVisible(false);
            item.setVisible(false);
            background2.setVisible(false);
            invoice.setVisible(true);
            office.setVisible(true);
            pane1.setVisible(true);
            prev2.setVisible(true);
    }//GEN-LAST:event_prev1ActionPerformed

    private void prev2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prev2ActionPerformed
            pane2.setVisible(true);
            next2.setVisible(true);
            brand.setVisible(true);
            item.setVisible(true);
            background2.setVisible(true);
            pane3.setVisible(false);
            pack.setVisible(false);
            prev2.setVisible(false);
            background3.setVisible(false);
    }//GEN-LAST:event_prev2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(recordOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(recordOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(recordOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(recordOT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new recordOT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background1;
    private javax.swing.JLabel background2;
    private javax.swing.JLabel background3;
    private javax.swing.JLabel background4;
    private javax.swing.JTextField brand;
    private javax.swing.JTable bundletable;
    private javax.swing.JTextField buysupp;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel error;
    private javax.swing.JTextField invoice;
    private javax.swing.JTextField item;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton next1;
    private javax.swing.JButton next2;
    private javax.swing.JButton next3;
    private javax.swing.JTextField office;
    private javax.swing.JTable officetable;
    private javax.swing.JTextField pack;
    private javax.swing.JTable packtable2;
    private javax.swing.JScrollPane pane1;
    private javax.swing.JScrollPane pane2;
    private javax.swing.JScrollPane pane3;
    private javax.swing.JScrollPane pane4;
    private javax.swing.JButton prev1;
    private javax.swing.JButton prev2;
    private javax.swing.JTextField quantity;
    private javax.swing.JTable stockprice;
    private javax.swing.JTextField term;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Connection.DBconnection;
import Connection.DBconnectionImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;

/**
 *
 * @author raffy
 */
public class viewAllTransactionsSupplier extends javax.swing.JFrame {

    DefaultTableModel tableQuery = new DefaultTableModel();
    public viewAllTransactionsSupplier() {
        initComponents();
        DBconnectionImpl dBConnection;
        Connection connection;
        tableQuery = (DefaultTableModel)supplierTransactionsTable.getModel();
            try {
                dBConnection = DBconnection.getInstance();
                connection = dBConnection.getConnection();
                String query = "select * from sTransaction";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    tableQuery.insertRow(tableQuery.getRowCount(), new Object[]{rs.getString("inVoice"), rs.getString("name"), rs.getString("date"),rs.getString("terms"), rs.getString("deadline"),rs.getString("total")});
                }   
            } catch (SQLException ex) {
                Logger.getLogger(buySupply.class.getName()).log(Level.SEVERE, null, ex);
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

        buyAndSellButton = new javax.swing.JButton();
        menuButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        viewPerOfficeButton = new javax.swing.JButton();
        viewPerSupplierButton = new javax.swing.JButton();
        viewAllOfficeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierTransactionsTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(915, 708));
        setMinimumSize(new java.awt.Dimension(915, 708));
        setPreferredSize(new java.awt.Dimension(915, 708));
        getContentPane().setLayout(null);

        buyAndSellButton.setOpaque(false);
        buyAndSellButton.setContentAreaFilled(false);
        buyAndSellButton.setBorderPainted(false);
        buyAndSellButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buyAndSellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyAndSellButtonActionPerformed(evt);
            }
        });
        getContentPane().add(buyAndSellButton);
        buyAndSellButton.setBounds(10, 100, 50, 40);

        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorderPainted(false);
        menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(menuButton);
        menuButton.setBounds(10, 170, 50, 40);

        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        settingsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(settingsButton);
        settingsButton.setBounds(10, 250, 50, 40);

        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton);
        exitButton.setBounds(10, 610, 50, 40);

        viewPerOfficeButton.setOpaque(false);
        viewPerOfficeButton.setContentAreaFilled(false);
        viewPerOfficeButton.setBorderPainted(false);
        viewPerOfficeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewPerOfficeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPerOfficeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(viewPerOfficeButton);
        viewPerOfficeButton.setBounds(630, 60, 170, 40);

        viewPerSupplierButton.setOpaque(false);
        viewPerSupplierButton.setContentAreaFilled(false);
        viewPerSupplierButton.setBorderPainted(false);
        viewPerSupplierButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewPerSupplierButton.setToolTipText("");
        viewPerSupplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPerSupplierButtonActionPerformed(evt);
            }
        });
        getContentPane().add(viewPerSupplierButton);
        viewPerSupplierButton.setBounds(440, 60, 180, 40);

        viewAllOfficeButton.setOpaque(false);
        viewAllOfficeButton.setContentAreaFilled(false);
        viewAllOfficeButton.setBorderPainted(false);
        viewAllOfficeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewAllOfficeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllOfficeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(viewAllOfficeButton);
        viewAllOfficeButton.setBounds(250, 60, 180, 40);

        supplierTransactionsTable.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        supplierTransactionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice", "Name", "Date", "Terms", "Deadline", "Total"
            }
        ));
        jScrollPane1.setViewportView(supplierTransactionsTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 110, 810, 570);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Introse New Form Designs/View all Transactions from Suppliers.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 683);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewAllOfficeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllOfficeButtonActionPerformed
        viewAllTransactionsOffice allOffice = new viewAllTransactionsOffice();
        allOffice.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewAllOfficeButtonActionPerformed

    private void viewPerSupplierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPerSupplierButtonActionPerformed
        viewPerSupplier perSupp = new viewPerSupplier();
        perSupp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewPerSupplierButtonActionPerformed

    private void viewPerOfficeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPerOfficeButtonActionPerformed
        viewPerOffice perOffice  = new viewPerOffice();
        perOffice.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewPerOfficeButtonActionPerformed

    private void buyAndSellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyAndSellButtonActionPerformed
        buySupply buy = new buySupply();
        buy.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buyAndSellButtonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_menuButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(viewAllTransactionsSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewAllTransactionsSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewAllTransactionsSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewAllTransactionsSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewAllTransactionsSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyAndSellButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menuButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JTable supplierTransactionsTable;
    private javax.swing.JButton viewAllOfficeButton;
    private javax.swing.JButton viewPerOfficeButton;
    private javax.swing.JButton viewPerSupplierButton;
    // End of variables declaration//GEN-END:variables
}

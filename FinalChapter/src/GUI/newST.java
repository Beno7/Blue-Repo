/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Logic.Item;
import Logic.Manager;
import Logic.PriceBean;
import java.awt.Color;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Raffy
 */
public class newST extends javax.swing.JFrame {

    /**
     * Creates new form newST
     */
    private Scanner inS;
    private Manager mngr = new Manager();;
    
    public newST() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        fax = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        brand = new javax.swing.JTextField();
        item = new javax.swing.JTextField();
        unit = new javax.swing.JTextField();
        itemperunit = new javax.swing.JTextField();
        unitprice = new javax.swing.JTextField();
        idealstock = new javax.swing.JTextField();
        suppprice = new javax.swing.JTextField();
        myprice = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 700));
        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        getContentPane().setLayout(null);

        name.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        name.setBorder(null);
        name.setBackground(new Color(217, 219, 223));
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        getContentPane().add(name);
        name.setBounds(190, 135, 250, 30);

        contact.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        contact.setBorder(null);
        contact.setBackground(new Color(217, 219, 223));
        contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactMouseClicked(evt);
            }
        });
        getContentPane().add(contact);
        contact.setBounds(190, 202, 250, 30);

        fax.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fax.setBorder(null);
        fax.setBackground(new Color(217, 219, 223));
        fax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                faxMouseClicked(evt);
            }
        });
        getContentPane().add(fax);
        fax.setBounds(190, 264, 250, 30);

        address.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        address.setBorder(null);
        address.setBackground(new Color(217, 219, 223));
        address.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressMouseClicked(evt);
            }
        });
        getContentPane().add(address);
        address.setBounds(190, 326, 250, 30);

        confirm.setToolTipText("");
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
        confirm.setBounds(420, 600, 120, 50);

        brand.setBorder(null);
        brand.setBackground(new Color(217, 219, 223));
        getContentPane().add(brand);
        brand.setBounds(610, 132, 230, 30);

        item.setBorder(null);
        item.setBackground(new Color(217, 219, 223));
        getContentPane().add(item);
        item.setBounds(610, 193, 230, 20);

        unit.setBorder(null);
        unit.setBackground(new Color(217, 219, 223));
        getContentPane().add(unit);
        unit.setBounds(610, 255, 230, 30);

        itemperunit.setBorder(null);
        itemperunit.setBackground(new Color(217, 219, 223));
        getContentPane().add(itemperunit);
        itemperunit.setBounds(610, 375, 230, 30);

        unitprice.setBorder(null);
        unitprice.setBackground(new Color(217, 219, 223));
        getContentPane().add(unitprice);
        unitprice.setBounds(610, 317, 230, 20);

        idealstock.setBorder(null);
        idealstock.setBackground(new Color(217, 219, 223));
        getContentPane().add(idealstock);
        idealstock.setBounds(610, 435, 230, 30);

        suppprice.setBorder(null);
        suppprice.setBackground(new Color(217, 219, 223));
        getContentPane().add(suppprice);
        suppprice.setBounds(190, 435, 230, 20);

        myprice.setBorder(null);
        myprice.setBackground(new Color(217, 219, 223));
        getContentPane().add(myprice);
        myprice.setBounds(190, 492, 230, 30);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-supplier.jpg"))); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background);
        background.setBounds(0, 0, 900, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        name.setText(null);
    }//GEN-LAST:event_nameMouseClicked

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        Manager manage = new Manager();	
        String sN, cN, fN, addr;
        sN = name.getText().toUpperCase();
        cN = contact.getText();
        fN = fax.getText();
        addr = address.getText();
	
        if(manage.getS(sN) != null){
            //set textfield color to red and display message **Supplier already exists**
            System.out.println("Data Not Added!");
        }
        else{
            manage.addS(new Logic.Supplier(sN, cN, fN, addr));
            System.out.println("Data Added!");
        }
        String bN, n, u, l;
        int inID, norm, m;
        double uP;
        bN = brand.getText().toUpperCase();
        n = item.getText().toUpperCase();
        u = unit.getText().toUpperCase();
        if(manage.getB(bN, n, u)!=null){
            System.out.println("Error, bundle already exists");
            System.out.println("Enter Again");
        }
        else{
            m = Integer.parseInt(itemperunit.getText().toUpperCase());
            norm = Integer.parseInt(idealstock.getText().toUpperCase());
            uP = Double.parseDouble(unitprice.getText().toUpperCase());
            l = "SJT-Main";
            manage.addB(new Item(bN, n, u, norm, l, m));
        }
        String temp = name.getText();
        Manager mngr = new Manager();
	Double p, p1;
	BigInteger a, a1;
        bN = brand.getText().toUpperCase();
        n = item.getText().toUpperCase();
        u = unit.getText().toUpperCase();
        a = mngr.getS(temp).getID();
        a1 = mngr.getB(bN, n, u).getItemID();
        p = Double.parseDouble(suppprice.getText());
        p1 = Double.parseDouble(myprice.getText());
        mngr.addP(new PriceBean(a1, a, p, p1));
        this.dispose();
    }//GEN-LAST:event_confirmActionPerformed

    private void contactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactMouseClicked
        contact.setText(null);
    }//GEN-LAST:event_contactMouseClicked

    private void faxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faxMouseClicked
        fax.setText(null);
    }//GEN-LAST:event_faxMouseClicked

    private void addressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressMouseClicked
        address.setText(null);
    }//GEN-LAST:event_addressMouseClicked

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
            java.util.logging.Logger.getLogger(newST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newST().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JLabel background;
    private javax.swing.JTextField brand;
    private javax.swing.JButton confirm;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField fax;
    private javax.swing.JTextField idealstock;
    private javax.swing.JTextField item;
    private javax.swing.JTextField itemperunit;
    private javax.swing.JTextField myprice;
    private javax.swing.JTextField name;
    private javax.swing.JTextField suppprice;
    private javax.swing.JTextField unit;
    private javax.swing.JTextField unitprice;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Logic.Manager;
import Logic.Office;
import java.awt.Color;
import java.util.Scanner;
import Logic.*;

/**
 *
 * @author Raffy
 */
public class editO extends javax.swing.JFrame {

    /**
     * Creates new form editOffice
     */
    private Scanner inS;
    private Manager mngr = new Manager();
    public editO() {
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
        address = new javax.swing.JTextField();
        fax = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        background1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(365, 390));
        setMinimumSize(new java.awt.Dimension(365, 390));
        setPreferredSize(new java.awt.Dimension(365, 390));
        getContentPane().setLayout(null);

        name.setFont(new java.awt.Font("Gotham Rounded Light", 0, 12)); // NOI18N
        name.setText("name of office to be edited...");
        name.setBorder(null);
        name.setBackground(new Color(217, 219, 223));
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        getContentPane().add(name);
        name.setBounds(45, 104, 260, 30);

        contact.setFont(new java.awt.Font("Gotham Rounded Light", 0, 12)); // NOI18N
        contact.setText("new contact number...");
        contact.setBorder(null);
        contact.setBackground(new Color(217, 219, 223));
        contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactMouseClicked(evt);
            }
        });
        getContentPane().add(contact);
        contact.setBounds(45, 153, 260, 30);

        address.setFont(new java.awt.Font("Gotham Rounded Light", 0, 12)); // NOI18N
        address.setText("new address...");
        address.setBorder(null);
        address.setBackground(new Color(217, 219, 223));
        address.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressMouseClicked(evt);
            }
        });
        getContentPane().add(address);
        address.setBounds(45, 253, 260, 30);

        fax.setFont(new java.awt.Font("Gotham Rounded Light", 0, 12)); // NOI18N
        fax.setText("new fax number...");
        fax.setBorder(null);
        fax.setBackground(new Color(217, 219, 223));
        fax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                faxMouseClicked(evt);
            }
        });
        getContentPane().add(fax);
        fax.setBounds(45, 203, 260, 30);

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
        confirm.setBounds(123, 300, 110, 40);

        background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-office.jpg"))); // NOI18N
        getContentPane().add(background1);
        background1.setBounds(0, 0, 350, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        name.setText(null);
    }//GEN-LAST:event_nameMouseClicked

    private void contactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactMouseClicked
        contact.setText(null);
    }//GEN-LAST:event_contactMouseClicked

    private void faxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faxMouseClicked
        fax.setText(null);
    }//GEN-LAST:event_faxMouseClicked

    private void addressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressMouseClicked
        address.setText(null);
    }//GEN-LAST:event_addressMouseClicked

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
	Manager manage = new Manager();
        String oN, cN, fN, addr;
	Office o, newO;
	o = manage.getO(name.getText());
        if(o!=null){
            oN = o.getName();
            cN = contact.getText();
            fN = fax.getText();
            addr = address.getText();
            newO = new Office(oN, cN, fN, addr);
            newO.setID(o.getID());
            manage.editO(newO);
            System.out.println("Data Added!");
        }
        else{
            System.out.println("Data Not Added!");
        }
        this.dispose();
    }//GEN-LAST:event_confirmActionPerformed

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
            java.util.logging.Logger.getLogger(editO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JLabel background1;
    private javax.swing.JButton confirm;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField fax;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}

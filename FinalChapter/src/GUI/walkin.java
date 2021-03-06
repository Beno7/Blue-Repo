/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author Raffy
 */
public class walkin extends javax.swing.JFrame {

    /**
     * Creates new form walkin
     */
    public walkin() {
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

        no = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        supplier = new javax.swing.JButton();
        products = new javax.swing.JButton();
        supplierT = new javax.swing.JButton();
        customerT = new javax.swing.JButton();
        instructions = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 700));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(null);

        no.setOpaque(false);
        no.setContentAreaFilled(false);
        no.setBorderPainted(false);
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });
        getContentPane().add(no);
        no.setBounds(840, 130, 80, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 200, 630, 470);

        supplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplier.setOpaque(false);
        supplier.setContentAreaFilled(false);
        supplier.setBorderPainted(false);
        supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierActionPerformed(evt);
            }
        });
        getContentPane().add(supplier);
        supplier.setBounds(80, 250, 170, 70);

        products.setToolTipText("");
        products.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        products.setOpaque(false);
        products.setContentAreaFilled(false);
        products.setBorderPainted(false);
        products.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsActionPerformed(evt);
            }
        });
        getContentPane().add(products);
        products.setBounds(80, 320, 170, 72);

        supplierT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplierT.setOpaque(false);
        supplierT.setContentAreaFilled(false);
        supplierT.setBorderPainted(false);
        supplierT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierTActionPerformed(evt);
            }
        });
        getContentPane().add(supplierT);
        supplierT.setBounds(80, 180, 170, 70);

        customerT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customerT.setOpaque(false);
        customerT.setContentAreaFilled(false);
        customerT.setBorderPainted(false);
        getContentPane().add(customerT);
        customerT.setBounds(80, 460, 170, 70);

        instructions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        instructions.setOpaque(false);
        instructions.setContentAreaFilled(false);
        instructions.setBorderPainted(false);
        getContentPane().add(instructions);
        instructions.setBounds(80, 540, 170, 70);

        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.setOpaque(false);
        logout.setContentAreaFilled(false);
        logout.setBorderPainted(false);
        getContentPane().add(logout);
        logout.setBounds(80, 610, 170, 70);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/walk-in.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, -20, 1200, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        newWI walk = new newWI();
        walk.setVisible(true);
    }//GEN-LAST:event_noActionPerformed

    private void supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierActionPerformed
        SupplierGUI supplier = new SupplierGUI();
        supplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_supplierActionPerformed

    private void productsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsActionPerformed
        InventoryGUI products1 = new InventoryGUI();
        products1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_productsActionPerformed

    private void supplierTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierTActionPerformed
        CustomerGUI custom = new CustomerGUI();
        custom.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_supplierTActionPerformed

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
            java.util.logging.Logger.getLogger(walkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(walkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(walkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(walkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new walkin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton customerT;
    private javax.swing.JButton instructions;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logout;
    private javax.swing.JButton no;
    private javax.swing.JButton products;
    private javax.swing.JButton supplier;
    private javax.swing.JButton supplierT;
    // End of variables declaration//GEN-END:variables
}

package GUI;
import Logic.Bundle;
import Logic.BundleManager;
import Logic.Item;
import Logic.Office;
import Logic.OfficeManager;
import Logic.Supplier;
import Logic.SupplierManager;
import Logic.TransactionDB;
import Logic.WRInventory;
import java.awt.Cursor;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raffy
 */
public class addSupplier extends javax.swing.JFrame {

	private	Scanner inS;
	private	String sN;//supplier name
	private	String contact,bN, N, temp;//Items primary key
	private String u;// unit of bundle
	private String oN; // office name
	private String iV; // inVoice
	private Office tO;
        private Bundle c;
	private int m;// measurement of a bundle
	private Double pSP, sP;// sell price of a package, suppliers price for the item
	private	Double price;//price of Item
	private	WRInventory wR;//instance of inventory
	private	Item tempI;//temporary Item variable
	private	int bool;//to check if supplier exists in db
	//SupplierManager sM;
	//private OfficeManager oM;
	private TransactionDB sTM;
	//private BundleManager bM;
        SupplierManager sM = new SupplierManager();
        BundleManager bM = new BundleManager();
        int check = 1;
        Pattern pattern = Pattern.compile("[!$&+,:;=?@#|]");
        Matcher matcher;
        
	
    public addSupplier() {

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        contactsField = new javax.swing.JTextField();
        supplierField = new javax.swing.JTextField();
        brandField = new javax.swing.JTextField();
        itemField = new javax.swing.JTextField();
        bundleNameField = new javax.swing.JTextField();
        itemAmountField = new javax.swing.JTextField();
        supplierSellPriceField = new javax.swing.JTextField();
        yourPriceField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        newItemButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        form = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(515, 704));
        setMinimumSize(new java.awt.Dimension(515, 704));
        setPreferredSize(new java.awt.Dimension(515, 704));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Contact Details:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 450, 110, 30);

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 390, 34, 20);

        jLabel4.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Supplier Sell Price:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(310, 400, 100, 13);
        getContentPane().add(contactsField);
        contactsField.setBounds(260, 490, 160, 20);

        supplierField.setFont(new java.awt.Font("Myriad Pro", 0, 13)); // NOI18N
        getContentPane().add(supplierField);
        supplierField.setBounds(100, 160, 320, 27);

        brandField.setFont(new java.awt.Font("Myriad Pro", 0, 13)); // NOI18N
        brandField.setToolTipText("");
        getContentPane().add(brandField);
        brandField.setBounds(100, 240, 320, 27);

        itemField.setFont(new java.awt.Font("Myriad Pro", 0, 13)); // NOI18N
        getContentPane().add(itemField);
        itemField.setBounds(100, 320, 320, 27);

        bundleNameField.setFont(new java.awt.Font("Myriad Pro", 0, 13)); // NOI18N
        bundleNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bundleNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(bundleNameField);
        bundleNameField.setBounds(160, 390, 100, 20);

        itemAmountField.setFont(new java.awt.Font("Myriad Pro", 0, 13)); // NOI18N
        itemAmountField.setToolTipText("");
        getContentPane().add(itemAmountField);
        itemAmountField.setBounds(160, 420, 100, 20);

        supplierSellPriceField.setFont(new java.awt.Font("Myriad Pro", 0, 13)); // NOI18N
        supplierSellPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierSellPriceFieldActionPerformed(evt);
            }
        });
        getContentPane().add(supplierSellPriceField);
        supplierSellPriceField.setBounds(310, 420, 110, 20);

        yourPriceField.setFont(new java.awt.Font("Myriad Pro", 0, 13)); // NOI18N
        getContentPane().add(yourPriceField);
        yourPriceField.setBounds(100, 490, 150, 20);

        jLabel3.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Amount:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 420, 50, 13);

        submitButton.setOpaque(false);
        submitButton.setContentAreaFilled(false);
        submitButton.setBorderPainted(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton);
        submitButton.setBounds(50, 619, 420, 70);

        newItemButton.setOpaque(false);
        newItemButton.setContentAreaFilled(false);
        newItemButton.setBorderPainted(false);
        newItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemButtonActionPerformed(evt);
            }
        });
        getContentPane().add(newItemButton);
        newItemButton.setBounds(50, 540, 420, 80);

        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(60, 40, 80, 40);

        form.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forms/addSupplier2.png"))); // NOI18N
        getContentPane().add(form);
        form.setBounds(50, -40, 420, 770);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forms/iPhone.png"))); // NOI18N
        BG.setMaximumSize(new java.awt.Dimension(520, 524));
        BG.setMinimumSize(new java.awt.Dimension(520, 524));
        getContentPane().add(BG);
        BG.setBounds(0, 0, 519, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemButtonActionPerformed
        brandField.setText(null);
        itemField.setText(null);
        yourPriceField.setText(null);
        supplierSellPriceField.setText(null);
        bundleNameField.setText(null);
        itemAmountField.setText(null);
        check = 0;
    }//GEN-LAST:event_newItemButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        sN = supplierField.getText().toUpperCase();
        bN = brandField.getText().toUpperCase();
        N = itemField.getText().toUpperCase();
        contact = contactsField.getText().toUpperCase();
        u = bundleNameField.getText();
        m = Integer.parseInt(itemAmountField.getText().toUpperCase());
        sP = Double.parseDouble(supplierSellPriceField.getText().toUpperCase());
        pSP = Double.parseDouble(yourPriceField.getText().toUpperCase());
        boolean specialCharsN = pattern.matcher(sN).find();
        boolean specialCharbN = pattern.matcher(bN).find();
        boolean specialCharN = pattern.matcher(N).find();
        boolean specialCharU = pattern.matcher(u).find();
        if(check == 1){
               if(sN.equals("") || bN.equals("") || N.equals("") || u.equals("") || specialCharsN || specialCharbN|| specialCharN || specialCharU){
                    promptErrorExisting error1 = new promptErrorExisting();
                    error1.setVisible(true);
                    System.out.println("1st");
                }
               else if(sM.getS(sN) != null){
                    System.out.println("ERROR");
                    promptErrorExisting error1 = new promptErrorExisting();
                    error1.setVisible(true);
                    supplierField.setText(null);
                    System.out.println("2st");
                    //System.out.println("Nice");
                }

                else{
                    sM.addS(new Supplier(sN, contact));
                    c = new Bundle(u, m, pSP, bN, N);
                    c.addSuppPrice(sM.getS(sN), sP);
                    bM.addB(c);
                    c.addPricetoDB(sM.getS(sN), sP);
                    promptSuccess ok = new promptSuccess();
                    ok.setVisible(true);
                }
        }
        else{
                if(sM.getS(sN) != null || sN.equals("") || bN.equals("") || N.equals("") || u.equals("") || specialCharsN || specialCharbN || specialCharN || specialCharU){
                    promptErrorExisting error1 = new promptErrorExisting();
                    error1.setVisible(true);
                    supplierField.setText(null);
                }
                else{
                    c = new Bundle(u, m, pSP, bN, N);
                    c.addSuppPrice(sM.getS(sN), sP);
                    bM.addB(c);
                    c.addPricetoDB(sM.getS(sN), sP);
                    promptSuccess ok = new promptSuccess();
                    ok.setVisible(true);
                }
        }

        /*else{
            c = bM.getB(bN, N, u);
            System.out.print("Updating package...");
            System.out.print("Enter how much supplier "+sM.getS(sN).getName()+" sells 1 "+u+": ");
            c.addSuppPrice(sM.getS(sN), inS.nextDouble());
	}*/
    }//GEN-LAST:event_submitButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void bundleNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bundleNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bundleNameFieldActionPerformed

    private void supplierSellPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierSellPriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierSellPriceFieldActionPerformed

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
            java.util.logging.Logger.getLogger(addSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField brandField;
    private javax.swing.JTextField bundleNameField;
    private javax.swing.JTextField contactsField;
    private javax.swing.JLabel form;
    private javax.swing.JTextField itemAmountField;
    private javax.swing.JTextField itemField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton newItemButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField supplierField;
    private javax.swing.JTextField supplierSellPriceField;
    private javax.swing.JTextField yourPriceField;
    // End of variables declaration//GEN-END:variables
}

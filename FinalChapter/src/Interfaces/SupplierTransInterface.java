/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Connection.DBconnection;

import Logic.*;
import java.util.ArrayList;
import java.math.BigInteger;

/**
 *
 * @author Win 7
 */
public interface SupplierTransInterface {

    public boolean addSupplierTransaction(SupplierTransaction sT);

    public SupplierTransaction getSupplierTransaction(String inVoice);

    public ArrayList<SupplierTransaction> getAllSupplierTransaction(BigInteger supplierId);

    public ArrayList<SupplierTransaction> getAllTransactionSupplier();

    public void insertDateOfPayment(String iV);
    
    public void insertDateOfDelivery(String iV);
    
   
}

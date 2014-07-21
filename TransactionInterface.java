/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Connection.DBconnection;

import Logic.*;
import java.util.ArrayList;

/**
 *
 * @author Win 7
 */
public interface TransactionInterface {

    public boolean addSupplierTransaction(STransaction sT);

    public STransaction getSupplierTransaction(String inVoice);

    public ArrayList<STransaction> getAllSupplierTransaction(String name);

    public boolean addOfficeTransaction(OTransaction oT);

    public OTransaction getOfficeTransaction(String inVoice);

    public ArrayList<OTransaction> getAllOfficeTransaction(String name);

    public ArrayList<STransaction> getAllTransactionSupplier();

    public ArrayList<OTransaction> getAllTransactionOffice();

}

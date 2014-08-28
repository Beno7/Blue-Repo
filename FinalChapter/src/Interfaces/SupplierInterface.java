/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Logic.Supplier;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Win 7
 */



public interface SupplierInterface {

    public boolean addSupplier(Supplier s);

    public Supplier getSupplier(String s);
    
    public ArrayList<Supplier> getAllSupplier();
    
     public Supplier getSupplier(BigInteger supplierId);
     
     public boolean editSupplier(Supplier s);
}

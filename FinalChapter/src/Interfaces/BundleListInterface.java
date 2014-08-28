/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.ArrayList;
import java.math.BigInteger;
import Logic.BreakDown;

/**
 *
 * @author Win 7
 */
public interface BundleListInterface {

    public boolean addSupplierBundle(BreakDown b);

    public ArrayList<BreakDown> getSupplierBundle(String inVoice);

    public boolean addOfficeBundle(String inVoice, BigInteger bundleId, int quantity,double price);

    public ArrayList<Integer> getOfficeBundle(String  inVoice);
    
    public int getSTransactionQuantity(String  inVoice, BigInteger bundleId);
    
    public int getOTransactionQuantity(String  inVoice, BigInteger bundleId);
    
    public double getSupplierPrice(String inVoice, BigInteger bundleId);
    
    public double getOfficePrice(String inVoice, BigInteger bundleId);
    
    public double getWalkInPrice(String inVoice, BigInteger bundleId);
    
}

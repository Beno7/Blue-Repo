/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Logic.Bundle;
import java.util.ArrayList;

/**
 *
 * @author Win 7
 */
public interface BundleListInterface {

    public boolean addSupplierBundle(String inVoice, Bundle b, int quantity);

    public ArrayList<Bundle> getSupplierBundle(String inVoice);

    public boolean addOfficeBundle(String inVoice, Bundle b, int quantity);

    public ArrayList<Bundle> getOfficeBundle(String inVoice);
    
    public int getSTransactionQuantity(String inVoice,String brandName,String name, String unit);
    
    public int getOTransactionQuantity(String inVoice,String brandName,String name, String unit);
    
}

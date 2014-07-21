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
public interface BundleInterface {
    public boolean addBundle(Bundle b);
    
    public Bundle getBundle(String brandName,String name,String unit);
    
    public ArrayList<Bundle> getAllBundle();
    
    public boolean updateStock(String brandName,String name,int stock, String unit);
    
    public boolean updateSupplier(String brandName, String name, String supplier, String unit);
}

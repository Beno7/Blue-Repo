/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;
import java.math.BigInteger;
import Logic.Item;
import java.util.ArrayList;

/**
 *
 * @author Win 7
 */
public interface BundleInterface {
    public boolean addBundle(Item b);
    
    public Item getBundle(String brandName,String name,String unit);
    
    public ArrayList<Item> getAllBundle();
    
    public boolean updateStock(BigInteger itemID,int stock);
        
    public Item getBundle(BigInteger itemId);

    public boolean editBundle(Item b,String brandName, String name, String unit);
	
	public ArrayList<Item> groupBundle();
	
	public ArrayList<Item> getAllBundle(String name,String brandName); 
        
    public Item getLeast(String name, String brandName);
    
    public ArrayList<Item> getSortByBrand();
}

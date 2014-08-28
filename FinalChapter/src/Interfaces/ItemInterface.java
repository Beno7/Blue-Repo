/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Logic.Item;
import java.util.ArrayList;
import java.math.BigInteger;

/**
 *
 * @author Win 7
 */
public interface ItemInterface {
    
    public boolean addItem(Item i);
    
    public Item getItem(BigInteger itemID);
    
    public Item getItem(String name, String brandName);
    
    public ArrayList<Item> getAllItems();
    
    public void updateStock(String name,String brandName,int stock);
    
    public void updatePrice(String name, String brandName, int price);
    
    public ArrayList<Item> getSortByBrandName();
    
    public ArrayList<Item> getSortByPrice();
            
}

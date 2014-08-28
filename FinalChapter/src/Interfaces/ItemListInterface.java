/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Logic.Item;
import java.util.ArrayList;

/**
 *
 * @author Win 7
 */
public interface ItemListInterface {
    
    public void addItemList(int itemId,String inVoice,int quantity,double price);
    
    public ArrayList<Integer> getItemIdList(String inVoice);
    
    public int getQuantity(String inVoice, int itemId);
    
     public double getPrice(String inVoice, int itemId);
}

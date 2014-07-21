/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

/**
 *
 * @author Win 7
 */
public interface PriceInterface {

     public boolean addPrice(double price, String brandName,String name,String unit,String supplier);
     
     public double getPrice(String brandName,String name,String unit,String supplier);
     
     
}

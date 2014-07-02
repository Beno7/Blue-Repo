/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Win 7
 */
public class WRInventory {
    private List<Item> items;
    
    public WRInventory(){
		items = new ArrayList<Item>();
	}
	
    public void updateStock(String brandName,String name,String stock){
    
    }
	
	public void addItem(Item i){
		items.add(i);
	}
    
	public int search(String bN, String n){
		for(int i = 0; i < items.size(); i++)
			if(items.get(i).getBrandName().equals(bN))
				if(items.get(i).getName().equals(n))
					return i;
		return -1;
	}
	
	public Item searchItem(String bN, String n){
		for(int i = 0; i < items.size(); i++)
			if(items.get(i).getBrandName().equals(bN)&&items.get(i).getName().equals(n))
					return items.get(i);
		return null;
	}
	
	public void addSupplier(String bN, String n, Supplier s){
		for(int i = 0; i < items.size(); i++)
			if(items.get(i).getBrandName().equals(bN)&&items.get(i).getName().equals(n)){
				items.get(i).addSupplier(s);
				break;
			}
					
	}
	
	public void delSupplier(Supplier s){
		int bool = -1;
		for(int i = 0; i < items.size(); i++){
			for(int j = 0; j < items.get(i).getSuppliers().size(); j++)
				if(items.get(i).getSuppliers().get(j).getName().equals(s.getName())){
					bool = j;
					break;
				}
			if(bool != -1){
				if(items.get(i).getSuppliers().size()==1){
					items.remove(i);
					i-=1;
				} else
					items.get(i).getSuppliers().remove(bool);
				bool = -1;
			}
		}
	}
	
	public List<Item> getItems(){
		return items;
	}
		
	public Item getItem(int ctr){
		return items.get(ctr);
	}
	
    public HashMap getSupplierPrices(String brandName,String name){
    return null;

    }
} 

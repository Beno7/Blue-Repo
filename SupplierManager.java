/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Win 7
 */
public class SupplierManager {
    private List<Supplier> suppliers;

	public SupplierManager(){
		suppliers = new ArrayList<Supplier>();
	}
	
	public SupplierManager(List<Supplier> s){
		setSupplier(s);
	}
	
	
    public Supplier searchSuppliers(String supplier) {
		Supplier s = null;
		for(int i = 0; i < suppliers.size(); i++)
			if(supplier.equalsIgnoreCase(suppliers.get(i).getName()))
				return suppliers.get(i);
        return null;
    }
	
	public Supplier getS(int ctr){//returns supplier of the given index
		return suppliers.get(ctr);
	}
	
	public Supplier getLS(){//returns the last added supplier
		return suppliers.get(sizeS()-1);
	}
	
	public void addS(Supplier s){// add supplier to  suppliers list
		suppliers.add(s);
	}
	
	public int sizeS(){//returns the size of the supplier List
		return suppliers.size();
	}
    
	public void setSupplier(List<Supplier> s){
		this.suppliers = s;
	}
	
	public void swap(int bool, Supplier sN){//overwrites the supplier
		suppliers.remove(bool);
		suppliers.add(sN);
	}
	
	public int checkDB(String name){//searches the database and returns the index of the supplier
		for(int i = 0; i < sizeS(); i++)
			if(name.equalsIgnoreCase(getS(i).getName()))
				return i;
		return -1;
	}
	
	public void printSuppliers(){//prints each supplier's information
		System.out.println("--------------");
        for(int i = 0; i < sizeS(); i++){
			printSupplier(i);
			System.out.println("--------------");
		}
	}
	
	public boolean checkSupplyExist(String bN, String N, Supplier s){//checks if a given supplier supplies a specific item
		for(int i = 0; i < s.getSupplies().size(); i++)
			if(s.getSupplies().get(i).getBrandName().equals(bN)&&s.getSupplies().get(i).getName().equals(N))
				return true;
		return false;
	}
	
	public void printSupplier(int i){
		System.out.println();
        System.out.print("Supplier name: ");
        System.out.println(getS(i).getName());
        for(int j = 0; j < getS(i).getSupplies().size(); j++){
			System.out.println();
            Item k = getS(i).getSupplies().get(j);
            System.out.print("BrandName: ");
            System.out.println(k.getBrandName());
            System.out.print("Name: ");
            System.out.println(k.getName());
            System.out.print("UnitPrice: ");
            System.out.println(k.getUnitPrice());
			System.out.println("Suppliers: ");
			for(int y = 0; y < k.getSuppliers().size(); y++)
				System.out.println(k.getSuppliers().get(y).getName());
			System.out.println("Bundles: ");
			for(int y = 0; y < k.sizeP(); y++){
				System.out.println("Name: "+k.getBundle(y).getUnit());
				System.out.println("number of"+k.getBrandName()+" "+k.getName()+": "+k.getBundle(y).getMeasurement());
				System.out.println("package sellprice: "+k.getBundle(y).getPackSellPrice());
				System.out.println("Stocks: "+k.getBundle(y).getStocks());
				System.out.println("Supplier's pricing:");
				Bundle a = k.getBundle(y);
				for(int z = 0; z < a.getHMSize(); z++)
					System.out.println(a.getSupp(z)+": "+a.elemHM(a.getSupp(z)));
			}
			System.out.println();
		}
	}
    
}

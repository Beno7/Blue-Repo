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
public class Supplier {
    private List<Item> supplies;
    private String name;
    private String contactNo;

    public Supplier(){
		supplies = new ArrayList<Item>();
    }
    public Supplier(String name, String num){
        this.name = name;
        this.contactNo = num;
		supplies = new ArrayList<Item>();
    }
    public Supplier(String name) {//made for testing
        this.name = name;
		supplies = new ArrayList<Item>();
    }

    public Supplier(List<Item> supplies, String name) {
        this.supplies = supplies;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public String getContact(){
        return contactNo;
    }
    
    public void setContact(String c){
        this.contactNo = c;
    }

    public List<Item> getSupplies() {
        return supplies;
    }

    public void setName(String name) {
        this.name = name;
    }
	
	public Item getSupply(int i){
		return supplies.get(i);
	}
	
	public void printItems(){
		for(int i = 0; i <supplies.size(); i++)
			System.out.println(i+". "+supplies.get(i).getBrandName()+" "+supplies.get(i).getName());
	}
	
	public void addSupply(Item i){
		supplies.add(i);
	}

    public void setSupplies(List<Item> supplies) {
        this.supplies = supplies;
    }

}

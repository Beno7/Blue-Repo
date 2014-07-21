
package Logic;
import java.util.HashMap;
import java.util.List;
import  java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Win 7
 */

public class Item {
    private String name;
    private String brandName;
    private List<Supplier> suppliers;
    private List<Bundle> packages;
    private double unitPrice;
    //HashMap<String, Double> prices = new HashMap<>();
	
    public Item(String name, String brandName, double unitPrice) {//made for testing
        this.name = name;
        this.brandName = brandName;
        this.suppliers = new ArrayList<Supplier>();
		this.packages = new ArrayList<Bundle>();
        this.packages = packages;
        this.unitPrice = unitPrice;
    }
	
    public Item(String name, String brandName, Supplier s, double unitPrice) {//made for testing
        this.name = name;
        this.brandName = brandName;
        this.suppliers = new ArrayList<Supplier>();
		suppliers.add(s);
		this.packages = new ArrayList<Bundle>();
        this.packages = packages;
        this.unitPrice = unitPrice;
    }
	
    public Item(String name, String brandName, List<Supplier> suppliers, double unitPrice) {//made for testing
        this.name = name;
        this.brandName = brandName;
        this.suppliers = suppliers;
        this.packages = packages;
        this.unitPrice = unitPrice;
		this.packages = new ArrayList<Bundle>();
    }

    public Item(String name, String brandName, List<Supplier> suppliers, List<Bundle> packages, double unitPrice) {
        this.name = name;
        this.brandName = brandName;
        this.suppliers = suppliers;
        this.packages = packages;
        this.unitPrice = unitPrice;
    }

    public List<Bundle> getPackages() {
        return packages;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setPackages(List<Bundle> packages) {
        this.packages = packages;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
      
   
    public String getBrandName() {
        return brandName;
    }

    public String getName() {
        return name;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public void addSupplier(Supplier s) {
        suppliers.add(s);
    }
	
	public int sizeP(){
		return packages.size();
	}
	
	public Bundle getBundle(int i){
		return packages.get(i);
	}
	
	public Bundle getBundle(String u){
		for(int i = 0; i < sizeP(); i++){
			if(u.equalsIgnoreCase(packages.get(i).getUnit()))
				return packages.get(i);
		}
		return null;
	}
	
	public HashMap<String, Double> getSPs(int i){
		return packages.get(i).getHM();
	}
	
	public boolean isUExist(String u){
		for(int i = 0; i < sizeP(); i++){
			if(u.equalsIgnoreCase(packages.get(i).getUnit()))
				return true;
		}
		return false;
	}
	
	public void addSuppBundle(Supplier s, Double sP, String b, int m, Double p, String bN, String N){
		packages.add(new Bundle(b, m, p, bN, N));
		packages.get(sizeP()-1).addSuppPrice(s, sP);
	}
	
	public void delSuppBundle(String s){
		for(int i = 0; i < packages.size(); i++)
			if(packages.get(i).suppExist(s))
				if(packages.get(i).getHMSize()==1)
					packages.remove(i);
				else
					packages.remove(s);
	}
	
	public void printBundles(){
		for(int i = 0; i < sizeP(); i++)
			System.out.println(i+". "+getBundle(i).getUnit()+" = "+getBundle(i).getMeasurement()+" "+getBrandName()+" "+getName());
	}
	
	public void printBundles(String s){
		for(int i = 0; i < sizeP(); i++)
			if(getBundle(i).suppExist(s))
				System.out.println(i+". "+getBundle(i).getUnit()+" = "+getBundle(i).getMeasurement()+" "+getBrandName()+" "+getName());
	}

    public List<Supplier> getSuppliers() {
        return suppliers;
    }
	
	public Supplier getSupplier(int ctr){
		return suppliers.get(ctr);
	}

    //public HashMap<String, Double> getPrices() {  return prices;  }

    //public void setPrices(HashMap<String, Double> prices) {
        //this.prices = prices;
    //}
    
    public void setSellPrice(double price){}
    
 
    
}


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
        this.packages = packages;
        this.unitPrice = unitPrice;
    }
	
    public Item(String name, String brandName, Supplier s, double unitPrice) {//made for testing
        this.name = name;
        this.brandName = brandName;
        this.suppliers = new ArrayList<Supplier>();
		suppliers.add(s);
        this.packages = packages;
        this.unitPrice = unitPrice;
    }
	
    public Item(String name, String brandName, List<Supplier> suppliers, double unitPrice) {//made for testing
        this.name = name;
        this.brandName = brandName;
        this.suppliers = suppliers;
        this.packages = packages;
        this.unitPrice = unitPrice;
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

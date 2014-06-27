
import java.util.HashMap;
import java.util.List;

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
    private List suppliers;
    HashMap<String, Integer> prices = new HashMap<String, Integer>();

    public Item(String name, String brandName, List suppliers) {
        this.name = name;
        this.brandName = brandName;
        this.suppliers = suppliers;
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

    public void addSuppliers(List suppliers) {
        this.suppliers = suppliers;
    }

    public List getSuppliers() {
        return suppliers;
    }

    public HashMap<String, Integer> getPrices() {
        return prices;
    }

    public void setPrices(HashMap<String, Integer> prices) {
        this.prices = prices;
    }
    
    
    
 
    
}
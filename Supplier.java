/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
/**
 *
 * @author Win 7
 */
public class Supplier {
    private List<Item> supplies;
    private String name;

    public Supplier(String name) {//made for testing
        this.name = name;
    }

    public Supplier(List<Item> supplies, String name) {
        this.supplies = supplies;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getSupplies() {
        return supplies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSupplies(List<Item> supplies) {
        this.supplies = supplies;
    }
    
    
}

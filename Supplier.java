/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.List;
import java.util.ArrayList;
import Implementation.TransactionImpl;
import Implementation.BundleListImpl;
import Implementation.PriceImpl;
/**
 *
 * @author Win 7
 */
public class Supplier {
    private List<Item> supplies;
    private List<STransaction> history;
    private String name;
    private String contactNo;
    private TransactionImpl tI;
    private BundleListImpl bLI;
    private PriceImpl pI;

    public Supplier(){
		supplies = new ArrayList<Item>();
		history = new ArrayList<STransaction>();
                tI = new TransactionImpl();
                bLI = new BundleListImpl();
                pI = new PriceImpl();
    }
    public Supplier(String name, String num){
        this.name = name;
        this.contactNo = num;
		supplies = new ArrayList<Item>();
		history = new ArrayList<STransaction>();
                tI = new TransactionImpl();
                bLI = new BundleListImpl();
                pI = new PriceImpl();
    }
    public Supplier(String name) {//made for testing
        this.name = name;
		supplies = new ArrayList<Item>();
		history = new ArrayList<STransaction>();
                tI = new TransactionImpl();
                bLI = new BundleListImpl();
                pI = new PriceImpl();
    }

    public Supplier(List<Item> supplies, String name) {
        this.supplies = supplies;
        this.name = name;
		history = new ArrayList<STransaction>();
                tI = new TransactionImpl();
                bLI = new BundleListImpl();
                pI = new PriceImpl();
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

    
    public void addSTransaction(STransaction t){
		tI.addSupplierTransaction(t);
    }
    
    public void setHistory(List<STransaction> a){
        history = a;
    }
    
    public List<STransaction> getHistory(){
        return history;
    }
    
    public int sizeH(){
        return history.size();
    }
    
    public void setHistory(){
        history = getAllSTransaction();
    }
    public STransaction getH(int i){
        return history.get(i);
    }
    public List<STransaction> getAllSTransaction(){
                ArrayList<STransaction> a = tI.getAllSupplierTransaction(name);
                ArrayList<Bundle> b;
                for(int i = 0; i < a.size(); i++){
                        a.get(i).setTotal(0.0);
                        b = bLI.getSupplierBundle(a.get(i).getInVoice());
                        for(int j = 0; j < b.size(); j++){
                            a.get(i).addSell(b.get(j), pI.getPrice(b.get(j).getBrandName(),b.get(j).getName(),b.get(j).getUnit(),a.get(i).getTransacw()), bLI.getSTransactionQuantity(a.get(i).getInVoice(), b.get(j).getBrandName(), b.get(j).getName(), b.get(j).getUnit()));
                        }
                    }
		return a;
    }


}

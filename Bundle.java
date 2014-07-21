/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Win 7
 */
public class Bundle {
    private String unit;
    private int measurement;
    private Double packSellPrice;//user's dictated price to the item
	private HashMap<String, Double> prices;
	private ArrayList<String> supp;
	private String brandName, name;
	private int stocks;

	public Bundle(String u, int m, Double pSP, String bN, String N){
		setUnit(u);
		setMeasurement(m);
		setPackSellPrice(pSP);
		supp = new ArrayList<String>();
		prices = new HashMap<String, Double>();
		setBrandName(bN);
		setName(N);
		setStocks(0);
	}
	
	public void delSupplier(String s){
		prices.remove(s);
		supp.remove(s);
	}
	
    public int getMeasurement() {
        return measurement;
    }

    public Double getPackSellPrice() {
        return packSellPrice;
    }
	
	public Double getPrice(Supplier s){
		return prices.get(s.getName());
	}
	
	public String getSupp(int i){
		return supp.get(i);
	}
	
	public HashMap<String, Double> getHM(){
		return prices;
	}
	
	public String getUnit(){
		return unit;
	}
	
	public int getHMSize(){
		return prices.size();
	}
	
	public String getSupplier(int i){
		return supp.get(i);
	}
	
	public int getStocks(){
		return stocks;
	}
	
	public Double elemHM(int i){
		return elemHM(supp.get(i));
	}
	
	public Double elemHM(String s){
		return prices.get(s);
	}
	
	public boolean suppExist(String s){
		return prices.containsKey(s);
	}

    public void setMeasurement(int measurement) {
        this.measurement = measurement;
    }
	
	public void addStocks(int a){
		setStocks(stocks += a);
	}
	
	public void subtractStocks(int a){
		setStocks(stocks -= a);
	}
	
	public boolean checkStocks(int a){
		if((stocks-a)>=0)
			return true;
		return false;
	}
	
	public void addSuppPrice(Supplier s, Double p){
		prices.put(s.getName(), p);
		supp.add(s.getName());
	}

    public void setPackSellPrice(Double packSellPrice) {
        this.packSellPrice = packSellPrice;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
	

    public void setName(String name) {
        this.name = name;
    }
   
    public String getBrandName() {
        return brandName;
    }
	
	public void setStocks(int a){
		this.stocks = a;
	}
	
	public void printSuppliers(){
		for(int i = 0; i <getHMSize(); i++)
			System.out.println(i+". "+supp.get(i)+": "+elemHM(supp.get(i)));
	}
	
	public void printSuppliers2(){
		System.out.println(". Stocks: "+getStocks()+" Price: "+getPackSellPrice());
	}
	
	public void printSuppliers(String s){
		for(int i = 0; i <getHMSize(); i++)
			if(supp.get(i).equalsIgnoreCase(s)){
				System.out.println(i+". "+supp.get(i)+": "+elemHM(supp.get(i)));
				break;
				}
	}

    public String getName() {
        return name;
    }	
	
    
}

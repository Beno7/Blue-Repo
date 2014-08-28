package Logic;

import java.math.BigInteger;

public class BreakDown{
	private String inVoice;
	private int quantity;
	private BigInteger bundleID;
	private double price;
        
        public BreakDown(){
        }
	
	public BreakDown(String iV, int qty, BigInteger bID, double p){
		setInVoice(iV);
		setQuantity(qty);
		setBundleID(bID);
		setPrice(p);
	}
	
	//setters
	
	public void setInVoice(String iV){
		this.inVoice = iV;
	}
	
	public void setQuantity(int qty){
		this.quantity = qty;
	}
	
	public void setBundleID(BigInteger bI){
		this.bundleID = bI;
	}
	
	public void setPrice(double p){
		this.price = p;
	}
	
	//getters
	
	public String getInVoice(){
		return inVoice;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public BigInteger getBundleID(){
		return bundleID;
	}
	
	public double getPrice(){
		return price;
	}

}
package Logic;

import java.math.BigInteger;

public class PriceBean{
	private BigInteger bundleID;
	private BigInteger supplierID;
	private Double supplierPrice;
	private Double userPrice;
	
	public PriceBean(){
	}
	
	public PriceBean(BigInteger bI, BigInteger sI, Double sP, Double uP){
		setBundleID(bI);
		setSupplierID(sI);
		setSupplierPrice(sP);
		setUserPrice(uP);
	}
	
	//setters
	
	public void setBundleID(BigInteger i){
		this.bundleID = i;
	}
	
	public void setSupplierID(BigInteger i){
		this.supplierID = i;
	}
	
	public void setSupplierPrice(Double d){
		this.supplierPrice = d;
	}
	
	public void setUserPrice(Double d){
		this.userPrice = d;
	}
	
	//getters
	
	public BigInteger getBundleID(){
		return bundleID;
	}
	
	public BigInteger getSupplierID(){
		return supplierID;
	}
	
	public Double getSupplierPrice(){
		return supplierPrice;
	}
	
	public Double getUserPrice(){
		return userPrice;
	}
	
}
package Logic;

import java.math.BigInteger;
        
public class Item{
	private String brandName;
	private String name;
	private BigInteger itemID;
	private String unit;
	private int idealStock;
        private String location;
	private int qtyPerBundle;
        private Double unitPrice;
	private int stock;
	private int halfNo;
	
	public Item(){
		setStock(0);
	}
	
	public Item(String bN, String n, String u, int iS, String l, int qPB){
		setBrandName(bN);
		setName(n);
		setUnit(u);
		setQtyPerBundle(qPB);
		setIdealStock(iS);
                setLocation(l);
                setUnitPrice(0.0);
		setStock(0);
	}
	
	public Item(String bN, String n, String u, int iS, String l, int qPB, Double uP){
		setBrandName(bN);
		setName(n);
		setUnit(u);
		setQtyPerBundle(qPB);
		setIdealStock(iS);
                setLocation(l);
                setUnitPrice(uP);
		setStock(0);
	}
        
	public Item(String bN, String n, String u, int iS, String l, int qPB, Double uP, int s){
		setBrandName(bN);
		setName(n);
		setUnit(u);
		setQtyPerBundle(qPB);
		setIdealStock(iS);
                setLocation(l);
                setUnitPrice(uP);
		setStock(s);
	}
	
	//setters
	
	public void setBrandName(String n){
		this.brandName = n;
	}
	
	public void setName(String n){
		this.name = n;
	}
        
	public void setUnit(String u){
		this.unit = u;
	}
	
	public void setQtyPerBundle(int m){
		this.qtyPerBundle = m;
	}
	
	public void setIdealStock(int n){
		this.idealStock = n;
		this.halfNo = n/2;
	}
        
        public void setUnitPrice(Double d){
            unitPrice = d;
        }
        
	public void setStock(int s){
		this.stock = s;
	}
        
        public void setLocation(String l){
            location = l;
        }
	
	public void setItemID(BigInteger iD){
		this.itemID = iD;
	}
	
	//getters
	
	public String getBrandName(){
		return brandName;
	}
	
	public String getName(){
		return name;
	}
	
	public int getStock(){
		return stock;
	}
	
	public BigInteger getItemID(){
		return itemID;
	}
	public String getUnit(){
		return unit;
	}
	
	public int getQtyPerBundle(){
		return qtyPerBundle;
	}
	
	public int getIdealStock(){
		return idealStock;
	}
        
        public String getLocation(){
            return location;
        }
        
        public Double getUnitPrice(){
            return unitPrice;
        }
	
	public int getHalfNo(){
		return halfNo;
	}
	
	//stock update~ers
	
	public void addStock(int update){
		this.stock += update;
	}
	
	public void subtractStock(int update){
		this.stock -= update;
	}
	
	public boolean checkStockUpdate(int update){
		if((stock-update)>=0)
			return true;
		else
			return false;
	}
	
}
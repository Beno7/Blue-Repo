

package Logic;

import java.util.HashMap;
import java.util.ArrayList;
import Implementation.PriceImpl;
import Implementation.SupplierImpl;
import Implementation.BundleImpl;
import java.lang.Double;

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
	private SupplierImpl sI;
	private PriceImpl pI;
        private BundleImpl bI;

        public Bundle(){
		supp = new ArrayList<String>();
		prices = new HashMap<String, Double>();
		sI = new SupplierImpl();
		pI = new PriceImpl();
                bI = new BundleImpl();
        }
        
        public void setSupplier(String s){
		supp = new ArrayList<String>();
		prices = new HashMap<String, Double>();
		sI = new SupplierImpl();
		pI = new PriceImpl();
        }
        
        
	public Bundle(String u, int m, Double pSP, String bN, String N){
		setUnit(u);
		setMeasurement(m);
		setPackSellPrice(pSP);
		supp = new ArrayList<String>();
		prices = new HashMap<String, Double>();
		setBrandName(bN);
		setName(N);
		setStocksA(0);
		sI = new SupplierImpl();
		pI = new PriceImpl();
	}
	
	/*public void delSupplier(String s){
		prices.remove(s);
		supp.remove(s);
	}*/
	
	public void setHashMap(){
		
		supp = new ArrayList<String>();
		prices = new HashMap<String, Double>();
		Double j;
		for(int i = 0; i < sI.getAllSupplier().size(); i++){
			j = pI.getPrice(brandName, name, unit, sI.getAllSupplier().get(i).getName());
			if(j.compareTo(0.0)>0){
                                setSuppPrice(sI.getAllSupplier().get(i), j);
			}
		}
	}
    public boolean checkName(String s){
        setHashMap();
        return supp.contains(s);
    }
	
    public int getMeasurement() {
        return measurement;
    }

    public Double getPackSellPrice() {
        return packSellPrice;
    }
    
    public String getSupplier(){
        return supp.get(0);
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
                setHashMap();
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
        
        public void addPricetoDB(Supplier s, Double p){
                pI.addPrice(p, brandName, name, unit, s.getName());
        }
	
	public void setSuppPrice(Supplier s, Double p){
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
	
    public void printSupplier(String s){
        setHashMap();
        System.out.println(s+": "+elemHM(s));
        
    }
	public void setStocks(int a){
		this.stocks = a;
                bI.updateStock(getBrandName(), getName(), getStocks(), getUnit());
	}
	public void setStocksA(int a){
		this.stocks = a;
	}
	
	public void printSuppliers(){
		setHashMap();
		for(int i = 0; i <getHMSize(); i++)
			System.out.println(supp.get(i)+": "+elemHM(supp.get(i)));
	}
	
	public void printSuppliers2(){
		setHashMap();
		System.out.println("Stocks: "+getStocks()+" Price: "+getPackSellPrice());
	}
	
	public void printSuppliers(String s){
		setHashMap();
		for(int i = 0; i <getHMSize(); i++)
			if(supp.get(i).equalsIgnoreCase(s)){
				System.out.println(supp.get(i)+": "+elemHM(supp.get(i)));
				break;
				}
	}

    public String getName() {
        return name;
    }	
	
    
}

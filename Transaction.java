


package Logic;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Win 7
 */

public abstract class Transaction{
    
    private String inVoice;
    private Double total;
    private Date dBuy; 
    private HashMap<String, Integer> qty;
    private HashMap<String, Double> prices;
	
        public Transaction(){
		qty = new HashMap<String, Integer>();
		prices = new HashMap<String, Double>();
        }

	public Transaction(String iV, Date dBuy){
		setInVoice(iV);
		setBuyDate(dBuy);
		setTotal(0);
		qty = new HashMap<String, Integer>();
		prices = new HashMap<String, Double>();
	}    

	public void addQty(String i, int num){
		qty.put(i, num);
	}
	
	public void addPrice(String i, Double d){
		prices.put(i, d);
	}
	
	
	public Double getPrice(String i){
		return prices.get(i);
	}
	
	public int getQty(String i){
		return qty.get(i);
	}
	public int qtySize(){
		return qty.size();
	}
	
    public String getInVoice() {
        return inVoice;
    }

    public double getTotal() {
        return total;
    }

    public void setBuyDate(Date buyDate) {
        this.dBuy = buyDate;
    }
    public void setBuyDate(java.sql.Date d){
	dBuy = new java.util.Date(d.getTime());
    }
    public Date getBuyDate() {
        return dBuy;
    }

    public void setInVoice(String inVoice) {
        this.inVoice = inVoice;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   
    
    
}

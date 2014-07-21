
package Logic;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import Implementation.BundleListImpl;

public class STransaction extends Transaction{
	private int terms;
	private String transacw;
	private List<Bundle> bundles;
	private Date deadLine;
	private Double tTotal;
        private BundleListImpl bLI;
	
	public STransaction(){
            super();
            bundles = new ArrayList<Bundle>();
            bLI = new BundleListImpl();
            tTotal = 0.0;
	}
        
	public STransaction(String iV, Date dBuy, String name){
		super(iV, dBuy);
		bundles = new ArrayList<Bundle>();
		setTransactw(name);
		tTotal = 0.0;
                bLI = new BundleListImpl();
	}
	
	public STransaction(String iV, Date dBuy, int terms, String name){
		super(iV, dBuy);
		setTerm(terms);
		bundles = new ArrayList<Bundle>();
		setTransactw(name);
		tTotal = 0.0;
                bLI = new BundleListImpl();
	}
	
	public void addBundle(Bundle b){
		bundles.add(b);
	}
	
	public void addSell(Bundle b, Double d, int i){
		addBundle(b);
		super.addQty(b.getBrandName()+" "+b.getName()+" "+b.getUnit(), i);
		super.addPrice(b.getBrandName()+" "+b.getName()+" "+b.getUnit(), d*i);
		tTotal += d*i;
		super.setTotal(tTotal);
	}
	
	public void setTerm(int t){
		this.terms = t;
		Calendar c = new GregorianCalendar();
		c.setTime(super.getBuyDate());
		c.add(Calendar.DATE, t); 
		setPayDeadLine(c.getTime());
	}
	public void setTermNoDate(int t){
		this.terms = t;
	}
	
	public void setPayDeadLine(Date d){
		deadLine = d;
	}
	
	public void setPayDeadLine(java.sql.Date d){
		deadLine = new Date(d.getTime());
	}
	
	public Date getDeadLine(){
		return deadLine;
	}
        
	public void setDeadLine(Date d){
		deadLine = d;
	}
        
	public int qtySize(){
            return super.qtySize();
        }
        
	public void updateStocks(){
		for(int i = 0; i < super.qtySize(); i++){
			bundles.get(i).addStocks(super.getQty(bundles.get(i).getBrandName()+" "+bundles.get(i).getName()+" "+bundles.get(i).getUnit()));
		}
	}
        
        public void updateBundleList(){
		for(int i = 0; i < super.qtySize(); i++)
                        bLI.addSupplierBundle(super.getInVoice(), bundles.get(i), super.getQty(bundles.get(i).getBrandName()+" "+bundles.get(i).getName()+" "+bundles.get(i).getUnit()));
        }
        
        public BundleListImpl bLI(){
            return bLI;
        }
	
	public void setTransactw(String n){
		this.transacw = n;
	}
	
	public int getTerm(){
		return terms;
	}
	
	public Double getT(){
		return super.getTotal();
	}
	
	public String getTransacw(){
		return transacw;
	}
	
	public Bundle getB(int i){
		return bundles.get(i);
	}
	public void  printTrans(){
		System.out.println("------------------");
		System.out.println("Transaction:");
		System.out.println("Supplier: "+transacw);
		System.out.println("Invoice:"+ super.getInVoice());
		System.out.println("terms: "+ getTerm());
		System.out.println("Transaction Date: "+ super.getBuyDate());
		System.out.println("Payment Deadline: "+getDeadLine());
		for(int i = 0; i < super.qtySize(); i++){
			System.out.println(bundles.get(i).getBrandName()+" "+bundles.get(i).getName()+" "+bundles.get(i).getUnit()+" x "+super.getQty(bundles.get(i).getBrandName()+" "+bundles.get(i).getName()+" "+bundles.get(i).getUnit())
			+"\t"+super.getPrice(bundles.get(i).getBrandName()+" "+bundles.get(i).getName()+" "+bundles.get(i).getUnit()));
		}
		System.out.println("Total: "+super.getTotal());
		System.out.println();
	}
    public void printBreakDown(){
        ArrayList<Bundle> aB = bLI.getSupplierBundle(super.getInVoice());
        Double d = 0.0;
        System.out.println("Invoice:"+super.getInVoice());
        for(int i = 0; i < aB.size(); i++){
            bLI.getSTransactionQuantity(super.getInVoice(), aB.get(i).getBrandName(), aB.get(i).getName(), aB.get(i).getUnit());
            d+=aB.get(i).getPackSellPrice()*bLI.getSTransactionQuantity(super.getInVoice(), aB.get(i).getBrandName(), aB.get(i).getName(), aB.get(i).getUnit());
            System.out.println(aB.get(i).getBrandName()+" "+aB.get(i).getName()+" "+aB.get(i).getUnit()+" x "+bLI.getSTransactionQuantity(super.getInVoice(), aB.get(i).getBrandName(), aB.get(i).getName(), aB.get(i).getUnit())
            +"\t"+(aB.get(i).getPackSellPrice()*bLI.getSTransactionQuantity(super.getInVoice(), aB.get(i).getBrandName(), aB.get(i).getName(), aB.get(i).getUnit())));
        }
        System.out.println("Total:"+d);
    }
}
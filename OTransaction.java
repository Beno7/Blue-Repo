
package Logic;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OTransaction extends STransaction{
	
        public OTransaction(){
            super();
        }
	public OTransaction(String iV, Date dBuy, String name){
		super(iV, dBuy, name);
	}
	
	public OTransaction(String iV, Date dBuy, int terms, String name){
		super(iV, dBuy, terms, name);
	}
	
	public void addBundle(Bundle b){
		super.addBundle(b);
	}
	
	public void addSell(Bundle b, Double d, int i){
		super.addSell(b, d, i);
	}
	
	public void setTerm(int t){
		super.setTerm(t);
	}
        
	public void setTermNoDate(int t){
		super.setTermNoDate(t);
	}
	
	public void setPayDeadLine(Date d){
		super.setPayDeadLine(d);
	}
	
	public Date getDeadLine(){
		return super.getDeadLine();
	}
	
	public void updateStocks(){
		for(int i = 0; i < super.qtySize(); i++){
			super.getB(i).subtractStocks(super.getQty(super.getB(i).getBrandName()+" "+super.getB(i).getName()+" "+super.getB(i).getUnit()));
		}
	}
        
        public void updateBundleList(){
		for(int i = 0; i < super.qtySize(); i++)
                        super.bLI().addOfficeBundle(super.getInVoice(), super.getB(i), super.getQty(super.getB(i).getBrandName()+" "+super.getB(i).getName()+" "+super.getB(i).getUnit()));
        }
	
	public boolean checkStocks(){
		for(int i = 0; i < super.qtySize(); i++)
			if(!super.getB(i).checkStocks(super.getQty(super.getB(i).getBrandName()+" "+super.getB(i).getName()+" "+super.getB(i).getUnit())))
				return false;
		return true;
	}
	
	public void setTransactw(String n){
		super.setTransactw(n);
	}
	
	public int getTerm(){
		return super.getTerm();
	}
	
	public Double getT(){
		return super.getT();
	}
	
	public String getTransacw(){
		return super.getTransacw();
	}
	
	public void  printTrans(){
		super.printTrans();
	}
}
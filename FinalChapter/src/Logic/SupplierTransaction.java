
package Logic;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.math.BigInteger;

public class SupplierTransaction extends WholeSale{

	private SBreakDownManager sBD;
	
	public SupplierTransaction(){
        super();
		sBD = new SBreakDownManager();
	}
        
	public SupplierTransaction(String iV, Date d, String trans, int terms, BigInteger sID){
		super(iV, d, trans, terms, sID);
		sBD = new SBreakDownManager(iV);
	}
        
	public SupplierTransaction(String iV, double t, Date d, String trans, int terms, BigInteger sID){
		super(iV, t, d, trans, terms, sID);
		sBD = new SBreakDownManager(iV);
	}
	
	public void setSBD(String iV){
		sBD = new SBreakDownManager(iV);
                setInVoice(iV);
	}
	
	public void addBreakDownTemp(BreakDown bD){
		sBD.addBDTemp(bD);
	}
	
        public boolean checkBreakDown(String bN, String n, String u){
            return sBD.checkBreakDown(bN, n, u);
        }
        
	public void commitBreakDown(){
		sBD.commitBreakDown();
	}
	
	public void printBreakDownTemp(){
		sBD.printBreakDownTemp();
	}
	
	public void printBreakDown(){
		sBD.printBreakDown();
	}
	
}
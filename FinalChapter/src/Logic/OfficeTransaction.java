
package Logic;
import java.math.BigInteger;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OfficeTransaction extends WholeSale{
	

	private OBreakDownManager oBD;
	
	public OfficeTransaction(){
                super();
		oBD = new OBreakDownManager();
	}
        
	public OfficeTransaction(String iV, Date d, String trans, int terms, BigInteger sID){
		super(iV, d, trans, terms, sID);
		oBD = new OBreakDownManager(iV);
	}
        
	public OfficeTransaction(String iV, double t, Date d, String trans, int terms, BigInteger sID){
		super(iV, t, d, trans, terms, sID);
		oBD = new OBreakDownManager(iV);
	}
	
	public void setSBD(String iV){
		oBD = new OBreakDownManager(iV);
                setInVoice(iV);
	}
	
	public void addBreakDownTemp(BreakDown bD){
		oBD.addBDTemp(bD);
	}
	
        public boolean checkBreakDown(String bN, String n, String u){
            return oBD.checkBreakDown(bN, n, u);
        }
        
        public OBreakDownManager getBDM(){
            return oBD;
        }
        
	public void commitBreakDown(){
		oBD.commitBreakDown();
	}
	
	public void printBreakDownTemp(){
		oBD.printBreakDownTemp();
	}
	
	public void printBreakDown(){
		oBD.printBreakDown();
	}
	
}
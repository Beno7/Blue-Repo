
package Logic;
import java.util.List;
import java.util.ArrayList;
import Implementation.TransactionImpl;

public class TransactionDB{
	private List<STransaction> strans;
	private List<OTransaction> otrans;
        private TransactionImpl tI;
	
	public TransactionDB(){
                tI = new TransactionImpl();
		strans = new ArrayList<STransaction>();
		otrans = new ArrayList<OTransaction>();
	}
	
	public void addSTrans(STransaction t){
		tI.addSupplierTransaction(t);
	}
	
	public STransaction getSTrans(int t){
		return strans.get(t);
	}
	
	public STransaction getSTrans(String iV){
		return tI.getSupplierTransaction(iV);
	}
	
	public int sizeS(){
		return strans.size();
	}
        
	public void printSTrans(int i){
		strans.get(i).printTrans();
	}
	
	public void printSTrans(String iV){
		tI.getSupplierTransaction(iV).printTrans();
	}
	
	//
	
	public void addOTrans(OTransaction t){
		otrans.add(t);
	}
	
	public void rLOTrans(){
		otrans.remove(sizeO()-1);
	}
	
	public OTransaction getOTrans(int t){
		return otrans.get(t);
	}
	
	public int sizeO(){
		return otrans.size();
	}
	
	public void printOTrans(int i){
		otrans.get(i).printTrans();
	}

}
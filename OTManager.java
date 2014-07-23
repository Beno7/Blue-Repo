package Logic;
import Implementation.TransactionImpl;
import Implementation.BundleListImpl;
import java.util.List;
import java.util.ArrayList;
public class OTManager{

    private List<OTransaction> history;
    private TransactionImpl tI;
    private BundleListImpl bLI;
	
	public OTManager(){
        tI = new TransactionImpl();
        bLI = new BundleListImpl();
		history = new ArrayList<OTransaction>();    
	}
    
    public void addOTransaction(OTransaction t){
		tI.addOfficeTransaction(t);
    }
    
    public List<OTransaction> getOTransaction(){
		return history;
    }
    
    public void setHistory(String name){
        history = getAllOTransaction(name);
    }
	
    public List<OTransaction> getAllOTransaction(String name){
                ArrayList<OTransaction> a = tI.getAllOfficeTransaction(name);
                ArrayList<Bundle> b;
                for(int i = 0; i < a.size(); i++){
                        a.get(i).setTotal(0.0);
                        b = bLI.getOfficeBundle(a.get(i).getInVoice());
                        for(int j = 0; j < b.size(); j++){
                            a.get(i).addSell(b.get(j), b.get(j).getPackSellPrice(), bLI.getOTransactionQuantity(a.get(i).getInVoice(), b.get(j).getBrandName(), b.get(j).getName(), b.get(j).getUnit()));
                        }
                    }
		return a;
    }
	
    public OTransaction getH(int i){
        return history.get(i);
    }
	    
    public int sizeH(){
        return history.size();
    }
	
}
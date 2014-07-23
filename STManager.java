package Logic;
import Implementation.TransactionImpl;
import Implementation.PriceImpl;
import Implementation.BundleListImpl;
import java.util.ArrayList;
import java.util.List;
public class STManager{

    private PriceImpl pI;
    private TransactionImpl tI;
    private BundleListImpl bLI;
    private List<STransaction> history;
	
	public STManager(){
        tI = new TransactionImpl();
        pI = new PriceImpl();
        bLI = new BundleListImpl();
		history = new ArrayList<STransaction>();
	}
    
    public void addSTransaction(STransaction t){
		tI.addSupplierTransaction(t);
    }
    
    public void setHistory(List<STransaction> a){
        history = a;
    }
    
    public List<STransaction> getHistory(){
        return history;
    }
    
    public int sizeH(){
        return history.size();
    }
    
    public void setHistory(String name){
        history = getAllSTransaction(name);
    }
	
    public STransaction getH(int i){
        return history.get(i);
    }
	
    public List<STransaction> getAllSTransaction(String name){
                ArrayList<STransaction> a = tI.getAllSupplierTransaction(name);
                ArrayList<Bundle> b;
                for(int i = 0; i < a.size(); i++){
                        a.get(i).setTotal(0.0);
                        b = bLI.getSupplierBundle(a.get(i).getInVoice());
                        for(int j = 0; j < b.size(); j++){
                            a.get(i).addSell(b.get(j), pI.getPrice(b.get(j).getBrandName(),b.get(j).getName(),b.get(j).getUnit(),a.get(i).getTransacw()), bLI.getSTransactionQuantity(a.get(i).getInVoice(), b.get(j).getBrandName(), b.get(j).getName(), b.get(j).getUnit()));
                        }
                    }
		return a;
    }
}
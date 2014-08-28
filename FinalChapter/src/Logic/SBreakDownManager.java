package Logic;

import Implementation.BundleListImpl;
import java.util.ArrayList;
import java.math.BigInteger;

public class SBreakDownManager{

	private BundleListImpl bLI;
	private Manager bM;
	private String inVoice;
	private ArrayList<BreakDown> bDs;
	
	public SBreakDownManager(){
		bDs = new ArrayList<BreakDown>();
		bLI = new BundleListImpl();
		bM = new Manager();
		inVoice = "";
	}
	
	public SBreakDownManager(String iV){
		bDs = new ArrayList<BreakDown>();
		bLI = new BundleListImpl();
		bM = new Manager();
		inVoice = iV;
	}
	
	
	//for DB
    public ArrayList<BreakDown> getBD() {
        return bLI.getSupplierBundle(inVoice);
    }
	
	public void addBD(BreakDown b){
		bLI.addSupplierBundle(b);
	}
	
	public void getQuantity(String iV, BigInteger bundleID){
		bLI.getSTransactionQuantity(iV, bundleID);
	}
	
	public double getTotal(){
		setAllBreakDown(getBD());
                return getTotalTemp();
	}
	
	public void commitBreakDown(){
		for(int i = 0; i < sizeBD(); i++){
			addBD(getBD(i));
		}
	}
        
        public boolean checkBreakDown(String bN, String n, String u){
            Item a;
            for(int i = 0; i < bDs.size(); i++){
                a = bM.getB(bDs.get(i).getBundleID());
                if(bN.equalsIgnoreCase(a.getBrandName())&&n.equalsIgnoreCase(a.getName())&&u.equalsIgnoreCase(a.getUnit()))
                    return true;
            }
            return false;
        }
        
    public double getTotalTemp(){
		double t = 0.0;
        for(int i = 0; i < sizeBD(); i++){
			t = t + (getBD(i).getPrice()*(getBD(i).getQuantity()*1.0));
		}
		return t;
    }
	
	//for ArrayList
	
	public void addBDTemp(BreakDown bD){
		bDs.add(bD);
	}
	
	public BreakDown getBD(int ctr){
		return bDs.get(ctr);
	}
	
	public int sizeBD(){
		return bDs.size();
	}
    
	public void setAllBreakDown(ArrayList<BreakDown> s){
		this.bDs = s;
	}
	
	public void printBreakDown(){
		setAllBreakDown(getBD());
		printBreakDownTemp();
	}
	
	public void printBreakDownTemp(){
		Item b;
		System.out.println();
        for(int i = 0; i < sizeBD(); i++){
			b = bM.getB(bDs.get(i).getBundleID());
			printBreakDown(getBD(i), b);
		}
		System.out.println("\nTotal:\t"+getTotalTemp());
	}
	
	public void printBreakDown(BreakDown bD, Item b){
		System.out.println(b.getBrandName()+" "+b.getName()+" "+b.getUnit()+" "+bD.getPrice()+" x "+bD.getQuantity()+"\t"+"Php "+(bD.getPrice()*bD.getQuantity()));
	}
	
}
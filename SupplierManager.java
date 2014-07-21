/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.List;
import java.util.ArrayList;
import Implementation.SupplierImpl;
import Implementation.TransactionImpl;
/**
 *
 * @author Win 7
 */
public class SupplierManager {
    private List<Supplier> suppliers;

	//private List<Supplier> s;
	private SupplierImpl sI;
        private TransactionImpl tI;
	
	public SupplierManager(){
		sI = new SupplierImpl();
                tI = new TransactionImpl();
	}	
	
	public Supplier getS(String supplier){
		return sI.getSupplier(supplier);
	}
	
	public void addS(Supplier supplier){
		sI.addSupplier(supplier);
	}
	
	public Supplier getS(int ctr){
		return suppliers.get(ctr);
	}
	
	public int sizeS(){
		return suppliers.size();
	}
	
	public void setAllSupplier(List<Supplier> s){
		this.suppliers = s;
	}
	
	public List<Supplier> getAllSupplier(){
		setAllSupplier(sI.getAllSupplier());
		return suppliers;
	}
	
	public void printSuppliers(){
		setAllSupplier(sI.getAllSupplier());
		System.out.println("--------------");
        for(int i = 0; i < sizeS(); i++){
			printSupplier(i);
			System.out.println("--------------");
		}
	}
	
	public void printSupplier(int i){
		System.out.println();
        System.out.print("Supplier name: ");
        System.out.println(getS(i).getName());
        System.out.print("Contact number: ");
        System.out.println(getS(i).getContact());
	}
        
        public void printAllTransactions(){
            setAllSupplier(sI.getAllSupplier());
            for(int i = 0; i < sizeS(); i++){
                getS(i).setHistory();
                for(int j = 0; j < getS(i).sizeH(); j++){
                    getS(i).getH(j).printTrans();
                    //getS(i).getH(j).printBreakDown();
                }
            }
        }
        public void printTransaction(String iV){
            tI.getSupplierTransaction(iV).printTrans();
        }
    
	
	/*public void printSuppliers(){//prints each supplier's information
		System.out.println("--------------");
        for(int i = 0; i < sizeS(); i++){
			printSupplier(i);
			System.out.println("--------------");
		}
	}
	
	public boolean checkSupplyExist(String bN, String N, Supplier s){//checks if a given supplier supplies a specific item
		for(int i = 0; i < s.getSupplies().size(); i++)
			if(s.getSupplies().get(i).getBrandName().equals(bN)&&s.getSupplies().get(i).getName().equals(N))
				return true;
		return false;
	}
	
	public void printSupplier(int i){
		System.out.println();
        System.out.print("Supplier name: ");
        System.out.println(getS(i).getName());
        for(int j = 0; j < getS(i).getSupplies().size(); j++){
			System.out.println();
            Item k = getS(i).getSupplies().get(j);
            System.out.print("BrandName: ");
            System.out.println(k.getBrandName());
            System.out.print("Name: ");
            System.out.println(k.getName());
            System.out.print("UnitPrice: ");
            System.out.println(k.getUnitPrice());
			System.out.println("Suppliers: ");
			for(int y = 0; y < k.getSuppliers().size(); y++)
				System.out.println(k.getSuppliers().get(y).getName());
			System.out.println("Bundles: ");
			for(int y = 0; y < k.sizeP(); y++){
				System.out.println("Name: "+k.getBundle(y).getUnit());
				System.out.println("number of"+k.getBrandName()+" "+k.getName()+": "+k.getBundle(y).getMeasurement());
				System.out.println("package sellprice: "+k.getBundle(y).getPackSellPrice());
				System.out.println("Stocks: "+k.getBundle(y).getStocks());
				System.out.println("Supplier's pricing:");
				Bundle a = k.getBundle(y);
				for(int z = 0; z < a.getHMSize(); z++)
					System.out.println(a.getSupp(z)+": "+a.elemHM(a.getSupp(z)));
			}
			System.out.println();
		}
	}*/
}

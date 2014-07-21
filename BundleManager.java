/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.List;
import java.util.ArrayList;
import Implementation.BundleImpl;
import Implementation.PriceImpl;
/**
 *
 * @author Win 7
 */
public class BundleManager {

	private BundleImpl bI;
	private PriceImpl pI;
	private ArrayList<Bundle> bundles;
	
	public BundleManager(){
		bI = new BundleImpl();
		pI = new PriceImpl();
	}	
	
	public Bundle getB(String bN, String n, String u){
		return bI.getBundle(bN, n, u);
	}
	
	public void addB(Bundle b){
		bI.addBundle(b);
	}
	
	public Bundle getB(int i){
		return bundles.get(i);
	}
        
	
	public int sizeB(){
		return bundles.size();
	}
        
	public void printName(int i){
		System.out.println("BrandName: "+bundles.get(i).getBrandName());
		System.out.println("Name: "+bundles.get(i).getName());
		System.out.println();
	}
    
	public void printNames(){
		bundles = bI.getAllBundle();
		System.out.println("--------------");
        for(int i = 0; i < sizeB(); i++){
			printName(i);
			System.out.println("--------------");
		}
	}
    
	public void printNames(String s){
		bundles = bI.getAllBundle();
		System.out.println("--------------");
        for(int i = 0; i < sizeB(); i++){
            if(bundles.get(i).checkName(s))
			printName(i);
			System.out.println("--------------");
		}
	}
	
	/*public void sort(){
		for(int i = 0; i < sizeB()-1; i++)
			for(int j = 0; j < sizeB(); j++)
				if(bundles.get(i).getName())
			
        }*/
    
	public void printBundles(String bN, String n){
		bundles = bI.getAllBundle();
		System.out.println("--------------");
        for(int i = 0; i < sizeB(); i++){
			if(bN.equalsIgnoreCase(bundles.get(i).getBrandName())&&n.equalsIgnoreCase(bundles.get(i).getName()))
				printBundle(i);
			System.out.println("--------------");
		}
	}
    
	public void printBundles(String bN, String n, String s){
		bundles = bI.getAllBundle();
		System.out.println("--------------");
        for(int i = 0; i < sizeB(); i++){
			if(bN.equalsIgnoreCase(bundles.get(i).getBrandName())&&n.equalsIgnoreCase(bundles.get(i).getName())&&bundles.get(i).checkName(s))
				printBundle(i);
			System.out.println("--------------");
		}
	}
	
	public void printBundle(int i){
		System.out.println("Package: "+bundles.get(i).getUnit());
		System.out.println("Stock: "+bundles.get(i).getStocks());
		System.out.println();
	}
	
	public void printSuppliers(int i){
		bundles.get(i).printSuppliers();
	}
	
	public void addSupplier(String bN, String n, String s, String u, Double d){
		pI.addPrice(d, bN, n, u, s);
	}
}

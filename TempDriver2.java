
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import Logic.MainProg;

class TempDriver2{
	
	public static void main(String args[]){
		//Beno's attributes
		//List<Supplier> dBS = new ArrayList<Supplier>();
		
		/*//Raffy's attributes
		String loopScan, inS1, inS2;
		double unitPrice;
		int search;*/
		
		MainProg m = new MainProg();
		m.addSupplier();//adds supplier
		m.buySupply();
		m.addOffice();
                m.sellSupply();
		/*m.addItem();//adds item
		m.searchSupplier();
		m.editItem();
		m.searchItem();*/
		
	}
	
}
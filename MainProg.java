import java.util.Scanner;

public class MainProg{

	private	Scanner inS;
	private	String sN;//supplier name
	private	String bN, N;//Items primary key
	private	Double price;//price of Item
	private	WRInventory wR;//instance of inventory
	private	Item tempI;//temporary Item variable
	private	int bool;//to check if supplier exists in db
	private	SupplierManager sM;
	
	public MainProg(){
		this.inS = new Scanner(System.in);
		this.wR = new WRInventory();
		this.sM = new SupplierManager();
	}
	
	public void addSupplier(){//method for adding supplier
		do{
			System.out.println("Segment: adding Supplier");
			System.out.print("Enter supplier name:");
			sN = inS.next().toUpperCase();
			
			bool = sM.checkDB(sN);
			if(bool==-1)//to check if supplier exists in its Database
				sM.addS(new Supplier(sN));
			else{
				System.out.print("Supplier already exists, overwrite? (y/n):");
				overW();
			}
			do{
				System.out.print("Enter item's brand:");
				bN = inS.next().toUpperCase();
				System.out.print("Enter item's name:");
				N = inS.next().toUpperCase();
				System.out.print("Enter item's price:");
				price = inS.nextDouble();
				if(!sM.checkSupplyExist(bN, N, sM.getLS()))
					addItem2Supp(N, bN, price);//adds item to supplier and wRInventory
				else
					System.out.println("Error, supplier already supplies the said item");
				System.out.print("Do you want to add another item to this supplier? (Y/N):");
			} while(inS.next().equalsIgnoreCase("y"));
			System.out.println();
			System.out.print("Do you want to add another supplier? (Y/N):");
		} while(inS.next().equalsIgnoreCase("y"));
		sM.printSuppliers();
	}
	
	public void addItem(){//method for adding an item to supplier
		do{
			System.out.println("Segment: adding item to supplier");
			System.out.print("Enter supplier name:");
			sN = inS.next().toUpperCase();
			
			bool = sM.checkDB(sN);
			if(bool!=-1){//to check if supplier exists in its Database
				System.out.println("Supplier successfully loaded");
				sM.printSupplier(bool);
				Supplier s = sM.getS(bool);
				sM.swap(bool, s);
				do{
					System.out.print("Enter item's brand:");
					bN = inS.next().toUpperCase();
					System.out.print("Enter item's name:");
					N = inS.next().toUpperCase();
					System.out.print("Enter item's price:");
					price = inS.nextDouble();
					if(!sM.checkSupplyExist(bN, N, sM.getLS())){
						addItem2Supp(N, bN, price);//adds item to supplier and wRInventory
						sM.printSupplier(sM.sizeS()-1);
					}
					else
						System.out.println("Error, supplier already supplies the said item");//adds item to supplier and wRInventory
					System.out.print("Do you want to add another item to this supplier? (Y/N):");
				} while(inS.next().equalsIgnoreCase("y"));
			}
			else
				System.out.println("Error, the supplier doesn't exist");
			System.out.println();
			System.out.print("Do you want to add another item to a supplier? (Y/N):");
		} while(inS.next().equalsIgnoreCase("y"));
		sM.printSuppliers();
	}
	
	public void addItem2Supp(String N, String bN, Double price){
		tempI = new Item(N, bN, sM.getLS(), price);
		if(wR.searchItem(tempI.getBrandName(), tempI.getName())==null)//if item doesn't exist yet
			wR.addItem(tempI);//adds the added item to the list of inventory
		else//if item exists in the WRInventory
			wR.addSupplier(bN, N, sM.getLS()); //adds the latest supplier to the recently added item			
		sM.getLS().addSupply(wR.searchItem(tempI.getBrandName(), tempI.getName()));//adds the added item to supplier
	}
	
	public void overW(){
		if(inS.next().equalsIgnoreCase("y")){
			sM.swap(bool, new Supplier(sN));//overwrites the supplier
			wR.delSupplier(new Supplier(sN));
		}
	}
}

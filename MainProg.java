import java.util.Scanner;
import java.util.List;

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
		System.out.println("Segment: adding Supplier");
		do{
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
		System.out.println("Segment: adding item to supplier");
		do{
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
	
	public void searchItem(){
		System.out.println("Segment: Item search");
		do{
			System.out.print("Enter item's brandname:");
			bN = inS.next().toUpperCase();
			System.out.print("Enter item's name:");
			N = inS.next().toUpperCase();
			Item k = wR.searchItem(bN, N);
			if(k!=null){
				System.out.println("\n--------------");
				System.out.println("Item found!!!");
				System.out.println("brandname: " + k.getBrandName());
				System.out.println("name: " + k.getName());
				System.out.printf("price: %f\n", k.getUnitPrice());
				System.out.println("Suppliers:");
				for(int i = 0; i < k.getSuppliers().size(); i++)
					System.out.println(k.getSupplier(i).getName());
				System.out.println("--------------");
			} else
				System.out.println("Error!!! Item doesn't exist!!!");
			System.out.print("Do you want to search for another item? (Y/N):");
		} while(inS.next().equalsIgnoreCase("y"));
	}
	
	public void searchSupplier(){
			System.out.println("\nSegment: Supplier search");
		do{
			System.out.print("Enter supplier name:");
			sN = inS.next().toUpperCase();
			
			bool = sM.checkDB(sN);
			if(bool!=-1){//to check if supplier exists in its Database
				System.out.println("Supplier Found!!!");
				System.out.println("--------------");
				sM.printSupplier(bool);
				System.out.println("--------------");
			} else
				System.out.println("Error!!! Supplier doesn't exist!!!");
			System.out.println("Do you want to search for another supplier? (Y/N):");
		} while(inS.next().equalsIgnoreCase("y"));
	}
	
	public void editItem(){
		int search;
		Double unitPrice;
		String inS1, inS2;
		System.out.println("\nEdit Item");
        do{
            List<Item> cut;
            int itemCount = 0;
            System.out.println("Do you want to edit an Item? (y/n) : ");
            if(inS.next().equals("y")){
                    System.out.println("Enter a Supplier: ");
                    for(int i = 0; i < sM.sizeS(); i++) {
                        System.out.println(i + ")" + sM.getS(i).getName() + "\n");
                    }
                    search = inS.nextInt();
                    for(int i = 0; i < sM.sizeS(); i++){
                        if(i == search){
                            cut = sM.getS(i).getSupplies();
                            System.out.println("Choose Item: ");
                            for(int j = 0; j < cut.size(); j++){
                                System.out.println(j + ")" + cut.get(j).getBrandName());
                                System.out.println("  " + cut.get(j).getName());
                                System.out.println("  " + cut.get(j).getUnitPrice());
                                itemCount++;
                            }
                            search = inS.nextInt();
                            System.out.println("ITEMCOUNT == " + itemCount);
                            for(int a = 0; a < itemCount; a++){
                                if(a == search){
                                    System.out.println("ENTER CONDITION");
                                    System.out.println("Enter new brand name: ");
                                    inS1 = inS.next().toUpperCase();
                                    System.out.println("Enter new item name: ");
                                    inS2 = inS.next().toUpperCase();
                                    System.out.println("Enter new unit price: ");
                                    unitPrice = inS.nextDouble();
                                    sM.getS(i).getSupplies().get(a).setBrandName(inS1);
                                    sM.getS(i).getSupplies().get(a).setName(inS2);
                                    sM.getS(i).getSupplies().get(a).setUnitPrice(unitPrice);
                                    break;
                                }
                            }
                        }
                    }
                System.out.println("Do you want to edit another Item? (y/n)");
            }
            else
                break;
        }while(inS.next().equals("y"));
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
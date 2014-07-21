
package Logic;
import java.util.Scanner;
import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class MainProg{

	private	Scanner inS;
	private	String sN;//supplier name
	private	String bN, N;//Items primary key
	private String u;// unit of bundle
	private String oN; // office name
	private String iV; // inVoice
	private Office tO;
        private Bundle c;
	private int m;// measurement of a bundle
	private Double pSP, sP;// sell price of a package, suppliers price for the item
	private	Double price;//price of Item
	private	WRInventory wR;//instance of inventory
	private	Item tempI;//temporary Item variable
	private	int bool;//to check if supplier exists in db
	private	SupplierManager sM;
	private OfficeManager oM;
	private TransactionDB sTM;
	private BundleManager bM;
	
	public MainProg(){
		this.inS = new Scanner(System.in);
		this.wR = new WRInventory();
		this.sM = new SupplierManager();
		this.oM = new OfficeManager();
		this.sTM = new TransactionDB();
		this.bM = new BundleManager();
	}
	
	public void addSupplier(){//method for adding supplier
		System.out.println("Segment: adding Supplier");
		do{
			System.out.print("Enter supplier name:");
			sN = inS.next().toUpperCase();
			while(sM.getS(sN) != null){
				System.out.println("Error: Supplier already Exists!\nEnter Again!");
				System.out.print("Enter supplier name:");
				sN = inS.next().toUpperCase();
			}
			System.out.print("Enter contact number:");
			sM.addS(new Supplier(sN, inS.next()));
			
			/*bool = sM.checkDB(sN);
			if(bool==-1)//to check if supplier exists in its Database
				sM.addS(new Supplier(sN));
			else{
				System.out.print("Supplier already exists, overwrite? (y/n):");
				overW();
			}*///
			do{
				System.out.print("Enter item's brand:");
				bN = inS.next().toUpperCase();
				System.out.print("Enter item's name:");
				N = inS.next().toUpperCase();
				System.out.print("Enter package name: ");
				u = inS.next().toUpperCase();
				if(bM.getB(bN, N, u)==null){
					System.out.print("Enter how many "+bN+" "+N+" does the package contain: ");
					m = inS.nextInt();
					System.out.print("Enter how much supplier "+sM.getS(sN).getName()+" sells 1 "+u+": ");
					sP = inS.nextDouble();
					System.out.print("Enter package sell price: ");
					pSP = inS.nextDouble();
					c = new Bundle(u, m, pSP, bN, N);
					c.addSuppPrice(sM.getS(sN), sP);
					bM.addB(c);
                                        c.addPricetoDB(sM.getS(sN), sP);
				} else{
                                        c = bM.getB(bN, N, u);
					System.out.print("Updating package...");
					System.out.print("Enter how much supplier "+sM.getS(sN).getName()+" sells 1 "+u+": ");
                                        sP = inS.nextDouble();
					c.addSuppPrice(sM.getS(sN), sP);
                                        c.addPricetoDB(sM.getS(sN), sP);
				}
				System.out.print("Do you want to add another package to this supplier? (Y/N):");
				/*if(!sM.checkSupplyExist(bN, N, sM.getLS())){
					System.out.print("Enter item's price:");
					price = inS.nextDouble();
					addItem2Supp(N, bN, price);//adds item to supplier and wRInventory
					addPackage();
				}
				else
					System.out.println("Error, supplier already supplies the said item");
				System.out.print("Do you want to add another item to this supplier? (Y/N):");*/
			} while(inS.next().equalsIgnoreCase("y"));
			System.out.println();
			System.out.print("Do you want to add another supplier? (Y/N):");
		} while(inS.next().equalsIgnoreCase("y"));
		sM.printSuppliers();
	}
	
	/*public void addItem(){//method for adding an item to supplier
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
					if(!sM.checkSupplyExist(bN, N, sM.getLS())){
						System.out.print("Enter item's price:");
						price = inS.nextDouble();
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
	}*/
	
	/*public void searchSupplier(){
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
	}*/
	
	public void addOffice(){
			System.out.println("\nSegment: add Wholesale Retail Customer");
		do{
			System.out.print("Enter customer name:");
			oN = inS.next().toUpperCase();
			while(oM.getO(oN) != null){
				System.out.println("Error: Customer already Exists!\nEnter Again!");
				System.out.print("Enter customer name:");
				oN = inS.next().toUpperCase();
			}
			System.out.print("Enter customer's contact number:");
			tO = new Office(oN, inS.next());
			
			/*if(getO(oN)==null){//to check if supplier exists in its Database
				System.out.print("Enter customer's contact number:");
				oM.addO(new Office(oN, inS.next()));
			}
			/*else{
				System.out.print("Office already exists, overwrite? (y/n):");
				overWO();
			}
			System.out.print("Do you want to add another contact number to the supplier? (Y/N): ");
			while(inS.next().equalsIgnoreCase("y")){
				System.out.print("Enter contact number:");
				tO.addContact(inS.next());
				System.out.print("Do you want to add another contact number to the supplier? (Y/N): ");
			}*/
			oM.addO(tO);
			System.out.println("Do you want to add another customer? (Y/N):");
		} while(inS.next().equalsIgnoreCase("y"));
		oM.printOffices();
	}
	
	public void buySupply(){
		System.out.println("\nSegment: buying supply");
		Item i;
		Bundle b;
		String s, s1, s2, b1;
		int ctr, count;
		Double d;
		Calendar c;
		Date d1;
		STransaction sT = null;
		do{
			System.out.println("Items available:");
			bM.printNames();
			System.out.print("Enter BrandName: ");
			s1 = inS.next().toUpperCase();
			System.out.print("Enter Name: ");
			s2 = inS.next().toUpperCase();
			System.out.println("Packages available for "+s1+" "+s2+":");
			bM.printBundles(s1, s2);
			System.out.println("Enter package: ");
			b1 = inS.next().toUpperCase();
			b = bM.getB(s1, s2, b1);
			System.out.println("Suppliers supplying "+s1+" "+s2+" "+b1+" and their pricing: ");
			b.printSuppliers();
			System.out.print("Enter Supplier: ");
			s = inS.next().toUpperCase();
                        d = b.elemHM(s);
                        System.out.println(d);
			
			
			System.out.print("Do you want to create a transaction with Supplier "+s+"? (Y/N): ");
			if(inS.next().equalsIgnoreCase("y")){
				System.out.print("Enter Invoice: ");
				iV = inS.next();
				System.out.print("Enter how many will be bought: ");
				count = inS.nextInt();
				c = new GregorianCalendar();
				c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				d1 = c.getTime(); 
				sT = new STransaction(iV, d1, s);
				sT.addSell(b, d, count);
				System.out.println("Do you want to add another item to this transaction? (Y/N):");
                                
				while(inS.next().equalsIgnoreCase("y")){
                                        System.out.println("Items under "+s+": ");
                                        bM.printNames(s);
                                        System.out.print("Enter Item's BrandName: ");
                                        s1 = inS.next().toUpperCase();
                                        System.out.print("Enter Item's Name: ");
                                        s2 = inS.next().toUpperCase();
					System.out.println("Bundles:");
					bM.printBundles(s1, s2, s);
                                        System.out.print("Enter bundle chosen: ");
                                        b1 = inS.next().toUpperCase();
                                        b = bM.getB(s1, s2, b1);
                                        d = b.elemHM(s);
                                        System.out.println(s+"'s pricing: "+d);
                                        System.out.print("Enter how many will be bought: ");
                                        count = inS.nextInt();
                                        sT.addSell(b, d, count);
					System.out.println("Do you want to add another item to this transaction? (Y/N):");
				}
				System.out.print("Enter terms of payment: ");
				sT.setTerm(inS.nextInt());
			}
			System.out.println("Are you sure you want to add this transaction?");
			if(inS.next().equalsIgnoreCase("y")){
				sT.updateStocks();
                                sM.getS(s).addSTransaction(sT);
                                sT.updateBundleList();
				sM.printAllTransactions();
			} 
			sM.printSuppliers();
			System.out.println("Do you want to add another transaction? (Y/N):");
		} while(inS.next().equalsIgnoreCase("y"));
		
	}
	
	public void sellSupply(){
		System.out.println("\nSegment: selling supply");
		Item i;
		Bundle b;
		String s, s1, s2, b1;
		int ctr, count;
		Double d;
		Calendar c;
		Date d1;
		Supplier suppT;
		OTransaction sT = null;
		Office o;
		do{
			System.out.println("Offices:");
			oM.printOffices();
			System.out.print("Enter office name: ");
			o = oM.getO(inS.next().toUpperCase());
			System.out.print("Do you want to create a transaction with "+o.getName()+"? (Y/N): ");
			if(inS.next().equalsIgnoreCase("y")){
				System.out.print("Enter Invoice: ");
				iV = inS.next();
				c = new GregorianCalendar();
				c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				d1 = c.getTime(); 
				sT = new OTransaction(iV, d1, o.getName());
				System.out.print("Enter terms of payment: ");
				sT.setTerm(inS.nextInt());
				do{
                                        bM.printNames();
                                        System.out.print("Enter BrandName: ");
                                        s1 = inS.next().toUpperCase();
                                        System.out.print("Enter Name: ");
                                        s2 = inS.next().toUpperCase();
                                        System.out.println("Packages available for "+s1+" "+s2+":");
                                        bM.printBundles(s1, s2);
                                        System.out.println("Enter package: ");
                                        b1 = inS.next().toUpperCase();
                                        b = bM.getB(s1, s2, b1);
					System.out.println("Stock and their corresponding sellprice:");
					b.printSuppliers2();
					d = b.getPackSellPrice();
					System.out.print("Enter how many will be bought: ");
					count = inS.nextInt();
					sT.addSell(b, d, count);
					System.out.println("Do you want to add another item to this transaction? (Y/N):");
				} while(inS.next().equalsIgnoreCase("y"));
				System.out.println("Are you sure you want to add this transaction?");
				if(inS.next().equalsIgnoreCase("y")){
					sT.updateStocks();
                                        oM.getO(o.getName()).addOTransaction(sT);
                                        sT.updateBundleList();
                                        oM.printAllTransactions();
				} 
				oM.printOffices();
				System.out.println("Do you want to add another transaction? (Y/N):");
			}
		} while(inS.next().equalsIgnoreCase("y"));
		
	}
	
	/*public void editItem(){
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
		tempI = new Item(N, bN, sM.getLS(), price);// adds the supplier to item
		if(wR.searchItem(tempI.getBrandName(), tempI.getName())==null)//if item doesn't exist yet
			wR.addItem(tempI);//adds the item to the list of inventory
		else//if item exists in the WRInventory
			wR.addSupplier(bN, N, sM.getLS()); //adds supplier to the item existing in wRInventory			
		sM.getLS().addSupply(wR.searchItem(tempI.getBrandName(), tempI.getName()));//adds the added item to supplier
	}
	
	public void addPackage(){
		System.out.print("Do you want to add a package to this item? (Y/N):");
		while(inS.next().equalsIgnoreCase("y")){
			System.out.print("Enter package name: ");
			u = inS.next().toUpperCase();
			Item c = wR.searchItem(bN, N);
			if(!c.isUExist(u)){
				System.out.print("Enter how many "+c.getBrandName()+" "+c.getName()+" does the package contain: ");
				m = inS.nextInt();
				System.out.print("Enter how much supplier "+sM.getLS().getName()+" sells 1 "+u+": ");
				sP = inS.nextDouble();
				System.out.print("Enter package sell price: ");
				pSP = inS.nextDouble();
				c.addSuppBundle(sM.getLS(), sP, u, m, pSP, bN, N);
			} else{
				System.out.print("Updating package...");
				System.out.print("Enter how much supplier "+sM.getLS().getName()+" sells 1 "+u+": ");
				sP = inS.nextDouble();
				c.getBundle(u).addSuppPrice(sM.getLS(), sP);
			}
			System.out.print("Do you want to add another package to this item? (Y/N):");
		}
	}*/
	
	/*public void buySupply(){
		System.out.println("\nSegment: buying supply");
		Item i;
		Bundle b;
		String s;
		int ctr, count;
		Double d;
		Calendar c;
		Date d1;
		Supplier suppT;
		STransaction sT = null;
		do{
			System.out.println("Known items supplied by suppliers:");
			wR.printItems();
			System.out.print("Enter item's number: ");
			i = wR.getItem(inS.nextInt());
			
			System.out.println("Known packages of "+i.getBrandName()+" "+i.getName()+" supplied by suppliers:");
			i.printBundles();
			System.out.print("Enter bundle's number: ");
			b = i.getBundle(inS.nextInt());
			
			System.out.println("Suppliers and their corresponding price for the package:");
			b.printSuppliers();
			System.out.print("Enter supplier's number: ");
			ctr = inS.nextInt();
			s = b.getSupplier(ctr);
			d = b.elemHM(ctr);
			
			System.out.print("Do you want to create a transaction with Supplier "+s+"? (Y/N): ");
			if(inS.next().equalsIgnoreCase("y")){
				System.out.print("Enter Invoice: ");
				iV = inS.next();
				System.out.print("Enter how many will be bought: ");
				count = inS.nextInt();
				c = new GregorianCalendar();
				c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				d1 = c.getTime(); 
				sTM.addSTrans(new STransaction(iV, d1, s));
				sT = sTM.getSTrans(sTM.sizeS()-1);
				sT.addSell(b, d, count);
				System.out.println("Do you want to add another item to this transaction? (Y/N):");
				suppT = sM.searchSuppliers(s);
				while(inS.next().equalsIgnoreCase("y")){
					System.out.println("Items:");
					suppT.printItems();
					System.out.print("Enter item's number: ");
					i = wR.getItem(inS.nextInt());
					System.out.println("Known packages of "+i.getBrandName()+" "+i.getName()+" supplied by suppliers:");
					i.printBundles(s);
					System.out.print("Enter bundle's number: ");
					b = i.getBundle(inS.nextInt());
					System.out.println("Supplier and its price for the package:");
					b.printSuppliers(s);
					System.out.print("Enter supplier's number: ");
					ctr = inS.nextInt();
					s = b.getSupplier(ctr);
					d = b.elemHM(ctr);
					System.out.print("Enter how many will be bought: ");
					count = inS.nextInt();
					sT.addSell(b, d, count);
					System.out.println("Do you want to add another item to this transaction? (Y/N):");
				}
				System.out.print("Enter terms of payment: ");
				sT.setTerm(inS.nextInt());
			}
			System.out.println("Are you sure you want to add this transaction?");
			if(inS.next().equalsIgnoreCase("y")){
				sT.updateStocks();
				sTM.printSTrans(sTM.sizeS()-1);
				
			} else{
				sTM.rLSTrans();
			}
			sM.printSuppliers();
			System.out.println("Do you want to add another transaction? (Y/N):");
		} while(inS.next().equalsIgnoreCase("y"));
		
	}*/
	
	/*public void overW(){
		if(inS.next().equalsIgnoreCase("y")){
			sM.swap(bool, new Supplier(sN));//overwrites the supplier
			wR.delSupplier(new Supplier(sN));
		}
	}
	
	public void overWO(){
		if(inS.next().equalsIgnoreCase("y")){
			System.out.print("Enter customer's contact number:");
			oM.swap(bool, new Office(oN, inS.next()));//overwrites the supplier
		}
	}*/
}
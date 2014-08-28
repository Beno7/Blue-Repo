
package Logic;
import java.util.Scanner;
import java.util.List;
import PDF.PDF;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.math.BigInteger;
import java.util.ArrayList;

public class MainProg{

	private	Scanner inS;
	private Manager mngr;
        private PDF pdf;
        private ChartPanel cP;
	
	public MainProg(){
		//this.inS = new Scanner(System.in);
		//this.wR = new WRInventory();
//		this.sTM = new STManager();
		//this.oTM = new OTManager();
                this.inS = new Scanner(System.in);
		this.mngr = new Manager();
                pdf = new PDF();
                cP = new ChartPanel();
	}
	
	public void addAccount(){
            String temp;
		System.out.println("Segment: Register");
		System.out.print("Do you want to add an account (y/n)? ");
		Account a = new Account();
		int year, month, day;
		Date d;
		while(inS.next().equalsIgnoreCase("y")){
			System.out.print("Enter first name: ");
			a.setFirstName(inS.next().toUpperCase());
			System.out.print("Enter Last name: ");
			a.setLastName(inS.next().toUpperCase());
			System.out.print("Enter position: ");
			a.setPosition(inS.next().toUpperCase());
                        System.out.println("BirthDate:");
			System.out.print("Enter year: ");
			year = inS.nextInt()-1900;
			System.out.print("Enter month: ");
			month = monthToInt(inS.next().toUpperCase());
			System.out.print("Enter Day: ");
			day = inS.nextInt();
			d = new Date(year, month, day);
			a.setBirthDay(d);
                        do{
                            System.out.print("Enter username: ");
                            temp = inS.next();
                            if(mngr.checkAccount(temp)){
                                System.out.println("Username Exists");
                                System.out.println("Enter again");
                            } else 
                                a.setUserName(temp);
                        } while(mngr.checkAccount(temp));
			System.out.print("Enter password: ");
			a.setPassWord(inS.next());
                        mngr.addAccount(a);
            System.out.print("Do you want to add another account (y/n)?");
		}
	}
	
	public void logIn(){
		System.out.println("Segment: Login");
		Account a = null;
		String userName, passWord;
		while(a==null){
			System.out.print("Enter username: ");
			userName = inS.next().toUpperCase();
			System.out.print("Enter password: ");
			passWord = inS.next().toUpperCase();
			a = mngr.getAccount(userName, passWord);
                        if(a==null){
                            System.out.println("Incorrect Username/Password combination");
                            System.out.println("Enter again");
                        }
		}
		System.out.println("Welcome "+a.getFirstName()+" "+a.getLastName()+"!");
	}
	
	public int monthToInt(String month){
		if(month.equals("JANUARY"))
			return 0;
		else if(month.equals("FEBRUARY"))
			return 1;
		else if(month.equals("MARCH"))
			return 2;
		else if(month.equals("APRIL"))
			return 3;
		else if(month.equals("MAY"))
			return 4;
		else if(month.equals("JUNE"))
			return 5;
		else if(month.equals("JULY"))
			return 6;
		else if(month.equals("AUGUST"))
			return 7;
		else if(month.equals("SEPTEMBER"))
			return 8;
		else if(month.equals("OCTOBER"))
			return 9;
		else if(month.equals("NOVEMBER"))
			return 10;
		else if(month.equals("DECEMBER"))
			return 11;
        return -1;
	}
	
	
	public void addSupplier(){
		String sN, cN, fN, addr;
		System.out.println("\nSegment: add WholeSale Supplier");
		do{
			System.out.print("Enter supplier name:");
			sN = inS.next().toUpperCase();
			while(mngr.getS(sN) != null){
				System.out.println("Error: Supplier already Exists!\nEnter Again!");
				System.out.print("Enter supplier name:");
				sN = inS.next().toUpperCase();
			}
			System.out.print("Enter supplier's contact number:");
                        cN = inS.next();
			System.out.print("Enter supplier's fax number:");
                        fN = inS.next();
			System.out.print("Enter supplier's address:");
                        addr = inS.next();
			mngr.addS(new Supplier(sN, cN, fN, addr));
			System.out.println("Do you want to add another supplier? (Y/N):");
		} while(inS.next().equalsIgnoreCase("y"));
		mngr.printSuppliers();
	}
	
	public void searchSupplier(){
		Supplier s;
		System.out.println("Segment: search supplier");
		System.out.println("Enter supplier's name: ");
		s = mngr.getS(inS.next().toUpperCase());
                if(s!=null)
                    mngr.printSupplier(s);
                else
                    System.out.print("No results found");
	}
        
        public void editSupplier(){
		String sN, cN, fN, addr;
		Supplier s, newS;
		System.out.println("Segment: edit supplier");
		System.out.println("Enter supplier's name: ");;
		s = mngr.getS(inS.next().toUpperCase());
                if(s!=null){
                        sN = s.getName();
			System.out.print("Enter customer's contact number:");
                        cN = inS.next();
			System.out.print("Enter customer's fax number:");
                        fN = inS.next();
			System.out.print("Enter customer's address:");
                        addr = inS.next();
                        newS = new Supplier(sN, cN, fN, addr);
                        newS.setID(s.getID());
			mngr.editS(newS);
                }
                else
                    System.out.print("No results found");
        }
	public void addOffice(){
		String oN, cN, fN, addr;
		System.out.println("\nSegment: add WholeSale Customer");
		do{
			System.out.print("Enter customer name:");
			oN = inS.next().toUpperCase();
			while(mngr.getO(oN) != null){
				System.out.println("Error: Customer already Exists!\nEnter Again!");
				System.out.print("Enter customer name:");
				oN = inS.next().toUpperCase();
			}
			System.out.print("Enter customer's contact number:");
                        cN = inS.next();
			System.out.print("Enter customer's fax number:");
                        fN = inS.next();
			System.out.print("Enter customer's address:");
                        addr = inS.next();
			mngr.addO(new Office(oN, cN, fN, addr));
			System.out.println("Do you want to add another customer? (Y/N):");
		} while(inS.next().equalsIgnoreCase("y"));
		mngr.printOffices();
	}
	
	public void searchOffice(){
		Office o;
		System.out.println("Segment: search customer");
		System.out.println("Enter customer's name: ");
		o = mngr.getO(inS.next());
                if(o!=null)
                    mngr.printOffice(o);
                else
                    System.out.print("No results found");
	}
        
        public void editOffice(){
		String oN, cN, fN, addr;
		Office o, newO;
		System.out.println("Segment: edit customer");
		System.out.println("Enter customer's name: ");
		o = mngr.getO(inS.next());
                if(o!=null){
                        oN = o.getName();
			System.out.print("Enter customer's contact number:");
                        cN = inS.next();
			System.out.print("Enter customer's fax number:");
                        fN = inS.next();
			System.out.print("Enter customer's address:");
                        addr = inS.next();
                        newO = new Office(oN, cN, fN, addr);
                        newO.setID(o.getID());
			mngr.editO(newO);
                }
                else
                    System.out.print("No results found");
        }
	
	public void addBundle(){
		String bN, n, u, l;
		int inID, norm, m;
                System.out.println("Segment: adding Item Bundle");
                
		System.out.println("Item:");
		System.out.print("Enter BrandName: ");
		//bN = inS.next().toUpperCase();
		bN = "Chico";
		System.out.print("Enter Name: ");
		//n = inS.next().toUpperCase();
                double uP;
		n = "Chocolate";
		do{
                    do{
			System.out.print("Enter unit: ");
			//u = inS.next().toUpperCase();
                        u = "BOX";
                        if(mngr.getB(bN, n, u)!=null){
                            System.out.println("Error, bundle already exists");
                            System.out.println("Enter Again");
                        }
                    } while(mngr.getB(bN, n, u)!=null);
                        u = "BOX";
			System.out.printf("Enter how many %s %s is in the %s: ", bN, n, u);
			//m = inS.nextInt();
                        m = 1000;
			System.out.println("Enter the item's ideal stock: ");
			//norm = inS.nextInt();
                        norm = 50;
			System.out.println("Enter the item's unit price: ");
			//uP = inS.nextDouble();
                        uP = 50.0;
			System.out.print("Enter where bundle is to be placed: ");
			//l = inS.next().toUpperCase();
                        l = "WAREHOUSE1";
			mngr.addB(new Item(bN, n, u, norm, l, m));
                        if(mngr.getI(n, bN)==null){
                            System.out.print("Enter where item is to be sold for walkin transactions: ");
                            //l = inS.next().toUpperCase();
                            l = "BOOKSTORE1";
                            mngr.addItem(new Item(bN, n, u, norm, l, m, uP));
                        }
			System.out.print("Do you want to add another Bundle? (y/n): ");
		}while(inS.next().equalsIgnoreCase("y"));
                mngr.printBundle();
	}
        
    public void searchBundleName(){
        Item b;
		String bN, n, u;
        System.out.println("Segment: Search Bundle using names");
		System.out.print("Enter BrandName: ");
		bN = inS.next().toUpperCase();
		System.out.print("Enter Name: ");
		n = inS.next().toUpperCase();
		System.out.print("Enter unit: ");
		u = inS.next().toUpperCase();
        b = mngr.getB(bN, n, u);
                if(b!=null)
                    mngr.printBundle(b);
                else
                    System.out.print("No results found");
    }
        
    public void searchBundleID(){
        Item b;
		BigInteger bN;
        System.out.println("Segment: Search Bundle using ID");
		System.out.print("Enter BundleID: ");
		bN = inS.nextBigInteger();
        b = mngr.getB(bN);
        mngr.printBundle(b);
        }
	
	public void addPrice(){
		String bN, n, u, temp;
		Double p, p1;
		BigInteger a, a1;
                a = null;
                a1 = null;
		System.out.println("Segment: pricing");
                do{
                    mngr.printSuppliers();
                    System.out.print("Enter supplier name: ");
                    temp = inS.next().toUpperCase();
                    if(mngr.getS(temp) == null)
                        System.out.println("No such supplier exists");
                    else
                        a = mngr.getS(temp).getID();
                } while(mngr.getS(temp) == null);
                mngr.printBundle();
                do{
		System.out.print("Enter BrandName: ");
		bN = inS.next().toUpperCase();
		System.out.print("Enter Name: ");
		n = inS.next().toUpperCase();
		System.out.print("Enter unit: ");
		u = inS.next().toUpperCase();
                if(mngr.getB(bN, n, u) == null)
                        System.out.println("No such bundle exists");
                else
                        a1 = mngr.getB(bN, n, u).getItemID();
                }while(mngr.getB(bN, n, u)==null);
                if(mngr.getP(a1,a)==null){
                    System.out.print("Enter Supplier's pricing: ");
                    p = inS.nextDouble();
                    System.out.print("Enter SJT's pricing: ");
                    p1 = inS.nextDouble();
                    mngr.addP(new PriceBean(a1, a, p, p1));
                } else
                    System.out.println("Error, pricing already exists");
	}
        
    public void searchPrice(){
		BigInteger a, b;
		System.out.println("Segment: search prices");
		System.out.println("Enter bundle ID: ");
		a = inS.nextBigInteger();
		System.out.println("Enter supplier ID: ");
                b = inS.nextBigInteger();
                if(mngr.getP(a,b)!=null)
                    mngr.printPriceBean(mngr.getP(a,b));
                else
                    System.out.println("No results found");
    }
	
	public void recordSupplierTrans(){
		int t, q;
		BigInteger bID, sID;
		Item b;
                String temp;
                String bN, n, u, iV;
		Supplier s;
		SupplierTransaction sT;
                sID = null;
		
		System.out.println("\nSegment: recording supplier transaction");
		System.out.println("Items available:");
		mngr.printNames();
                do{
                    System.out.print("Enter BrandName: ");
                    bN = inS.next();
                    System.out.print("Enter Name: ");
                    n = inS.next();
                    mngr.printBundle(bN, n);
                    System.out.print("Enter unit: ");
                    u = inS.next();
                    if(mngr.getB(bN, n, u) == null)
                        System.out.println("No such bundle exists");
                }while(mngr.getB(bN, n, u)==null);
		bID = mngr.getB(bN, n, u).getItemID();
                mngr.printPriceBeans(bID);
                do{
                    System.out.print("Enter Supplier: ");
                    s = mngr.getS(inS.next().toUpperCase());
                    if(s!=null){
                        sID = s.getID();
                        if(mngr.getP(bID, sID)==null)
                            System.out.println("Supplier does not supply the said bundle\n enter again");
                    }
                    else{
                        System.out.println("No results found\n enter again");
                    }                    
                } while(mngr.getP(bID, sID)==null);
		System.out.print("Do you want to record a transaction with supplier "+s.getName()+" (Y/N)?");
		if(inS.next().equalsIgnoreCase("y")){
                        do{
                            System.out.print("Enter Invoice Number: ");
                            iV = inS.next();
                            if((mngr.getOT(iV)!=null)||(mngr.getST(iV)!=null))
                                System.out.println("Error, Transaction with same invoice already exists\nEnter again");
                        } while((mngr.getOT(iV)!=null)||(mngr.getST(iV)!=null));
			System.out.print("Enter terms: ");//should be integer only
			t = inS.nextInt();
			SBreakDownManager sBD = new SBreakDownManager(iV);
			System.out.print("Enter quantity to be bought: ");//should  be integer only
			q = inS.nextInt();
			sT = new SupplierTransaction(iV, q*mngr.getSupplierPrice(bID, sID), new Date(), s.getName(), t, sID);
			sT.addBreakDownTemp(new BreakDown(iV, q, bID, mngr.getSupplierPrice(bID, sID)));
			sT.printBreakDownTemp();
			System.out.print("Do you want to add another item to this transaction (y/n)?");
			while(inS.next().equalsIgnoreCase("y")){
				System.out.println("Items supplied by Supplier "+s.getName()+" :");
                                mngr.printPriceBeanSupplier(sID);
                                System.out.print("Enter BrandName: ");
                                bN = inS.next();
                                System.out.print("Enter Name: ");
                                n = inS.next();
                                mngr.printBundle(bN, n);
                                System.out.print("Enter unit: ");
                                u = inS.next();
                                if(mngr.getB(bN, n, u) == null)
                                    System.out.println("No such bundle exists");
                                if(sT.checkBreakDown(bN, n, u))
                                    System.out.println("You have already add this item to the cart");
                                if((mngr.getB(bN, n, u) != null)&&(!sT.checkBreakDown(bN, n, u))){
                                    bID = mngr.getB(bN, n, u).getItemID();
                                    System.out.print("Enter quantity to be bought: ");//should  be integer only
                                    q = inS.nextInt();
                                    sT.addBreakDownTemp(new BreakDown(iV, q, bID, mngr.getSupplierPrice(bID, sID)));
                                    sT.setTotal(sT.getTotal()+(q*mngr.getSupplierPrice(bID, sID)));
                                }
                                sT.printBreakDownTemp();
                                System.out.print("Do you want to add another item to this transaction (y/n)?");
			}
			System.out.print("Are you sure you want to record this transaction (y/n)?");
			if(inS.next().equalsIgnoreCase("y")){
                                mngr.addSTransaction(sT);
				sT.commitBreakDown();
				mngr.printAllSupplierTrans();
			}
		}
	}
        
        public void recordOfficeTrans(){
		System.out.println("\nSegment: selling supply");
		Item b;
		String s, s1, s2, b1, iV;
		int ctr, count, terms;
		Double d;
		Calendar c;
		Date d1;
		Supplier suppT;
		OfficeTransaction sT = null;
		Office otemp;
                String o, stemp;
                BigInteger bID, sID;
                bID = null;
                sID = null;
		do{
			System.out.println("Offices:");
			mngr.printOffices();
                        do{
                            System.out.print("Enter office name: ");
                            o = inS.next().toUpperCase();
                            if(mngr.getO(o)==null)
                                System.out.println("No results found");
                        }while(mngr.getO(o)==null);
                        otemp = mngr.getO(o);
			System.out.print("Do you want to create a transaction with "+otemp.getName()+"? (Y/N): ");
			if(inS.next().equalsIgnoreCase("y")){
                            do{
				System.out.print("Enter Invoice: ");
				iV = inS.next();
                                if((mngr.getOT(iV)!=null)||(mngr.getST(iV)!=null))
                                    System.out.println("error, transaction with that invoice already exists");
                            } while((mngr.getOT(iV)!=null)||(mngr.getST(iV)!=null));
                            c = new GregorianCalendar();
                            c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
                            c.set(Calendar.MINUTE, 0);
                            c.set(Calendar.SECOND, 0);
                            d1 = c.getTime(); 
                            System.out.print("Enter terms of payment: ");
                            terms = inS.nextInt();
                            sT = new OfficeTransaction(iV, 0.0, d1, otemp.getName(), terms, otemp.getID());
				do{
                                        mngr.printNames();
                                        do{
                                            System.out.print("Enter BrandName: ");
                                            s1 = inS.next().toUpperCase();
                                            System.out.print("Enter Name: ");
                                            s2 = inS.next().toUpperCase();
                                            if(!mngr.checkBundle(s1, s2))
                                                System.out.print("No results found");
                                        } while(!mngr.checkBundle(s1, s2));
                                        System.out.println("Packages available for "+s1+" "+s2+":");
                                        mngr.printBundle(s1, s2);
                                        do{
                                            System.out.println("Enter package: ");
                                            b1 = inS.next().toUpperCase();
                                            if(mngr.getB(s1, s2, b1)==null)
                                                System.out.print("No results found");
                                        }while(mngr.getB(s1, s2, b1)==null);
                                        
                                        if(sT.checkBreakDown(s1, s2, b1))
                                            System.out.println("You have already add this item to the cart");
                                        
                                        else{
                                            b = mngr.getB(s1, s2, b1);
                                            System.out.println("Stock and their corresponding sellprice:");
                                            mngr.printPriceBeanUser(b.getItemID());
                                            bID = b.getItemID();
                                            do{
                                                do{
                                                    System.out.println("Enter supplier to buy from: ");
                                                    stemp = inS.next();
                                                    if(mngr.getS(stemp)==null)
                                                    System.out.print("No results found");
                                                }while(mngr.getS(stemp)==null);
                                                sID = mngr.getS(stemp).getID();
                                                if(mngr.getUserPrice(bID, sID)==0.0)
                                                    System.out.print("No results found");
                                            } while(mngr.getUserPrice(bID, sID)==0.0);
                                            d = mngr.getUserPrice(bID, sID);
                                            System.out.print("Enter how many will be bought: ");//int only
                                            count = inS.nextInt();
                                            sT.addBreakDownTemp(new BreakDown(iV, count, bID, mngr.getUserPrice(bID, sID)));
                                            sT.setTotal(sT.getTotal()+(count*mngr.getUserPrice(bID, sID)));
                                        }
                                        
                                        sT.printBreakDownTemp();
					System.out.println("Do you want to add another item to this transaction? (Y/N):");
				} while(inS.next().equalsIgnoreCase("y"));
				System.out.println("Are you sure you want to add this transaction?");
				if(inS.next().equalsIgnoreCase("y")){
                                    mngr.addOTransaction(sT);
                                    sT.commitBreakDown();
                                    mngr.printAllOfficeTrans();
                                }
			}
			System.out.println("Add another transaction?");
		} while(inS.next().equalsIgnoreCase("y"));
                 mngr.printAllOfficeTrans();
        }
	
	public void setDateDeliveredST(){
		String iV;
		System.out.println("\nSegment: setting date of delivery");
		mngr.printAllSupplierTrans();
		do{
                        do{
                            System.out.print("Enter Invoice of Transaction delivered today: ");
                            iV = inS.next();
                            if(mngr.getST(iV)==null)
                                System.out.println("Error, Transaction does not exists\nEnter again");
                        } while(mngr.getST(iV)==null);
                        if((mngr.getST(iV).getDateOfDelivery()==null)&&(mngr.getST(iV).getDateOfDelivery()==null)){
                            System.out.print("Are you sure you want to mark this transaction as delivered? (Y/N): ");
                            if(inS.next().equalsIgnoreCase("y"))
                                    mngr.setDateDelivered(iV);
                            mngr.printAllSupplierTrans();
                        }
                        else{
                            System.out.println("Error, transaction is already delivered");
                        }
			System.out.print("Do you want to mark another transaction? (Y/N): ");
		}while(inS.next().equalsIgnoreCase("y"));
	}
	public void setDatePayedST(){
		String iV;
		System.out.println("\nSegment: setting date of payment");
		mngr.printAllSupplierTrans();
		do{
                        do{
                            System.out.print("Enter Invoice of Transaction payed today: ");
                            iV = inS.next();
                            if(mngr.getST(iV)==null)
                                System.out.println("Error, Transaction does not exists\nEnter again");
                        } while(mngr.getST(iV)==null);
                        if((mngr.getST(iV).getDateOfDelivery()!=null)&&(mngr.getST(iV).getDateOfDelivery()==null)){
                            System.out.print("Are you sure you want to mark this transaction as payed? (Y/N): ");
                            if(inS.next().equalsIgnoreCase("y"))
                                    mngr.setDatePayed(iV);
                            mngr.printAllSupplierTrans();
                        }
                        else if (mngr.getST(iV).getDateOfDelivery()==null){
                            System.out.println("Error, transaction is not yet delivered");
                        }
                        else
                            System.out.println("Error, transaction is already payed");
			System.out.print("Do you want to mark another transaction? (Y/N): ");
		}while(inS.next().equalsIgnoreCase("y"));
	}
	
	public void setDateDeliveredOT(){
		String iV;
		System.out.println("\nSegment: setting date of delivery");
		mngr.printAllOfficeTrans();
		do{
                        do{
                            System.out.print("Enter Invoice of Transaction delivered today: ");
                            iV = inS.next();
                            if(mngr.getOT(iV)==null)
                                System.out.println("Error, Transaction does not exists\nEnter again");
                        } while(mngr.getOT(iV)==null);
                        if((mngr.getOT(iV).getDateOfDelivery()==null)&&(mngr.getOT(iV).getDateOfPayment()==null)){
                            System.out.print("Are you sure you want to mark this transaction as delivered? (Y/N): ");
                            if(inS.next().equalsIgnoreCase("y"))
                                    mngr.setDateDeliveredOT(iV);
                            mngr.printAllOfficeTrans();
                        }
                        else {
                            System.out.println("Error, transaction is already delivered");
                        }
			System.out.print("Do you want to mark another transaction? (Y/N): ");
		}while(inS.next().equalsIgnoreCase("y"));
	}
	public void setDatePayedOT(){
		String iV;
		System.out.println("\nSegment: setting date of payment");
		mngr.printAllSupplierTrans();
		do{
                        do{
                            System.out.print("Enter Invoice of Transaction payed today: ");
                            iV = inS.next();
                            if(mngr.getOT(iV)==null)
                                System.out.println("Error, Transaction does not exists\nEnter again");
                        } while(mngr.getOT(iV)==null);
                        if((mngr.getOT(iV).getDateOfDelivery()!=null)&&mngr.getOT(iV).getDateOfDelivery()==null){
                            System.out.print("Are you sure you want to mark this transaction as payed? (Y/N): ");
                            if(inS.next().equalsIgnoreCase("y"))
                                    mngr.setDatePayedOT(iV);
                            mngr.printAllOfficeTrans();
                        }
                        else if(mngr.getOT(iV).getDateOfDelivery()==null){
                            System.out.println("Error, transaction is not delivered yet");
                        }
                        else
                            System.out.println("Error, transaction is already payed");
			System.out.print("Do you want to mark another transaction? (Y/N): ");
		}while(inS.next().equalsIgnoreCase("y"));
	}
        
        public void editPrice(){
		BigInteger bID, sID;
                String temp;
                String bN, n, u;
		Supplier s;
                sID = null;
                PriceBean a;
                double p, p1;
                PriceBean tempI;
		
		System.out.println("\nSegment: recording supplier transaction");
		System.out.println("Items available:");
		mngr.printNames();
                do{
                    System.out.print("Enter BrandName: ");
                    bN = inS.next();
                    System.out.print("Enter Name: ");
                    n = inS.next();
                    mngr.printBundle(bN, n);
                    System.out.print("Enter unit: ");
                    u = inS.next();
                    if(mngr.getB(bN, n, u) == null)
                        System.out.println("No such bundle exists");
                }while(mngr.getB(bN, n, u)==null);
		bID = mngr.getB(bN, n, u).getItemID();
                mngr.printPriceBeans(bID);
                do{
                    System.out.print("Enter Supplier:");
                    s = mngr.getS(inS.next().toUpperCase());
                    if(s!=null){
                        sID = s.getID();
                        System.out.println(sID+" "+bID);
                        if(mngr.getP(bID, sID)!=null){
                            tempI = mngr.getP(bID, sID);
                            System.out.println("Supplier's pricing: "+tempI.getSupplierPrice());
                            System.out.println("SJT's pricing: "+tempI.getUserPrice());
                            System.out.print("Enter new Supplier's pricing: ");
                            p = inS.nextDouble();
                            System.out.print("Enter new SJT's pricing: ");
                            p1 = inS.nextDouble();
                            mngr.editP(new PriceBean(bID, sID, p, p1));
                        }
                        else
                            System.out.println("Pricing does not exists");
                    }
                    else
                        System.out.print("Supplier does not exists");
                    
                } while((s == null) || (mngr.getP(bID, sID)==null));
	}
        
        public void recordWalkInTransItem(){
            String bN, n, iV;
            OBreakDownManager oBD = new OBreakDownManager();
            Transaction wI;
            Item a, bundle;
            int q, needed = 0, mult = 0;
            boolean me;
            do{
                do{
                    System.out.print("Enter Invoice Number: ");
                    iV = inS.next();
                    if((mngr.getOT(iV)!=null)||(mngr.getST(iV)!=null)||(mngr.getWalkInTransaction(iV)!=null))
                        System.out.println("Error, Transaction with same invoice already exists\nEnter again");
                } while((mngr.getOT(iV)!=null)||(mngr.getST(iV)!=null)||(mngr.getWalkInTransaction(iV)!=null));
                wI = new Transaction(iV, new Date());
                    do{
                        me = true;
                        mult = 0;
                        System.out.println("Enter brandName: ");
                        bN = inS.next();
                        System.out.println("Enter Name: ");
                        n = inS.next();
                        if((mngr.getI(n, bN)!=null)&&!oBD.checkBreakDownItem(bN, n)){
                            a = mngr.getI(n, bN);
                            bundle = mngr.getLeast(n, bN);
                            System.out.print("Enter quantity: ");
                            q = inS.nextInt();
                            needed = a.getStock();
                            if(needed<=q){
                                while(needed<=q){
                                    System.out.print("hey");
                                    if(mult<=bundle.getStock()){
                                        needed+=bundle.getQtyPerBundle();
                                        mult++;
                                    }
                                    else{///di ko alam kung gagana ito
                                        me = false;
                                        break;
                                    }
                                }
                                mngr.updateStock(n, bN, a.getStock()+(mult*bundle.getQtyPerBundle()));
                                mngr.subtractStock(bundle.getItemID(), mult);
                            }
                            if(me){
                                mngr.updateStock(n, bN, a.getStock()-q);
                                oBD.addBDTemp(new BreakDown(iV, q, a.getItemID(), mngr.getI(n, bN).getUnitPrice()));
                                wI.setTotal(wI.getTotal()+(q*mngr.getI(n, bN).getUnitPrice()));
                                oBD.printBreakDownTempItem();
                            } else{
                                System.out.println("Error, insufficient supply");
                            }
                        }
                        else if(oBD.checkBreakDownItem(bN, n)){
                            System.out.print("You already added that item to this transaction");
                        }
                        System.out.print("Add another item? (y/n): ");
                    }while(inS.next().equalsIgnoreCase("y"));
                    System.out.print("Are you sure you want to record this transaction? (y/n):");
                    if(inS.next().equalsIgnoreCase("y")){
                        mngr.addWalkInTransaction(wI);
                        oBD.commitBreakDown();
                    }
                System.out.print("Enter again? (y/n):");
            } while(inS.next().equalsIgnoreCase("y"));
        }
        
        public void editItem(){
            
        }
        
        public void printAllOfficebyCN(){
            mngr.printOfficesbyCN();
        }
        
        public void printAllOfficebyFN(){
            mngr.printOfficesbyFN();
        }
        
        public void printAllSupplierTransbyTS(){
            mngr.printAllSupplierTransByTermStatus();
        }
        
        public void printAllOfficeTransbyTS(){
            mngr.printAllOfficeTransByTermStatus();
        }
        
        public void printAllOfficeTransByNearEndDays(){
            mngr.printAllOfficeTransByNearEndDays();
        }
        
        public void printAllBundlebyBrand(){
            mngr.printAllBundlebyBrand();
        }
        
        public void printAllBundlewLowSupply(){
            mngr.printAllBundlewLowSupply();
        }
        
        public void printItemSortByBrandName(){
            mngr.printSortByBrandName();
        }
        
        public void printSortByPrice(){
            mngr.printSortByPrice();
        }
	
        public void printAllOfficeTransbyTerms(){
            mngr.printAllOfficeTransbyTerms();
        }
        
        public void printAllOfficeTransbyIV(){
            mngr.printAllOfficeTransbyIV();
        }
        
        public void getAllTransactionOfficeSortByTotal(){
            mngr.getAllTransactionOfficeSortByTotal();
        }
        
        public void getAllTransactionOfficeSortByName(){
            mngr.getAllTransactionOfficeSortByName();
        }
        
        public void printAllSupplierTransbyTerms(){
            mngr.printAllSupplierTransbyTerms();
        }
        
        public void printAllSupplierTransbyIV(){
            mngr.printAllSupplierTransbyIV();
        }
        
        public void getAllTransactionSupplierSortByTotal(){
            mngr.getAllTransactionSupplierSortByTotal();
        }
        
        public void getAllTransactionSupplierSortByName(){
            mngr.getAllTransactionSupplierSortByName();
        }
        
        public void printPriceBeans(){
            mngr.printPriceBeans();
        }
        
        public void printAllSupplierTransByNearEndDays(){
            mngr.printAllSupplierTransByNearEndDays();
        }
        
        public void fastMoving(){
            mngr.fastMoving();
        }
        
        public void chartFastMoving(){
            System.out.print(mngr.fastMovingB().size());
            System.out.print(mngr.fastMovingI().size());
            cP.start(mngr.fastMovingB(),mngr.fastMovingI());
        }
        
        public void addStockTransferReceipt(){
            String iV;
            ArrayList<Item> b;
            ArrayList<Integer> quantity;
            ArrayList<Double> prices;
            Office o;
            OfficeTransaction ot;
            System.out.print("Enter Invoice: ");
            iV = inS.next().toUpperCase();
            ot = mngr.getOT(iV);
            o = mngr.getO(ot.getID());
            b = ot.getBDM().getItems();
            quantity = ot.getBDM().getQTYs();
            prices = ot.getBDM().getPrices();
            try{
                pdf.addStockTransferReceipt(b, o, ot, prices, quantity);
            } catch(Exception e){
                
            }
        }
        public void addStatementofAccounts(){
            ArrayList<OfficeTransaction> ot;
            Office o;
            System.out.print("Enter Office Name: ");
            o = mngr.getO(inS.next());
            ot = mngr.getALLOT(o.getID());
            try{
                pdf.addStatementsOfAccount(o, ot);
            } catch(Exception e){
                
            }
        }
        
        public void addPurchaseOrder(){
            String iV;
            ArrayList<Item> b;
            ArrayList<Integer> quantity;
            ArrayList<Double> prices;
            Office o;
            OfficeTransaction ot;
            System.out.print("Enter Invoice: ");
            iV = inS.next().toUpperCase();
            ot = mngr.getOT(iV);
            o = mngr.getO(ot.getID());
            b = ot.getBDM().getItems();
            quantity = ot.getBDM().getQTYs();
            prices = ot.getBDM().getPrices();
            try{
                pdf.addPurchaseOrder(o, b, quantity, prices);
            } catch(Exception e){
                
            }
        }
        
        public void addDeliveryReceipt(){
            String iV;
            ArrayList<Item> b;
            ArrayList<Integer> quantity;
            ArrayList<Double> prices;
            Office o;
            OfficeTransaction ot;
            System.out.print("Enter Invoice: ");
            iV = inS.next().toUpperCase();
            ot = mngr.getOT(iV);
            o = mngr.getO(ot.getID());
            b = ot.getBDM().getItems();
            quantity = ot.getBDM().getQTYs();
            prices = ot.getBDM().getPrices();
            try{
                pdf.addDeliveryReceipt(b, o, ot.getTerms(), quantity);
            } catch(Exception e){
                
            }
        }
        public void addOfficeReceipt(){
            String iV;
            ArrayList<Item> b;
            ArrayList<Integer> quantity;
            ArrayList<Double> prices;
            Office o;
            OfficeTransaction ot;
            System.out.print("Enter Invoice: ");
            iV = inS.next().toUpperCase();
            ot = mngr.getOT(iV);
            o = mngr.getO(ot.getID());
            b = ot.getBDM().getItems();
            quantity = ot.getBDM().getQTYs();
            prices = ot.getBDM().getPrices();
            try{
                pdf.addOfficeReceipt(ot, b, quantity, prices);
            } catch(Exception e){
                
            }
        }
        public void addWalkInReceipt(){
            String iV;
            ArrayList<Item> b;
            ArrayList<Integer> quantity;
            ArrayList<Double> prices;
            Transaction ot;
            System.out.print("Enter Invoice: ");
            iV = inS.next().toUpperCase();
            ot = mngr.getWalkInTransaction(iV);
            OBreakDownManager oBD = new OBreakDownManager(iV);
            b = oBD.getItems();
            quantity = oBD.getQTYs();
            prices = oBD.getPrices();
            try{
                pdf.addWalkInReceipt(ot, b, quantity, prices);
            } catch(Exception e){
                
            }
        }
}
package Logic;

import Implementation.AccountImpl;
import Implementation.BundleImpl;
import Implementation.BundleListImpl;
import Implementation.ItemImpl;
import Implementation.OfficeImpl;
import Implementation.OfficeTransImpl;
import Implementation.PriceImpl;
import Implementation.SupplierImpl;
import Implementation.SupplierTransImpl;
import Implementation.WalkInImpl;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager{
	//for accounts
	private AccountImpl aI;
	//for bundles
        private List<Item> bundles;
        private BundleImpl bI;
	//for suppliers
        private List<Supplier> suppliers;
	private SupplierImpl sI;
	//for offices
        private List<Office> offices;
        private OfficeImpl oI;
	//for priceBeans
        private List<PriceBean> prices;
        private PriceImpl pI;
	//for SupplierTransactions
        private SupplierTransImpl sTI;
        private List<SupplierTransaction> history;
        //for OfficeTransactions
        private OfficeTransImpl oTI;
        private List<OfficeTransaction> historyOT;
        //for items
	private List<Item> items;
	private ItemImpl iI;
        //for WalkIn
        private WalkInImpl wII;
        private List<Transaction> walkins;
	
	public Manager(){
		//for accounts
		this.aI = new AccountImpl();
		//for bundles
                bI = new BundleImpl();
		//for suppliers
		sI = new SupplierImpl();
		//for offices
                oI = new OfficeImpl();
		//for prices
                pI = new PriceImpl();
		//for supplier transactions
                sTI = new SupplierTransImpl();
		history = new ArrayList<SupplierTransaction>();
                //for Office Transactions
                oTI = new OfficeTransImpl();
		historyOT = new ArrayList<OfficeTransaction>();
                //for items
                iI = new ItemImpl();
		this.iI = new ItemImpl();
		items = new ArrayList<Item>();
                wII = new WalkInImpl();
	}
	
	//Managing Accounts
	public void addAccount(Account a){
		aI.addAccount(a);
	}
	
	public Account getAccount(String uN, String pN){
		return aI.getAccount(uN, pN);
	}
	
	public boolean checkAccount(String uN){
		return aI.checkAccount(uN);
	}
	//Managing Bundles
	//for DB
    public Item getB(String bN, String n, String u) {
        return bI.getBundle(bN, n, u);
    }
	
    public Item getB(BigInteger b) {
        return bI.getBundle(b);
    }
    
	public void addB(Item b){
		bI.addBundle(b);
	}
	
	public void addStock(BigInteger bID, int quantity){
		Item b = getB(bID);
		bI.updateStock(bID, b.getStock()+quantity);
	}
	
	public void subtractStock(BigInteger bID, int quantity){
		Item b = getB(bID);
		bI.updateStock(bID, b.getStock()-quantity);
	}
	
	//for ArrayList
	
	public Item getB(int ctr){
		return bundles.get(ctr);
	}
	
	public int sizeB(){
		return bundles.size();
	}
    
	public void setAllBundle(ArrayList<Item> s){
		this.bundles = s;
	}
	
	public void printBundle(){
		setAllBundle(bI.getAllBundle());
		System.out.println("--------------");
        for(int i = 0; i < sizeB(); i++){
			printBundle(getB(i));
			System.out.println("--------------");
		}
	}
        
	public void printBundle(Item b){
		System.out.println();
		System.out.println("BrandName: "+b.getBrandName());
		System.out.println("Name: "+b.getName());
		System.out.println("Unit: "+b.getUnit());
		System.out.println("BundleID: "+b.getItemID());
		System.out.println("number of items: "+b.getQtyPerBundle());
		System.out.println("Location: "+b.getLocation());
		System.out.println("Stock: "+b.getStock());
		System.out.println("Normal Stock: "+b.getIdealStock());
		System.out.println();
	}
	
	public List<Item> getAllBundle(){
		setAllBundle(bI.getAllBundle());
		return bundles;
	}
	
	public void printNames(){
		setAllBundle(bI.groupBundle());
		System.out.println("--------------");
        for(int i = 0; i < sizeB(); i++){
			printName(getB(i));
			System.out.println("--------------");
		}
	}
	
	public void printName(Item b){
		System.out.println();
		System.out.println("BrandName: "+b.getBrandName());
		System.out.println("Name: "+b.getName());
		System.out.println();
	}
	
	public void printUnit(Item b){
		System.out.println();
		System.out.print("Unit: "+b.getUnit()+"\t");
		System.out.println("number of items: "+b.getQtyPerBundle());
		System.out.println();
	}
        public void printAllBundlebyBrand(){
            	setAllBundle(bI.getSortByBrand());
		System.out.println("--------------");
                for(int i = 0; i < sizeB(); i++){
			printBundle(getB(i));
			System.out.println("--------------");
		}
        }
        public void printAllBundlewLowSupply(){
            	setAllBundle(bI.getLowSupply());
		System.out.println("--------------");
                for(int i = 0; i < sizeB(); i++){
			printBundle(getB(i));
			System.out.println("--------------");
		}
        }
	
	public void printBundle(String bN, String n){
		setAllBundle(bI.getAllBundle(n, bN));
		System.out.println("--------------");
                for(int i = 0; i < sizeB(); i++){
			printUnit(getB(i));
			System.out.println("--------------");
		}
	}
        
        public boolean checkBundle(String bN, String n){
            if(bI.getAllBundle(n, bN).size()>0)
                return true;
            else
                return false;
        }
	
	//Managing Suppliers
	//for DB
	public Supplier getS(String supplier){
		return sI.getSupplier(supplier);
	}
	public void editS(Supplier supplier){
		sI.editSupplier(supplier);
	}
	
	public Supplier getS(BigInteger s){
		return sI.getSupplier(s);
	}
	
	public void addS(Supplier supplier){
		sI.addSupplier(supplier);
	}
	
	//for ArrayList
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
			printSupplier(getS(i));
			System.out.println("--------------");
		}
	}
	
	public void printSupplier(Supplier s){
		System.out.println();
        System.out.print("Supplier name: ");
        System.out.println(s.getName());
        System.out.print("Contact number: ");
        System.out.println(s.getContact());
		System.out.print("Fax Number: ");
        System.out.println(s.getFaxNo());
		System.out.print("Address: ");
        System.out.println(s.getAddress());
		System.out.println();
	}
	
	//for Offices
	//for DB
    public Office getO(String office) {
        return oI.getOffice(office);
    }
	
	public void addO(Office s){
		oI.addOffice(s);
	}
	
	public void editO(Office s){
		oI.editOffice(s);
	}
	//for ArrayList
	
	public Office getO(int ctr){
		return offices.get(ctr);
	}
	
	public int sizeO(){
		return offices.size();
	}
    
	public void setAllOffice(ArrayList<Office> s){
		this.offices = s;
	}
	
	public void printOffices(){
		setAllOffice(oI.getAllOffice());
		System.out.println("--------------");
        for(int i = 0; i < sizeO(); i++){
			printOffice(getO(i));
			System.out.println("--------------");
		}
	}
	
	public void printOfficesbyCN(){
		setAllOffice(oI.getAllOfficeSortByContactNo());
		System.out.println("--------------");
        for(int i = 0; i < sizeO(); i++){
			printOffice(getO(i));
			System.out.println("--------------");
		}
	}
	
	public void printOfficesbyFN(){
		setAllOffice(oI.getAllOfficeSortByFaxNo());
		System.out.println("--------------");
        for(int i = 0; i < sizeO(); i++){
			printOffice(getO(i));
			System.out.println("--------------");
		}
	}
	
	public void printOffice(Office o){
		System.out.println();
		System.out.println("Name: "+o.getName());
		System.out.print("Contact Number: ");
        System.out.println(o.getContact());
		System.out.print("Fax Number: ");
        System.out.println(o.getFaxNo());
		System.out.print("Address: ");
        System.out.println(o.getAddress());
		System.out.println();
	}
	
	public List<Office> getAllOffice(){
		setAllOffice(oI.getAllOffice());
		return offices;
	}
	
	//Managing prices
	//for DB
    public PriceBean getP(BigInteger a, BigInteger b) {
        return pI.getPriceBean(a, b);
    }
    public ArrayList<PriceBean> getPs(BigInteger a) {
        return pI.getPriceBean(a);
    }
	
	public double getSupplierPrice(BigInteger a, BigInteger b){
            return pI.getSupplierPrice(a, b);
	}
	
	public double getUserPrice(BigInteger a, BigInteger b){
            return pI.getUserPrice(a, b);
	}
	
	public void addP(PriceBean pB){
		pI.addPrice(pB);
	}
	
	//for ArrayList
	
	public PriceBean getP(int ctr){
		return prices.get(ctr);
	}
	
	public int sizeP(){
		return prices.size();
	}
    
	public void setAllPriceBean(ArrayList<PriceBean> s){
		this.prices = s;
	}
	
	public void printPriceBeans(BigInteger b){
		setAllPriceBean(pI.getPriceBean(b));
		System.out.println("--------------");
        for(int i = 0; i < sizeP(); i++){
			printPriceBeanSupplier(getP(i));
			System.out.println("--------------");
		}
	}
	
	public void printPriceBeans(){
		setAllPriceBean(pI.sortPrice());
		System.out.println("--------------");
        for(int i = 0; i < sizeP(); i++){
			printSupplierandItem(getP(i));
			System.out.println("--------------");
		}
	}
        
	public void printPriceBeanItems(BigInteger b){
		setAllPriceBean(pI.getPriceBean(b));
		System.out.println("--------------");
        for(int i = 0; i < sizeP(); i++){
			printItems(getP(i));
			System.out.println("--------------");
		}
	}
	public void printPriceBeanSupplier(BigInteger b){
		setAllPriceBean(pI.getPriceSupplier(b));
		System.out.println("--------------");
        for(int i = 0; i < sizeP(); i++){
			printItems(getP(i));
			System.out.println("--------------");
		}
	}
	public void printPriceBeanUser(BigInteger b){
		setAllPriceBean(pI.getPriceBean(b));
		System.out.println("--------------");
        for(int i = 0; i < sizeP(); i++){
			printPriceItemsU(getP(i));
			System.out.println("--------------");
		}
	}
        
        public void editP(PriceBean a){
            pI.updatePrice(a);
        }
	
	
	public void printPriceBean(PriceBean pB){
		System.out.println();
		System.out.println("user price: "+pB.getUserPrice());
		System.out.println("supplier price: "+pB.getSupplierPrice());
		System.out.println("supplierID: "+pB.getSupplierID());
		System.out.println("bundleID: "+pB.getBundleID());
		System.out.println();
	}
	
	public void printItems(PriceBean pB){
		System.out.println();
		System.out.println("Item: ");
		System.out.println("BrandName: "+getB(pB.getBundleID()).getBrandName());
		System.out.println("Name: "+getB(pB.getBundleID()).getName());
		System.out.println();
	}
        
        public void printSupplierandItem(PriceBean pB){
		System.out.println("Item: ");
		System.out.println("BrandName: "+getB(pB.getBundleID()).getBrandName());
		System.out.println("Name: "+getB(pB.getBundleID()).getName());
		System.out.print("Name: "+getS(pB.getSupplierID()).getName()+"\t");
		System.out.println("supplier price: "+pB.getSupplierPrice());
        }
	
	public void printPriceBeanSupplier(PriceBean pB){
		System.out.println();
		System.out.print("Name: "+getS(pB.getSupplierID()).getName()+"\t");
		System.out.println("supplier price: "+pB.getSupplierPrice());
		System.out.println();
	}
	
	public void printPriceItemsU(PriceBean pB){
		System.out.println();
		System.out.print("Name: "+getS(pB.getSupplierID()).getName()+"\t");
		System.out.println("price: "+pB.getUserPrice());
		System.out.println();
	}
	
	//Managing SupplierTransactions
	//for DB
    public void addSTransaction(SupplierTransaction t){
		sTI.addSupplierTransaction(t);
    }
    
	// for ArrayList
    public void setHistory(List<SupplierTransaction> a){
        history = a;
    }
    
    public List<SupplierTransaction> getHistory(){
        return history;
    }
    
    public SupplierTransaction getST(String iV){
        return sTI.getSupplierTransaction(iV);
    }
	
    
    public int sizeH(){
        return history.size();
    }
	
	public void setDateDelivered(String iV){
		BundleListImpl bLI = new BundleListImpl();
		ArrayList<BreakDown> a = bLI.getSupplierBundle(iV);
		sTI.insertDateOfDelivery(iV);
		for(int i = 0; i < a.size(); i++)
			addStock(a.get(i).getBundleID(), a.get(i).getQuantity());
	}
	
	public void setDatePayed(String iV){
		sTI.insertDateOfPayment(iV);
	}
	
    public SupplierTransaction getH(int i){
        return history.get(i);
    }
	
	public void printAllSupplierTrans(){
		setHistory(sTI.getAllTransactionSupplier());
		printSupplierTransTemp();
	}
                
	public void printAllSupplierTransbyTerms(){
		setHistory(sTI.getAllSupplierTransactionByTerms());
		printSupplierTransTemp();
	}
                
	public void printAllSupplierTransbyIV(){
		setHistory(sTI.getAllTransactionSupplierSortByInvoice());
		printSupplierTransTemp();
	}
        
        public void getAllTransactionSupplierSortByTotal(){
		setHistory(sTI.getAllTransactionSupplierSortByTotal());
		printSupplierTransTemp();
	}
        
        public void getAllTransactionSupplierSortByName(){
            setHistory(sTI.getAllTransactionSupplierSortByName());
            printSupplierTransTemp();
        }
	
	public void printSupplierTransTemp(){
		System.out.println("--------------");
		SupplierTransaction sT;
        for(int i = 0; i < sizeH(); i++){
			printSupplierTrans(getH(i));
		}
		System.out.println("--------------");
	}
	
	
	public void printAllSupplierTransByTermStatus(){
                ArrayList<SupplierTransaction> onGoing = new ArrayList();
                ArrayList<SupplierTransaction> delayed = new ArrayList();
                ArrayList<SupplierTransaction> payedEarly = new ArrayList();
                ArrayList<SupplierTransaction> payedOnTime = new ArrayList();
                ArrayList<SupplierTransaction> payedLate = new ArrayList();
                ArrayList<SupplierTransaction> n = new ArrayList();
                ArrayList<SupplierTransaction> temp = sTI.getAllTransactionSupplier();
                SupplierTransaction sT;
                for(int i = 0; i < temp.size(); i++){
			if(temp.get(i).getDateOfDelivery()!=null){
                            if(temp.get(i).getTermStatus().equalsIgnoreCase("ongoing"))
                                onGoing.add(temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("delayed"))
                                delayed.add(temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed early"))
                                payedEarly.add(temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed on time"))
                                payedOnTime.add(temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed late"))
                                payedLate.add(temp.get(i));
                        }
                        else
                            n.add(temp.get(i));
		}
                ArrayList<SupplierTransaction> temporary = new ArrayList();
                temporary.addAll(onGoing);
                temporary.addAll(delayed);
                temporary.addAll(payedEarly);
                temporary.addAll(payedOnTime);
                temporary.addAll(payedLate);
                temporary.addAll(n);
                setHistory(temporary);
                for(int i = 0; i < sizeH(); i++)
                    printSupplierTrans(getH(i));
	}
	
	public void printAllSupplierTransByNearEndDays(){
                ArrayList<SupplierTransaction> onGoing = new ArrayList();
                ArrayList<SupplierTransaction> delayed = new ArrayList();
                ArrayList<SupplierTransaction> payedEarly = new ArrayList();
                ArrayList<SupplierTransaction> payedOnTime = new ArrayList();
                ArrayList<SupplierTransaction> payedLate = new ArrayList();
                ArrayList<SupplierTransaction> n = new ArrayList();
                ArrayList<SupplierTransaction> temp = sTI.getAllTransactionSupplier();
                SupplierTransaction sT;
                for(int i = 0; i < temp.size(); i++){
			if(temp.get(i).getDateOfDelivery()!=null){
                            if(temp.get(i).getTermStatus().equalsIgnoreCase("ongoing"))
                                onGoing = insertToTerms(onGoing, temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("delayed"))
                                delayed = insertToTerms(delayed, temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed early"))
                                payedEarly = insertToTerms(payedEarly, temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed on time"))
                                payedOnTime = insertToTerms(payedOnTime, temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed late"))
                                payedLate = insertToTerms(payedLate, temp.get(i));
                        }
                        else
                            n.add(temp.get(i));
		}
                ArrayList<SupplierTransaction> temporary = new ArrayList();
                temporary.addAll(onGoing);
                temporary.addAll(delayed);
                temporary.addAll(payedEarly);
                temporary.addAll(payedOnTime);
                temporary.addAll(payedLate);
                temporary.addAll(n);
                setHistory(temporary);
                for(int i = 0; i < sizeH(); i++)
                    printSupplierTrans(getH(i));
	}
        
        public ArrayList<SupplierTransaction> insertToTerms(ArrayList<SupplierTransaction> l, SupplierTransaction a){
            for(int i = 0; i < l.size(); i ++){
                if(l.get(i).getNearEndDays()<=a.getNearEndDays()){
                    l.add(i, a);
                    break;
                }
            }
            if(l.isEmpty())
                l.add(a);
            return l;
        }
        
	public void printSupplierTrans(SupplierTransaction sT){
		System.out.println();
		System.out.println("Invoice: "+sT.getInVoice());
		System.out.println("Date: "+sT.getDateRecorded());
		System.out.println("Supplier: "+sT.getTransactor());
		System.out.println("Terms of Payment: "+sT.getTerms());
		System.out.println("Date of Delivery: "+sT.getDateOfDelivery());
		System.out.println("Date of Payment: "+sT.getDateOfPayment());
		if(sT.getDateOfDelivery()!=null&&sT.getDateOfPayment()==null){
			System.out.println("Term Status: "+sT.getTermStatus());
			System.out.println("Near End Status: "+sT.getNearEndStatus());
			System.out.println("Days Before DeadLine: "+sT.getNearEndDays());
		}
		if(sT.getDateOfPayment()!=null&&sT.getDateOfDelivery()!=null){
			System.out.println("Term Status: "+sT.getTermStatus());
			System.out.println("Near End Status: "+sT.getNearEndStatus());
			System.out.println("Days remaining (to the deadline) after payment: "+sT.getNearEndDays());
		}
		sT.printBreakDown();
		System.out.println();
	}
	//Managing SupplierTransactions
	//for DB
    public void addOTransaction(OfficeTransaction t){
	oTI.addOfficeTransaction(t);
    }
    
	// for ArrayList
    public void setHistoryOT(List<OfficeTransaction> a){
        historyOT = a;
    }
    
    public List<OfficeTransaction> getHistoryOT(){
        return historyOT;
    }
    
    public OfficeTransaction getOT(String iV){
        return oTI.getOfficeTransaction(iV);
    }
	
    
    public int sizeHOT(){
        return historyOT.size();
    }
	
	public void setDateDeliveredOT(String iV){
		BundleListImpl bLI = new BundleListImpl();
		ArrayList<BreakDown> a = bLI.getSalesBD(iV);
		oTI.insertDateOfDelivery(iV);
		for(int i = 0; i < a.size(); i++)
			subtractStock(a.get(i).getBundleID(), a.get(i).getQuantity());
	}
	
	public void setDatePayedOT(String iV){
		oTI.insertDateOfPayment(iV);
	}
	
    public OfficeTransaction getHOT(int i){
        return historyOT.get(i);
    }
	
	public void printAllOfficeTrans(){
		setHistoryOT(oTI.getAllTransactionOffice());
		printOfficeTransTemp();
	}
                
	public void printAllOfficeTransbyTerms(){
		setHistoryOT(oTI.getAllOfficeTransactionByTerms());
		printOfficeTransTemp();
	}
                
	public void printAllOfficeTransbyIV(){
		setHistoryOT(oTI.getAllTransactionOfficeSortByInvoice());
		printOfficeTransTemp();
	}
        
        public void getAllTransactionOfficeSortByTotal(){
		setHistoryOT(oTI.getAllTransactionOfficeSortByTotal());
		printOfficeTransTemp();
	}
        
        public void getAllTransactionOfficeSortByName(){
            setHistoryOT(oTI.getAllTransactionOfficeSortByName());
            printOfficeTransTemp();
        }
	public void printAllOfficeTransByTermStatus(){
                ArrayList<OfficeTransaction> onGoing = new ArrayList();
                ArrayList<OfficeTransaction> delayed = new ArrayList();
                ArrayList<OfficeTransaction> payedEarly = new ArrayList();
                ArrayList<OfficeTransaction> payedOnTime = new ArrayList();
                ArrayList<OfficeTransaction> payedLate = new ArrayList();
                ArrayList<OfficeTransaction> n = new ArrayList();
                ArrayList<OfficeTransaction> temp = oTI.getAllTransactionOffice();
                OfficeTransaction sT;
                for(int i = 0; i < temp.size(); i++){
			if(temp.get(i).getDateOfDelivery()!=null){
                            if(temp.get(i).getTermStatus().equalsIgnoreCase("ongoing"))
                                onGoing.add(temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("delayed"))
                                delayed.add(temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed early"))
                                payedEarly.add(temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed on time"))
                                payedOnTime.add(temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed late"))
                                payedLate.add(temp.get(i));
                        }
                        else
                            n.add(temp.get(i));
		}
                ArrayList<OfficeTransaction> temporary = new ArrayList();
                temporary.addAll(onGoing);
                temporary.addAll(delayed);
                temporary.addAll(payedEarly);
                temporary.addAll(payedOnTime);
                temporary.addAll(payedLate);
                temporary.addAll(n);
                setHistoryOT(temporary);
                for(int i = 0; i < sizeHOT(); i++)
                    printOfficeTrans(getHOT(i));
	}
	
	public void printOfficeTransTemp(){
		System.out.println("--------------");
                for(int i = 0; i < sizeHOT(); i++){
			printOfficeTrans(getHOT(i));
		}
		System.out.println("--------------");
	}
	
	public void printOfficeTrans(OfficeTransaction sT){
		System.out.println();
		System.out.println("Invoice: "+sT.getInVoice());
		System.out.println("Date: "+sT.getDateRecorded());
		System.out.println("Office: "+sT.getTransactor());
		System.out.println("Terms of Payment: "+sT.getTerms());
		System.out.println("Date of Delivery: "+sT.getDateOfDelivery());
		System.out.println("Date of Payment: "+sT.getDateOfPayment());
		if(sT.getDateOfDelivery()!=null){
			System.out.println("Term Status: "+sT.getTermStatus());
			System.out.println("Near End Status: "+sT.getNearEndStatus());
			System.out.println("Days Before DeadLine: "+sT.getNearEndDays());
		}
		if(sT.getDateOfPayment()!=null){
			System.out.println("Term Status: "+sT.getTermStatus());
			System.out.println("Near End Status: "+sT.getNearEndStatus());
			System.out.println("Days remaining (to the deadline) after payment: "+sT.getNearEndDays());
		}
		sT.printBreakDown();
		System.out.println();
	}
	public void printAllOfficeTransByNearEndDays(){
                ArrayList<OfficeTransaction> onGoing = new ArrayList();
                ArrayList<OfficeTransaction> delayed = new ArrayList();
                ArrayList<OfficeTransaction> payedEarly = new ArrayList();
                ArrayList<OfficeTransaction> payedOnTime = new ArrayList();
                ArrayList<OfficeTransaction> payedLate = new ArrayList();
                ArrayList<OfficeTransaction> n = new ArrayList();
                ArrayList<OfficeTransaction> temp = oTI.getAllTransactionOffice();
                OfficeTransaction sT;
                for(int i = 0; i < temp.size(); i++){
			if(temp.get(i).getDateOfDelivery()!=null){
                            if(temp.get(i).getTermStatus().equalsIgnoreCase("ongoing"))
                                onGoing = insertToTerms(onGoing, temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("delayed"))
                                delayed = insertToTerms(delayed, temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed early"))
                                payedEarly = insertToTerms(payedEarly, temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed on time"))
                                payedOnTime = insertToTerms(payedOnTime, temp.get(i));
                            else if(temp.get(i).getTermStatus().equalsIgnoreCase("payed late"))
                                payedLate = insertToTerms(payedLate, temp.get(i));
                        }
                        else
                            n.add(temp.get(i));
		}
                ArrayList<OfficeTransaction> temporary = new ArrayList();
                temporary.addAll(onGoing);
                temporary.addAll(delayed);
                temporary.addAll(payedEarly);
                temporary.addAll(payedOnTime);
                temporary.addAll(payedLate);
                temporary.addAll(n);
                setHistoryOT(temporary);
                for(int i = 0; i < sizeHOT(); i++)
                    printOfficeTrans(getHOT(i));
	}
        
        public ArrayList<OfficeTransaction> insertToTerms(ArrayList<OfficeTransaction> l, OfficeTransaction a){
            for(int i = 0; i < l.size(); i ++){
                if(l.get(i).getNearEndDays()<=a.getNearEndDays()){
                    l.add(i, a);
                    break;
                }
            }
            if(l.isEmpty())
                l.add(a);
            return l;
        }
	
	//for DB
        
    public void addItem(Item t){
	iI.addItem(t);
    }
    public Item getI(String n, String bN) {
        return iI.getItem(n, bN);
    }
	
    public Item getI(BigInteger item) {
        return iI.getItem(item);
    }
	
	public void addI(Item i){
		iI.addItem(i);
	}
	
	//for ArrayList
	
	public Item getListI(int ctr){
		return items.get(ctr);
	}
	
	public int sizeI(){
		return items.size();
	}
    
	public void setAllItems(ArrayList<Item> s){
		this.items = s;
	}
	
	public void printItems(){
		setAllItems(iI.getAllItems());
		System.out.println("--------------");
        for(int i = 0; i < sizeI(); i++){
			printItem(getListI(i));
			System.out.println("--------------");
		}
	}
	
	public void printSortByBrandName(){
		setAllItems(iI.getSortByBrandName());
		System.out.println("--------------");
        for(int i = 0; i < sizeI(); i++){
			printItem(getListI(i));
			System.out.println("--------------");
		}
	}
        
	public void printSortByPrice(){
		setAllItems(iI.getSortByPrice());
		System.out.println("--------------");
        for(int i = 0; i < sizeI(); i++){
			printItem(getListI(i));
			System.out.println("--------------");
		}
	}
        
        public Item getLeast(String name,String brandName){
            return bI.getLeast(name, brandName);
        }
	
	public void printItem(Item i){
		System.out.println();
		System.out.println("Brand: "+i.getBrandName());
		System.out.println("Name: "+i.getName());
		System.out.println("Unit Price: "+i.getUnitPrice());
		System.out.println("Stock: "+i.getStock());
		System.out.println();
	}
	
	public List<Item> getAllItems(){
		setAllItems(iI.getAllItems());
		return items;
	}
        
        public void updateStock(String name, String brandName,int stock){
            iI.updateStock(name, brandName, stock);
        }
        
        public void addWalkInTransaction(Transaction wI){
            wII.addWalkInTransaction(wI);
        }
        public Transaction getWalkInTransaction(String wI){
            return wII.getWalkInTransaction(wI);
        }
        
	public Transaction getListWI(int ctr){
		return walkins.get(ctr);
	}
	
	public int sizeWI(){
		return walkins.size();
	}
    
	public void setAllTransactions(ArrayList<Transaction> s){
		this.walkins = s;
	}
	
	public void printTransactions(){
		setAllTransactions(wII.getAllWalkInTransactions());
		System.out.println("--------------");
        for(int i = 0; i < sizeWI(); i++){
			printTransaction(getListWI(i));
			System.out.println("--------------");
		}
	}
	
	public void printSortByInVoice(){
		setAllTransactions(wII.getSortByInVoice());
		System.out.println("--------------");
        for(int i = 0; i < sizeWI(); i++){
			printTransaction(getListWI(i));
			System.out.println("--------------");
		}
	}
        
        public void printTransaction(Transaction i){
		System.out.println();
                OBreakDownManager oBD = new OBreakDownManager(i.getInVoice());
		System.out.println("Invoice: "+i.getInVoice());
		System.out.println("Date: "+i.getDateRecorded());
                oBD.printBreakDownItem();
		System.out.println();
        }
        public void fastMoving(){
            ArrayList<HashMap<BigInteger,Integer>> a = sTI.getFastMoving();
            for(int i = 0; i < a.size(); i++)
                for ( BigInteger key : a.get(i).keySet() ) {
                    System.out.print(getB(key).getBrandName()+" "+getB(key).getName()+" "+getB(key).getUnit()+"\t");
                    System.out.println(a.get(i).get(key));
                }
        }
        public ArrayList<Item> fastMovingB(){
            ArrayList<HashMap<BigInteger,Integer>> a = sTI.getFastMoving();
            ArrayList<Item> items= new ArrayList();
            for(int i = 0; i < a.size(); i++)
                for ( BigInteger key : a.get(i).keySet() ) {
                    items.add(getB(key));
                    break;
                }
            return items;
        }
        public ArrayList<Integer> fastMovingI(){
            ArrayList<HashMap<BigInteger,Integer>> a = sTI.getFastMoving();
            ArrayList<Integer> is = new ArrayList();
            for(int i = 0; i < a.size(); i++)
                for ( BigInteger key : a.get(i).keySet() ) {
                    is.add(a.get(i).get(key));
                }
            return is;
        }
        
        public Office getO(BigInteger a){
            return oI.getOffice(a);
        }
        
        public ArrayList<OfficeTransaction> getALLOT(BigInteger Name){
            return oTI.getAllOfficeTransaction(Name);
        }
        
        public void printAllWalkIns(){
            
        }
        
}
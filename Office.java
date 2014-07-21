/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Logic;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import Implementation.TransactionImpl;
import Implementation.BundleListImpl;

/**
 *
 * @author Win 7
 */

public class Office {
    private String name;
    //private List<String> contacts;
    private String contact;
    private List<OTransaction> history;
    private int terms;
    private TransactionImpl tI;
    private BundleListImpl bLI;

    public Office(){
		//contacts = new ArrayList<String>();
                tI = new TransactionImpl();
                bLI = new BundleListImpl();
		history = new ArrayList<OTransaction>();    
    }
    public Office(String name) {
        this.name = name;
		//contacts = new ArrayList<String>();
		history = new ArrayList<OTransaction>();
                bLI = new BundleListImpl();
    }
	
    public Office(String name, String contact) {
        this.name = name;
		//contacts = new ArrayList<String>();
        //contacts.add(contact);
                setContact(contact);
		history = new ArrayList<OTransaction>();
                bLI = new BundleListImpl();
    }

    
    public void addOTransaction(OTransaction t){
		tI.addOfficeTransaction(t);
    }
    
    public List<OTransaction> getOTransaction(){
		return history;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    public String getName() {
        return name;
    }
    
    public void setContact(String c){
        this.contact = c;
    }
    
    public String getContact(){
        return contact;
    }
    
    public void setHistory(){
        history = getAllOTransaction();
    }
    public List<OTransaction> getAllOTransaction(){
                ArrayList<OTransaction> a = tI.getAllOfficeTransaction(name);
                ArrayList<Bundle> b;
                for(int i = 0; i < a.size(); i++){
                        a.get(i).setTotal(0.0);
                        b = bLI.getOfficeBundle(a.get(i).getInVoice());
                        for(int j = 0; j < b.size(); j++){
                            a.get(i).addSell(b.get(j), b.get(j).getPackSellPrice(), bLI.getOTransactionQuantity(a.get(i).getInVoice(), b.get(j).getBrandName(), b.get(j).getName(), b.get(j).getUnit()));
                        }
                    }
		return a;
    }
    public OTransaction getH(int i){
        return history.get(i);
    }
	
    
    public int sizeH(){
        return history.size();
    }
	/*public int sizeC(){
		return contacts.size();
	}

    public String getContact(int i) {
        return contacts.get(i);
    }

    public void addContact(String contact) {
        contacts.add(contact);
    }*/
	
}

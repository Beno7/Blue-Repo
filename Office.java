/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Logic;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Win 7
 */

public class Office {
    private String name;
    private List<String> contacts;
    private List<OTransaction> history;
    private int terms;

    public Office(String name) {
        this.name = name;
		contacts = new ArrayList<String>();
		history = new ArrayList<OTransaction>();
    }
	
    public Office(String name, String contact) {
        this.name = name;
		contacts = new ArrayList<String>();
        contacts.add(contact);
		history = new ArrayList<OTransaction>();
    }

    
    public void addOTransaction(OTransaction t){
		history.add(t);
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
	
	public int sizeC(){
		return contacts.size();
	}

    public String getContact(int i) {
        return contacts.get(i);
    }

    public void addContact(String contact) {
        contacts.add(contact);
    }
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Logic;
import java.util.Date;

/**
 *
 * @author Win 7
 */

public class Office {
    private String name;
    //private List<String> contacts;
    private String contact;;
    private int terms;

    public Office(){
		//contacts = new ArrayList<String>();
    }
    public Office(String name) {
        this.name = name;
		//contacts = new ArrayList<String>();
    }
	
    public Office(String name, String contact) {
        this.name = name;
		//contacts = new ArrayList<String>();
        //contacts.add(contact);
                setContact(contact);
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

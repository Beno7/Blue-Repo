/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Date;
import java.math.BigInteger;

/**
 *
 * @author Win 7
 */

public class Office {
    private String name;
    private String contact;
    private String faxNo;
    private String address;
    private BigInteger officeID;

    public Office(){
    }
    
    public Office(String name) {
        setName(name);
    }
	
    public Office(String name, String contact) {
        setName(name);
        setContact(contact);
    }
	
    public Office(String name, String contact, String fax) {
        setName(name);
        setContact(contact);
		setFaxNo(fax);
    }
	
    public Office(String name, String contact, String fax, String addr) {
        setName(name);
        setContact(contact);
		setFaxNo(fax);
		setAddress(addr);
    }

    public void setName(String name) {
        this.name = name;
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
    
    public void setFaxNo(String fN){
        this.faxNo = fN;
    }
    
    public String getFaxNo(){
        return faxNo;
    }
	
    public void setID(BigInteger iD){
        this.officeID = iD;
    }
    
    public BigInteger getID(){
        return officeID;
    }
    
    public void setAddress(String a){
        this.address = a;
    }
    
    public String getAddress(){
        return address;
    }
    
}

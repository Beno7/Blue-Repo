/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;
/**
 *
 * @author Win 7
 */
public class Supplier {
    private String name;
    private String contactNo;
	private String faxNo;
	private String address;
	private BigInteger supplierID;

    public Supplier(){
    }
	
    public Supplier(String name, String num){
        setName(name);
        setContact(num);
    }
	
    public Supplier(String name) {
        this.name = name;
    }
	
    public Supplier(String name, String contact, String fax) {
        setName(name);
        setContact(contact);
		setFaxNo(fax);
    }
	
    public Supplier(String name, String contact, String fax, String addr) {
        setName(name);
        setContact(contact);
		setFaxNo(fax);
		setAddress(addr);
    }
	
    public Supplier(String name, String contact, BigInteger iD, String addr, String fax) {
        setName(name);
        setContact(contact);
		setFaxNo(fax);
		setAddress(addr);
		setID(iD);
    }

    public String getName() {
        return name;
    }
    
    public String getContact(){
        return contactNo;
    }
    
    public void setContact(String c){
        this.contactNo = c;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setFaxNo(String fN){
        this.faxNo = fN;
    }
    
    public String getFaxNo(){
        return faxNo;
    }
	
    public void setID(BigInteger iD){
        this.supplierID = iD;
    }
    
    public BigInteger getID(){
        return supplierID;
    }
    
    public void setAddress(String a){
        this.address = a;
    }
    
    public String getAddress(){
        return address;
    }

}

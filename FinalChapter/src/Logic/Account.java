
package Logic;

import java.util.Date;

public class Account{

	private String firstName;
	private String lastName;
	private String userName;
	private String passWord;
	private String position;
	private Date birthDay;
	
	//constructors
	
	public Account(){
	}
	
	//setters
	
	public void setFirstName(String s){
		this.firstName = s;
	}
	
	public void setLastName(String s){
		this.lastName = s;
	}
	
	public void setUserName(String s){
		this.userName = s;
	}
	
	public void setPassWord(String s){
		this.passWord = s;
	}
	
	public void setPosition(String s){
		this.position = s;
	}
	
	public void setBirthDay(Date d){
		this.birthDay = d;
	}
	
	public void setBirthDay(java.sql.Date d){
		this.birthDay = new java.util.Date(d.getTime());
	}
	
	//getters
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getPassWord(){
		return passWord;
	}
	
	public String getPosition(){
		return position;
	}
	
	public Date getBirthDay(){
		return birthDay;
	}
	
}
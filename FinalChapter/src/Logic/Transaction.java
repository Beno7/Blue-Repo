

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Win 7
 */

public class Transaction{
    
    private String inVoice;
    private Double total;
    private Date dateRecorded; 
	
    public Transaction(){
		setDateRecorded(null);
		setInVoice(null);
		setTotal(0.0);
    }
	
	public Transaction(String iV, Date dR){
		setInVoice(iV);
		setTotal(0.0);
		setDateRecorded(dR);
	}
	
	public Transaction(String iV, double t, Date dR){
		setInVoice(iV);
		setTotal(t);
		setDateRecorded(dR);
	}

	/*public Transaction(String iV, Date dRecorded, Double a){
		setInVoice(iV);
		setDateRecorded(dRecorded);
		setTotal(a);
	}    */
	
    public String getInVoice() {
        return inVoice;
    }

    public double getTotal() {
        return total;
    }

    public void setDateRecorded(Date dRecorded) {
        this.dateRecorded = dRecorded;
    }
	
    public void setDateRecorded(java.sql.Date d){
		if(d != null)
			this.dateRecorded = new java.util.Date(d.getTime());
		else
			this.dateRecorded = null;
    }
	
    public Date getDateRecorded() {
        return dateRecorded;
    }

    public void setInVoice(String inVoice) {
        this.inVoice = inVoice;
    }

    public void setTotal(double total) {
        this.total = total;
    }
       
}

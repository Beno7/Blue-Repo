package Logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.util.List;
/**
 *
 * @author Win 7
 */
public class Transaction{
    
    private String inVoice;
    private int term;
    private Date deadline;
    private double price; //data type in diagram is int
    private String name; 
    //private List<Item> items;
   // private WRInventory wsr;

    //public WRInventory getWsr() {
        //return wsr;
    //}

    //public void setWsr(WRInventory wsr) {
        //this.wsr = wsr;
    //}
    

    public Date getDeadline() {
        return deadline;
    }

    public String getInVoice() {
        return inVoice;
    }

    //public List<Item> getItems() {
        //return items;
    //}

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getTerm() {
        return term;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setInVoice(String inVoice) {
        this.inVoice = inVoice;
    }

    //public void setItems(List<Item> items) {
        //this.items = items;
    //}

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTerm(int term) {
        this.term = term;
    }
   
    
    
}

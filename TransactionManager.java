/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

import java.util.List;

/**
 *
 * @author Win 7
 */

public class TransactionManager {
    private List<Transaction> transactions;
    
    
    public List<Transaction> viewByDate(){return transactions;}
    public List<Transaction> viewByName(){return transactions;}
    public List<Transaction> viewByTerms(){return transactions;}
    public List<Transaction> viewAllTransactions(){return transactions;}
    
}

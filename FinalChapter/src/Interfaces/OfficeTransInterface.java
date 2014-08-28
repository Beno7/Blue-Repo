/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Logic.OfficeTransaction;
import java.util.ArrayList;
import java.math.BigInteger;

/**
 *
 * @author Win 7
 */
public interface OfficeTransInterface {

    public boolean addOfficeTransaction(OfficeTransaction oT);

    public OfficeTransaction getOfficeTransaction(String inVoice);

    public ArrayList<OfficeTransaction> getAllOfficeTransaction(BigInteger officeId);

    public ArrayList<OfficeTransaction> getAllTransactionOffice();

    public void insertDateOfPayment(String iV);

    public void insertDateOfDelivery(String iV);
}

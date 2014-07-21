/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;
import Logic.Office;
import java.util.ArrayList;

/**
 *
 * @author Win 7
 */
public interface OfficeInterface {
    
    public boolean addOffice(Office o);
    
    public Office getOffice(String name);
    
    public ArrayList<Office> getAllOffice();
}

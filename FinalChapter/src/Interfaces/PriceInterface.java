
package Interfaces;
import Logic.PriceBean;
import java.math.BigInteger;
import java.util.ArrayList;
/**
 *
 * @author Win 7
 */
public interface PriceInterface {

    public boolean addPrice(PriceBean pB);

    public double getUserPrice(BigInteger bundleId, BigInteger supplierId);

    public double getSupplierPrice(BigInteger bundleId, BigInteger supplierId);
    
    public PriceBean getPriceBean(BigInteger bundleId, BigInteger supplierId);
    
    public ArrayList<PriceBean> getPriceBean(BigInteger bundleId);
    
    public ArrayList<PriceBean> getSupplierBundles(BigInteger supplierId);
    
    public ArrayList<PriceBean> getPriceSupplier(BigInteger supplierId);
    
    public ArrayList<PriceBean> sortPrice();

}
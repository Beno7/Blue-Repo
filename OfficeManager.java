
package Logic;
import java.util.List;
import java.util.ArrayList;
import Implementation.OfficeImpl;

public class OfficeManager{
	
    private List<Office> offices;
	private OfficeImpl oI;

	public OfficeManager(){
		oI = new OfficeImpl();
	}
	
	
    public Office getO(String office) {
		return oI.getOffice(office);
    }
	
	public Office getO(int ctr){
		return offices.get(ctr);
	}
	
	public void addO(Office s){
		oI.addOffice(s);
	}
	
	public int sizeO(){
		return offices.size();
	}
    
	public void setOffice(ArrayList<Office> s){
		this.offices = s;
	}
	
	public void printOffices(){
		setOffice(oI.getAllOffice());
		System.out.println("--------------");
        for(int i = 0; i < sizeO(); i++){
			printOffice(i);
			System.out.println("--------------");
		}
	}
	
	public void printOffice(int i){
		System.out.println("Office: "+getO(i).getName());
		System.out.println("Contact Numbers:");
        /*for(int j = 0; j < getO(i).sizeC(); j++)
			System.out.println(getO(i).getContact(j));*/
                System.out.println(getO(i).getContact());
		System.out.println();
	}
        
	
	public void setAllOffice(List<Office> s){
		this.offices = s;
	}
	
	public List<Office> getAllOffice(){
		setAllOffice(oI.getAllOffice());
		return offices;
	}
        //
        public void printAllTransactions(OTManager oTM){
            setAllOffice(oI.getAllOffice());
            for(int i = 0; i < sizeO(); i++){
                oTM.setHistory(getO(i).getName());
                for(int j = 0; j < oTM.sizeH(); j++)
                    oTM.getH(j).printTrans();
            }
        }
    
}
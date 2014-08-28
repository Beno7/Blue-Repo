
package Logic;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.joda.time.Days;
import org.joda.time.DateTime;
import java.math.BigInteger;

public abstract class WholeSale extends Transaction{
	private int terms;//
	private String transactor;//
        private BigInteger iD;
	
	private Date deadLine;//
	private Date datePayed;//
	private Date dateDelivered;//
	private String termStatus;//
	private boolean nearEndStatus;//
	private int nearEndDays;//
	
	public WholeSale(){
		super();
		setTerms(0);
		setTransactor(null);
		setDeadLine(null);
		setDateOfPayment(null);
		setDateOfDelivery(null);
		setTermStatus(null);
		setNearEndStatus(false);
		setNearEndDays(-1);
	}
	
	public WholeSale(String iV, Date d, String trans, int terms, BigInteger ID){
		super(iV, d);
		setTransactor(trans);
                setID(ID);
		setTerms(terms);
		setDeadLine(null);
		setDateOfPayment(null);
		setDateOfDelivery(null);
		setTermStatus(null);
		setNearEndStatus(false);
		setNearEndDays(-1);
	}
	
	public WholeSale(String iV, double t, Date d, String trans, int terms, BigInteger ID){
		super(iV, t, d);
		setTransactor(trans);
                setID(ID);
		setTerms(terms);
		setDeadLine(null);
		setDateOfPayment(null);
		setDateOfDelivery(null);
		setTermStatus(null);
		setNearEndStatus(false);
		setNearEndDays(-1);
	}
	
	//setters
	
	public void setTerms(int t){
		this.terms = t;
	}
	
    public void setID(BigInteger iD){
        this.iD = iD;
    }
        
	public void setDeadLine(Date d){
		deadLine = d;
	}
	
	public void setDeadLine(java.sql.Date d){
        if(d != null)
			deadLine = new Date(d.getTime());
        else
            deadLine = null;
	}
	
	public void setTransactor(String n){
		this.transactor = n;
	}
	
	public void setDateOfPayment(Date dOP){
		this.datePayed = dOP;
	}
	
	public void setDateOfDelivery(Date dD){
        if(dD!=null){
			this.dateDelivered = dD;
			Calendar c = new GregorianCalendar();
			c.setTime(dD);
			c.add(Calendar.DATE, terms); 
			setDeadLine(c.getTime());
			setTermStatus();
			setNearEndDays();
			setNearEndStatus();
            }
		else
			this.dateDelivered = null;
	}
        
    public void setTermStatus(String s){
        this.termStatus = s;
    }
	
	public void setTermStatus(){
		int y, y1, m, m1, d, d1;
		if(getDateOfDelivery() != null){
			if(getDateOfPayment() == null){
				Date date = new Date();
				if(date.before(getDeadLine()))
					setTermStatus("Ongoing");//Ongoing
				else
					setTermStatus("Delayed");//Delayed
			}
			else{
				Calendar cal = Calendar.getInstance();
				Calendar cal1 = Calendar.getInstance();
				cal.setTime(getDateOfPayment());
				cal1.setTime(getDeadLine());
				y = cal.get(Calendar.YEAR);
				m = cal.get(Calendar.MONTH);
				d = cal.get(Calendar.DAY_OF_MONTH);
				y1 = cal1.get(Calendar.YEAR);
				m1 = cal1.get(Calendar.MONTH);
				d1 = cal1.get(Calendar.DAY_OF_MONTH);
				if((y<y1) || ((y==y1)&&(m<m1)) || ((y==y1)&&(m==m1)&&(d<d1)))
					setTermStatus("Payed Early");//payed early
				else if((y==y1)&&(m==m1)&&(d==d1))
					setTermStatus("Payed On Time");//payed On Time
				else
					setTermStatus("Payed Late");//payed late
			}
		}
		else
			setTermStatus(null);//term countdown hasn't start yet
	}
	
    public void setNearEndStatus(boolean a){
        this.nearEndStatus = a;
    }
        
	public void setNearEndStatus(){
		if(getTermStatus().equals("Ongoing")){
			if(getNearEndDays() <= 7)
				setNearEndStatus(true);
			else
				setNearEndStatus(false);
		}
		else
			setNearEndStatus(false);
	}
	
    public void setNearEndDays(int n){
        this.nearEndDays = n;
    }
        
	public void setNearEndDays(){
		DateTime start, end;
		if(getDateOfPayment()!=null){
			start = new DateTime(getDateOfPayment());
			end = new DateTime(getDeadLine());
			setNearEndDays(Days.daysBetween(start.withTimeAtStartOfDay(), end.withTimeAtStartOfDay()).getDays());
		}
		else{
			start = new DateTime(new Date());
			end = new DateTime(getDeadLine());
			setNearEndDays(Days.daysBetween(start.withTimeAtStartOfDay(), end.withTimeAtStartOfDay()).getDays());
		}
	}
	
    public int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
	
	//getters
	
	public Date getDeadLine(){
		return deadLine;
	}
	
	public int getTerms(){
		return terms;
	}
	
	public String getTransactor(){
		return transactor;
	}
	
	public Date getDateOfPayment(){
		return datePayed;
	}
	
	public Date getDateOfDelivery(){
		return dateDelivered;
	}
	
	public String getTermStatus(){
		return termStatus;
	}
	
	public boolean getNearEndStatus(){
		return nearEndStatus;
	}
	
	public int getNearEndDays(){
		return nearEndDays;
	}
        
    public BigInteger getID(){
        return iD;
    }
	
}
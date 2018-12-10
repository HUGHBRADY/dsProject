package ie.gmit.sw.Model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bookingID",
    "custID",
    "regNo",
    "bookingDate"
})

@XmlRootElement(name = "Order")
public class Booking implements Serializable{

	private static final long serialVersionUID = 1L;
	@XmlElement(name = "bookingID")
    protected int bookingID;
	protected int custID;
    protected String regNo;
    @XmlElement(name = "bookingDate", required = true)
    @XmlSchemaType(name = "bookingDate")
    protected String bookingDate;
    
    public Booking() {
		super();
	}
    
	public Booking(int bookingID, int custID, String regNo, String bookingDate) {
		super();
		this.bookingID = bookingID;
		this.custID = custID;
		this.regNo = regNo;
		this.bookingDate = bookingDate;
	}

	public int getBookingID() {
        return bookingID;
    }
    
	public void setBookingID(int value) {
        this.bookingID = value;
    }

    // Gets the value of the bookingDate property.
    public String getBookingDate() {
        return bookingDate;
    }

    // Sets the value of the date property.
    public void setBookingDate(String value) {
        this.bookingDate = value;
    }

    // Gets the value of the regNo property.
    public String getRegNo() {
        return regNo;
    }

    // Sets the value of the regNo property.
    public void setRegNo(String value) {
        this.regNo = value;
    }

    // Gets the value of the custID property.
    public int getCustID() {
        return custID;
    }


    // Sets the value of the custID property.
    public void setCustID(int value) {
        this.custID = value;
    }

}
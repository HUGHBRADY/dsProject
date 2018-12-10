package ie.gmit.sw.Model;

import java.io.Serializable;
import java.util.Date;

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
	@XmlElement(name = "OrderID")
    protected int bookingID;
    @XmlElement(name = "bookingDate", required = true)
    @XmlSchemaType(name = "bookingDate")
    protected Date bookingDate;
    protected String regNo;
    protected int custID;
    
    public Booking() {
		super();
	}
    
	public Booking(int bookingID, int custID, String regNo, Date bookingDate) {
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
    public Date getBookingDate() {
        return bookingDate;
    }

    // Sets the value of the date property.
    public void setBookingDate(Date value) {
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
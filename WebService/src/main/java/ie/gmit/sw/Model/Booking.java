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


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookingID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="custID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="regNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bookingDate" type="{http://www.w3.org/2001/XMLSchema}Date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bookingID",
    "bookingDate",
    "regNo",
    "custID"
})
@XmlRootElement(name = "Booking")
public class Booking implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "orderID")
    protected int bookingID;
    @XmlElement(name = "bookingDate", required = true)
    @XmlSchemaType(name = "date")
    protected Date bookingDate;
    protected int regNo;
    protected int custID;

    
    public Booking() {
		super();
	}
    public Booking(int bookingID, int custID, int regNo, Date bookingDate) {
		super();
		this.bookingID = bookingID;

		this.bookingDate = bookingDate;
		this.regNo = regNo;
		this.custID = custID;
	}
    /**
     * Gets the value of the bookingID property.
     * 
     */
    public int getBookingID() {
        return bookingID;
    }

    /**
     * Sets the value of the bookingID property.
     * 
     */
    public void setBookingID(int value) {
        this.bookingID = value;
    }

    /**
     * Gets the value of the custID property.
     * 
     */
    public int getCustID() {
        return custID;
    }

    /**
     * Sets the value of the custID property.
     * 
     */
    public void setCustID(int value) {
        this.custID = value;
    }
 
    

    /**
     * Gets the value of the regNo property.
     * 
     */
    public int getRegNo() {
        return regNo;
    }

    /**
     * Sets the value of the regNo property.
     * 
     */
    public void setRegNo(int value) {
        this.regNo = value;
    }

    /**
     * Gets the value of the booking property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the value of the bookingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBookingDate(Date value) {
        this.bookingDate = value;
    }

}

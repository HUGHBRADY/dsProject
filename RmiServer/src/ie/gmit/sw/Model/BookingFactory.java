package ie.gmit.sw.Model;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class BookingFactory {
	
	public BookingFactory() {
    }

    public Booking createBooking() {
        return new Booking();
    }
}

package ie.gmit.sw.WebService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ie.gmit.sw.Model.Booking;
import ie.gmit.sw.RMI.DatabaseService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
	@GET
	@Path("/read")
	@Produces(MediaType.APPLICATION_XML)
	public List<Booking> read() throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		System.out.println("Read");
		DatabaseService ds;
		ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
		
		return ds.read();
	}
	
	@GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/create")
    public List<Booking> createOrder(String bookingDetails) throws MalformedURLException, RemoteException, Exception{
    	
			DatabaseService ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
	    	    	
	        return ds.write(bookingDetails);
    }
	
}

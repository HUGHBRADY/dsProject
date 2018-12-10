package ie.gmit.sw.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Model.Booking;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;

	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookings?useSSL=false", "root", "");
		// TODO Auto-generated constructor stub
	}

	// READ function
	@Override
	public List<Booking> read() throws RemoteException, SQLException {
		System.out.println("In read");

		stmt = conn.createStatement();

		List<Booking> List = new ArrayList<Booking>();
		
		// Query
		String strSelect = "select * from booking;";

		// Execute query
		ResultSet rs = stmt.executeQuery(strSelect);

		// Populate result set with query result
		while (rs.next()) { 
			int bookingID = rs.getInt("bookingID");
			int custID = rs.getInt("custID");
			String regNo = rs.getString("regNo");
			String bookingDate = rs.getString("bookingDate");
			
			Booking b = new Booking(bookingID, custID, regNo, bookingDate);
			List.add(b);			
		}
		
		// Return result set
		return List;
	}
	
	// WRITE function
	@Override
	public List<Booking> write(String bookingDetails) throws RemoteException, SQLException {
		System.out.println(bookingDetails);
		stmt = conn.createStatement();
		
		List<Booking> List = new ArrayList<Booking>();
				
		// Take in strings from create.jsp file and get's rid of filler
		// so we have a string consisting of the values to put into the db
		bookingDetails = bookingDetails.replace("Booking Number:", "");
		bookingDetails = bookingDetails.replace("Customer Number:", "");
		bookingDetails = bookingDetails.replace("Car Registration:", "");
		bookingDetails = bookingDetails.replace("Booking Date:", "");
		bookingDetails = bookingDetails.replace("&", "', '");
		bookingDetails = bookingDetails + "'";
		
		// Create the query
		String insertQuery = "INSERT INTO booking (bookingID, custID, regNo, bookingDate) VALUES " + 
		"(NULL, '" + bookingDetails + ");";
		
		// Insert the query
		stmt.executeUpdate(insertQuery);
		String selectQuery = "select * from bookings ORDER BY bookingID";
		
		// Get the result
		ResultSet rs = stmt.executeQuery(selectQuery);
		
		// Populate result set with variables
		while(rs.next()){
			int bookingID = rs.getInt("bookingID");
			int custID = rs.getInt("custID");
			String regNo = rs.getString("regNo");
			String bookingDate = rs.getString("bookingDate");
						
			Booking b = new Booking();
			
			b.setBookingID(bookingID);
			b.setCustID(custID);
			b.setRegNo(regNo);
			b.setBookingDate(bookingDate);
			
			List.add(b);
		}
		// Return the table
		return List;
	}
	
	// UPDATE function - not implemented
	@Override
	public List<Booking> update(String bookingDetails) throws RemoteException, SQLException {
		stmt = conn.createStatement();

		List<Booking> List = new ArrayList<Booking>();

		return List;
	}

	// DELETE function
	@Override
	public List<Booking> delete(String deleteID) throws SQLException, RemoteException {
		stmt = conn.createStatement();
		
		List<Booking> List = new ArrayList<Booking>();
		
		// Create a variable for the delete query
		String insertQuery = "DELETE FROM booking WHERE " + deleteID + ";";
		// Execute it
		stmt.executeUpdate(insertQuery);

		String selectQuery = "select * from booking ORDER BY bookingID";

		ResultSet rs = stmt.executeQuery(selectQuery);
		
		// Populate the result set with the table contents
		while(rs.next()){
			int bookingID = rs.getInt("bookingID");
			int custID = rs.getInt("custID");
			String regNo = rs.getString("regNo");
			String bookingDate = rs.getString("bookingDate");
			
			Booking b = new Booking();
			
			b.setBookingID(bookingID);
			b.setCustID(custID);
			b.setRegNo(regNo);
			b.setBookingDate(bookingDate);
			
			List.add(b);
		}
		// Return the table
		return List;
	}
		
	
}

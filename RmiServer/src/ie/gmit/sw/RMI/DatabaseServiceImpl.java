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
		String strSelect = "select * from booking;";

		ResultSet rs = stmt.executeQuery(strSelect);

		while (rs.next()) { 
			int bookingID = rs.getInt("bookingID");
			int custID = rs.getInt("custID");
			String regNo = rs.getString("regNo");
			String bookingDate = rs.getString("bookingDate");
			
			Booking b = new Booking(bookingID, custID, regNo, bookingDate);
			List.add(b);			
		}
		
		return List;
	}
	
	// WRITE function
	@Override
	public List<Booking> write(String bookingDetails) throws RemoteException, SQLException {
		stmt = conn.createStatement();
		
		List<Booking> List = new ArrayList<Booking>();
				
		bookingDetails = bookingDetails.replace("bookingID=", "");
		bookingDetails = bookingDetails.replace("custID=", "");
		bookingDetails = bookingDetails.replace("regNo=", "");
		bookingDetails = bookingDetails.replace("bookingDate=", "");
		bookingDetails = bookingDetails.replace("&", "', '");
		
		bookingDetails = bookingDetails + "'";
				
		String insertQuery = "INSERT INTO booking (bookingID, custID, regNo, bookingDate) VALUES " + 
		"(NULL, '" + bookingDetails + ");";
		
		stmt.executeUpdate(insertQuery);
		
		String selectQuery = "select * from bookings ORDER BY bookingID";
		
		ResultSet rs = stmt.executeQuery(selectQuery);
		
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
		return List;
	}
	
	// UPDATE function
	@Override
	public List<Booking> update(String bookingDetails) throws RemoteException, SQLException {
		stmt = conn.createStatement();

		List<Booking> List = new ArrayList<Booking>();
			/*
		bookingDetails = bookingDetails.replace("&", "', ");
		bookingDetails = bookingDetails.replace("bookingID", "bookingID='");
		bookingDetails = bookingDetails.replace("custID=", "custID='");
		bookingDetails = bookingDetails.replace("regNo=", "regNo='");
		bookingDetails = bookingDetails.replace("bookingDate=", "bookingDate='");
		
		bookingDetails = bookingDetails + "'";
		
		bookingDetails = bookingDetails.replace("bookingId=''", "");
		bookingDetails = bookingDetails.replace("custID=''", "");
		bookingDetails = bookingDetails.replace("regNo=''", "");
		bookingDetails = bookingDetails.replace("bookingDate=''", "");
				
		String insertQuery = "UPDATE booking SET " + bookingDetails + " WHERE " + bookingID + ";";
				
		stmt.executeUpdate(insertQuery);
		
		String selectQuery = "select * from booking ORDER BY bookingID";
		
		ResultSet rs = stmt.executeQuery(selectQuery);
		
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
*/
		return List;
	}

	// DELETE function
	@Override
	public List<Booking> delete(String deleteID) throws SQLException, RemoteException {
		stmt = conn.createStatement();
		
		List<Booking> List = new ArrayList<Booking>();
		
		String insertQuery = "DELETE FROM booking WHERE " + deleteID + ";";
				
		stmt.executeUpdate(insertQuery);
		
		String selectQuery = "select * from booking ORDER BY bookingID";

		ResultSet rs = stmt.executeQuery(selectQuery);
		
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
		return List;
	}
	
	
	
}

package ie.gmit.sw.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Model.Booking;



public interface DatabaseService extends Remote {
	public List<Booking> read() throws RemoteException, SQLException;
	
	public List<Booking> update(String bookingDetails) throws RemoteException, SQLException;

	public List<Booking> write(String bookingDetails) throws SQLException, RemoteException;

	public List<Booking> delete(String deleteID) throws SQLException, RemoteException;
}

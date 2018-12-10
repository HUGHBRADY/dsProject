package ie.gmit.sw.RMI;

import java.rmi.Naming;
import java.util.List;

import ie.gmit.sw.Model.Booking;

public class RmiClass {
	
	private DatabaseService ch;

	public RmiClass() throws Exception {
		ch = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
	}

	// READ
	public List<Booking> readData() throws Exception {
		return ch.read();
	}

}

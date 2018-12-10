<html>
<body>
    <h2>Update an Order</h2>
    <form action="webapi/myresource/update" method="get">
	    <p>Order ID : </p>
    	<input type="number" name="bookingID"/><br></br>
	    <p>Customer Number: </p>
    	<input type="number" name="custID"/>
	    <p>Car Registration Number:</p>
    	<input type="text" name="regNo"/>
	    <p>Booking Date: </p>
    	<input type="text" name="bookingDate"/>
   	 	<input type="submit" value="Submit"/>
    </form>
    <p><a href="index.jsp">Return</a></p>
</body>
</html>

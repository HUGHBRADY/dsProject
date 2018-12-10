<html>
<body>
    <h2>Create an Order</h2>
    <form action="webapi/myresource/create" method="get">
	    <p>Booking Number: </p>
	    <input type="number" name="bookingID"/>
	    <p>Customer Number: </p>
    	<input type="number" name="custID"/>
	    <p>Car Registration: </p>
    	<input type="text" name="regNo"/>
    	<p>Booking Date: </p>
    	<input type="text" name="bookingDate" />
	   	<input type="submit" value="Submit"/>
    </form>
    <p><a href="index.jsp">Return</a></p>
</body>
</html>
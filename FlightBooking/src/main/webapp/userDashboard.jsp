<%@ page session="true" %>
<%@ page import="model.User, java.util.List, model.Flight" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("signUp.jsp");
        return;
    }

    // Get flights if servlet forwarded results
    List<Flight> flights = (List<Flight>) request.getAttribute("flights");
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background-color: #f4f6f9; }
        h2 { color: #2c3e50; }
        .nav { margin: 20px 0; }
        .nav a {
            margin-right: 20px;
            text-decoration: none;
            color: #fff;
            background: #3498db;
            padding: 8px 15px;
            border-radius: 5px;
        }
        .nav a:hover { background: #2980b9; }
        form {
            margin-top: 20px;
            background: #fff;
            padding: 15px;
            border-radius: 8px;
            width: 400px;
            box-shadow: 0px 2px 6px rgba(0,0,0,0.1);
        }
        form input[type="text"] {
            margin: 5px 0;
            padding: 6px;
            width: calc(100% - 20px);
        }
        form input[type="submit"] {
            background: #27ae60;
            color: white;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
            border-radius: 5px;
        }
        form input[type="submit"]:hover { background: #1e8449; }

        /* Hidden table */
        #flightsTable {
            display: none;
            margin-top: 20px;
            border-collapse: collapse;
            width: 90%;
            background: #fff;
            box-shadow: 0px 2px 6px rgba(0,0,0,0.1);
        }
        #flightsTable th, #flightsTable td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        #flightsTable th {
            background: #3498db;
            color: #fff;
        }
    </style>
</head>
<body>
    <h2>Welcome, <%= user.getName() %></h2>

    <!-- Navigation -->
    <div class="nav">
        <a href="viewFlights">View All Flights</a>
        <a href="myBookings">My Bookings</a>
        <a href="logout">Logout</a>
    </div>

    <!-- Flight Search -->
    <h3>Search Flights</h3>
    <form action="searchFlight" method="get">
        <label>From:</label><br>
        <input type="text" name="source" placeholder="Enter source city" required><br><br>

        <label>To:</label><br>
        <input type="text" name="destination" placeholder="Enter destination city" required><br><br>

        <input type="submit" value="Search Flights">
    </form>

    <!-- Flights Table -->
    <%
        if (flights != null && !flights.isEmpty()) {
    %>
    <table id="flightsTable">
        <tr>
            <th>Flight Number</th>
            <th>Airline</th>
            <th>From</th>
            <th>To</th>
            <th>Departure Date</th>
            <th>Departure Time</th>
            <th>Arrival Time</th>
            <th>Price</th>
        </tr>
        <%
            for (Flight f : flights) {
        %>
        <tr>
            <td><%= f.getFlightNumber() %></td>
            <td><%= f.getAirline() %></td>
            <td><%= f.getSource() %></td>
            <td><%= f.getDestination() %></td>
            <td><%= f.getDepartureDate() %></td>
            <td><%= f.getDepartureTime() %></td>
            <td><%= f.getArrivalTime() %></td>
            <td><%= f.getPrice() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <script>
        // Show the hidden table only if flights exist
        document.getElementById("flightsTable").style.display = "table";
    </script>
    <%
        }
    %>
</body>
</html>

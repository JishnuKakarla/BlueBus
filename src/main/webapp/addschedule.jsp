<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="bus.css" media="screen"/> 
<title>Add Schedule</title>
</head>
<body>
	<h1>Enter Schedule Details</h1>
	<form action="database" method="post">
		<table>
			<tr>
				<th> Enter Source</th>
				<td><input type="text" name="source" required></td>
			</tr>

			<tr>
				<th>Enter Final Destination</th>
				<td><input type="text" name="destination" required></td>
			</tr>

			<tr>
				<th>Start Time</th>
				<td><input type="text" name="startTime" required></td>
			</tr>

			<tr>
				<th>Arrival Time</th>
				<td><input type="text" name="arrivalTime" required></td>
			</tr>
			
			<tr>
				<td><input type="text" name="operation" value="newSchedule" hidden></td>
			</tr>

		</table>
		<br>
		<br> <input type="submit" value="create schedule">
	</form>
</body>
</html>
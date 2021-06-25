<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="bus.css" media="screen" />
<title>view schedule</title>
</head>
<body>
	<h1>View Schedule Details</h1>
	<form action="database" method="post">
		<table>
			<tr>
				<th>Enter Source</th>
				<td><input type="text" name="source"></td>
			</tr>
			<tr>
				<th>Enter Destination</th>
				<td><input type="text" name="destination"></td>
			</tr>

			<tr>
				<td><input type="text" name="operation" value="viewSchedule" hidden></td>
			</tr>
		</table>
		<br> <br> <input type="submit" value="Search schedule">
	</form>
</body>
</html>
<%@page import="com.jishnu.bluebus.bean.ScheduleBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<ScheduleBean> arrayList = (ArrayList) request.getAttribute("data");
		
	%>
	<table>
		<tr>	
			<th>ScheduleID</th>
			<th>SOURCE</th>
			<th>DESTINATION</th>
			<th>START TIME</th>
			<th>ARRIVAL TIME</th>
		</tr>
		<%
		for(ScheduleBean item: arrayList){
		%>
			<tr>	
				<td><%=item.getScheduleId() %>
				<td><%= item.getSource() %></td>
				<td><%= item.getDestination() %></td>
				<td><%= item.getStartTime() %></td>
				<td><%= item.getArrivalTime() %></td>
			</tr>
		<% } %>
	</table>
</body>
</html>
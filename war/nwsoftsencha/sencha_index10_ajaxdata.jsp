<%@ page contentType="text/plain;charset=UTF-8"%>

<% 
	int x=Integer.parseInt(request.getParameter("x")); 
	int y=Integer.parseInt(request.getParameter("y"));
	int result = x+y;	
%>

<%= result %>

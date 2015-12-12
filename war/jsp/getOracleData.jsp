<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.*" %>

<%
	//Prepare: 톰캣, JDK, OracleDB
	//1. Copy ojdbc14.jar, classes12.jar in Oracle install lib
	//2. Paste to 톰캣/common/lib/ and JDK/jre/lib/ext
	//3. Shutdown and restart Tomcat...
	
	 request.setCharacterEncoding("utf-8");
	 
	 String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	 String user= "scott";
	 String pass= "scott123";
	 out.println(url);
	 
	 Connection conn = null;
	 Statement stmt = null;
	 ResultSet rs=null;
	 String sql=null;
	 
	 
	 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url, user, pass);
			
			sql="select count(*) cnt from Employee";
			stmt= conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while (rs.next()) {
				//To make output format with html/css
		    	out.println("<h4>Total rows: " + rs.getInt("cnt") + "</h4>");
		    }
			//
	
		} catch(ClassNotFoundException ce) {
			ce.printStackTrace();
			out.println(e);
		} catch (SQLException e) {
		    e.printStackTrace();
		    out.println(e);
		}
%>

<!-- JSP code in Html -->
<body>
<table>
<%
	try {
		sql="select empid, empname from Employee";
		stmt= conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		while (rs.next()) {
	    	out.println("<tr>");
	    	out.println("<td>" + rs.getInt("empid") +"</td>");
	    	out.println("<td>" + rs.getString("empname") +"</td>");
	    	out.println("</tr>");
	    }
	
	} catch (SQLException e) {
	    e.printStackTrace();
	    out.println(e);
	}	
%>
</table>
<%
//close all db objects...
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (conn != null) conn.close();
%>
</body>
</html>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Getting Data from Microsoft SQL Server</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*;" %>
<table>
<%
// sqljdbc.jar, sqljdbc4.jar, sqljdbc41, and sqljdbc42.jar
//https://technet.microsoft.com/en-US/library/ms378526(v=sql.110).aspx

	java.sql.Connection conn;
	java.sql.Statement stmt;
	java.sql.ResultSet rs;
	java.sql.PreparedStatement pstmt;
	
	conn=null; 
	stmt=null;
	rs=null;
	pstmt=null;
	//JDBC Driver for SqlServer from http://jtds.sourceforge.net/  
	//XXXJdbc.jar HAVE TO Paste to 톰캣/common/lib/
	
	//String url="jdbc:jtds:sqlserver://127.0.0.1/SQLDbName";
	String url="jdbc:sqlserver://localhost:1433;databaseName=nwsoftdb";
	String user="sa";
	String pass="1111";
	
	try {
		//Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn=DriverManager.getConnection(url, user, pass);
	}catch(ClassNotFoundException ce) {
		ce.printStackTrace();
		out.println(e);
	}catch (SQLException e) {
	    e.printStackTrace();
	    out.println(e);
	}
	String sql="select * from items";
	try {
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		while(rs.next()) {
%>
			<tr>
			<td><%= rs.getString("iprod") %></td>
			<td><%= rs.getString("idesc") %></td>
			</tr>
<%			
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if (rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}
%>
</table>
</body>
</html>
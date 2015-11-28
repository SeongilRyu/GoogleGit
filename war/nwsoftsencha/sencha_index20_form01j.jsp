<%@ page contentType="application/x-json;charset=UTF-8" %>
<%
	String mid=request.getParameter("mid");
	String mpassword=request.getParameter("mpassword");
	String message=null;
	if(mid !=null && mpassword !=null) {
		if (mid.equals("user")) {
			if (mpassword.equals("1234")) {
				message = "Login OK";
			} else {
				message="Wrong Password";
			}
		} else {
			message="User not exist";
		} 
	} else {
		message="No User and No password";
	}
%>
<%	if (message.equals("Login OK")) { %>
	{
		"success":true,
		"loginResult":"success"
	}
<%} else {%>
	{
		"success":true,
		"loginResult":"fail",
		"message":"<%=message%>"
	}
<%}%>
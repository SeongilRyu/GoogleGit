<%@ page contentType="text/plain;charset=UTF-8" language="java" %>

<% response.setHeader("Cache-Control","no-store"); %>
<% String name=request.getParameter("name"); %>
<% String callback=request.getParameter("stoneCallback"); %>

<% if (callback != null) { %>
    <%=callback %> ( 
           [
           	 { "pname": "testname" }
           ]
    );
<%}%>

<?xml version="1.0" encoding="utf-8"?>
<%@ page contentType="text/xml;charset=UTF-8"%>

<% response.setHeader("Cache-Control","no-store"); %>
<% String pno=request.getParameter("pno"); %>

<% if (pno==null || pno.equals("p1")) { %>
	<phone>
		<pno>p1</pno>
		<pname>Galuxy</pname>
	</phone>
<%}%>

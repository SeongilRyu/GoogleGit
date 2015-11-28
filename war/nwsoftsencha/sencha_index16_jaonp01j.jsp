<%@ page contentType="text/javascript;charset=UTF-8" %>
<%response.setHeader("Cache-Control","no-store");%>

<%String callback = request.getParameter("serverKey"); %>
<%if (callback !=null) {%>
<%= callback%> (
	[
		{
			"pno":"p1",
			"pname":"GaluxyA",
			"pimage":"phone01.png"
		},
		{
			"pno":"p2",
			"pname":"GaluxyB",
			"pimage":"phone02.png"
		}
	]
);
<%}%>
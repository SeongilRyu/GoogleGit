<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%
//read db and insert into list<string>
	List<String[]> phoneDb=(List<String[]>) session.getAttribute("phoneDb");
	if (phoneDb==null) {
		phoneDb=new ArrayList<String[]>();
		phoneDb.add(new String[] {
			"p1", "Galaxy A","audi.PNG","Samsung","600000","Black"
		});
		phoneDb.add(new String[] {
			"p2", "Galaxy B","benz.PNG","LG","500000","흰색"
		});
	}
 %>
 <div id="phonelist" data-role="page">
 	<div data-role="header" data-position="fixed">
 		<h3>Phone List</h3>
 	</div>
 	<div data-role="content">
 		<ul data-role="listview">
 		<%for(String[] phone:phoneDb) {%>
 		<li>
 			<!--<a href="http://192.168.219.178:8888/nwsofthome/jqindex_phonedetail.jsp?pno=<%=phone[0]%>">-->
 			<a href="/nwsofthome/jqindex_phonedetail.jsp?pno=<%=phone[0]%>">
 				<table>
 					<tr>
 						<td style="padding-right:5px">
 							<img src="../nwsofthome/img/<%=phone[2]%>" style="width:30px; height:50px"/>
 						</td>
 						<td style="padding-left:5px"><%=phone[1]%></td>
 						<td style="padding-left:5px"><%=phone[3]%></td>
 						<td style="padding-left:5px"><%=phone[4]%></td>
 						<td style="padding-left:5px"><%=phone[5]%></td>
 					</tr>
 				</table>
 			</a>
 		</li>
 		<%}%>
 		</ul>
 	</div>
 	<div data-rold="footer" data-position="fixed">
 		<div data-role="navbar">
 			<ul>
 				<li><a href="#home" data-icon="home" data-transition="slide" data-direction="reverse">
 				AppHome
 				</a>
 				</li>
 			</ul>
 		</div>
 	</div>
 </div>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%
	String pno=request.getParameter("pno");
	//response.write(pno);
	List<String[]> phoneDb=(List<String[]>)session.getAttribute("phoneDb");
	if (phoneDb==null) {
		phoneDb=new ArrayList<String[]>();
		phoneDb.add(new String[] {
			"p1", "Galaxy A","audi.PNG","Samsung","600000","Black"
		});
		phoneDb.add(new String[] {
			"p2", "Galaxy B","benz.PNG","LG","500000","Èò»ö"
		});
	}	
	String[] phone=null;
	for(String[] p : phoneDb) {
		if (p[0].equals(pno)) {
		phone=p;
		break;
		}
	}
 %>
 <div id="phonedetail" data-role="page">
 	<div data-role="header" data-position="fixed">
 		<h3>Phone Detail</h3>
 	</div>
 	<div data-role="content">
 		<ul data-role="listview">
 		<li>
			<table>
				<tr>
					<td style="padding-right:5px">
						<img src="../nwsofthome/img/<%=phone[2]%>" style="width:30px; height:50px"/>
					</td>
					<td style="padding-left:5px">
						<table>
							<tr>
								<td>Model:</td>
								<td><%=phone[1]%></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
 		</li>
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
 
<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.net.URLConnection" %>
<%@ page import="java.net.MalformedURLException" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.IOException" %>

<%
 request.setCharacterEncoding("utf-8");
 
 String stockCode=request.getParameter("stockCode");
 if (stockCode==null || stockCode.length() < 1 ) stockCode="EWY";
 //
 String strUrl="http://finance.google.com/finance/info?client=ig&q=EEM,EWY,EWJ,MCHI,INDA,EWA,EWS,EWH,EWM,EIDO";
 System.out.println(strUrl);
 try {
	    URL url = new URL(strUrl);
	    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	    String line;

		//response.setContentType("text/csv");
		//PrintWriter outx = response.getWriter();
	    while ((line = reader.readLine()) != null) {
	    	out.println(line.replace("//", ""));
// 			outx.println(line);
// 			outx.flush();
	    }
		//outx.close();
	    reader.close();

	} catch (MalformedURLException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
 
	
 // Set refresh, autoload time as 5 seconds
 ///response.setIntHeaer("Refresh", 5);
 // Get current time
//  Calendar calendar = new GregorianCalendar();
//  String am_pm;
//  int hour = calendar.get(Calendar.HOUR);
//  int minute = calendar.get(Calendar.MINUTE);
//  int second = calendar.get(Calendar.SECOND);
//  if(calendar.get(Calendar.AM_PM) == 0)
//     am_pm = "AM";
//  else
//     am_pm = "PM";
//  String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
//  out.println("Current Time is: " + CT + "\n");


%>
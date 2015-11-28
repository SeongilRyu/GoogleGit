<%@ page language="java" contentType="javascript/jsonp; charset=UTF-8" pageEncoding="UTF-8"%>
<%
       String name = request.getParameter("name");
       String stone = request.getParameter("stoneCallback");
       response.addHeader("Access-Control-Allow-Origin","*");
       out.println(stone + "(");
       out.println("{\"data\":{\"name\":\""+name+"\"}}");
       out.println(")");
 %>
 
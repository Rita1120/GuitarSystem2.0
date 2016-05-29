<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guitar.service.Inventory" %>
<%@ page import="guitar.model.Guitar" %>
<%@ page import="guitar.conn.DbConn" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
</head>
<body>
     <h3>查询结果如下,如果不满意，请<a href="findGuitar.jsp">返回</a>重新查询</h3>
	<table border="1" width="600px">
	    <thead>
	        <tr>
	            <th>编号</th>
	            <th>价格</th>
	            <th>制造商</th>
	            <th>型号</th>
	            <th>类型</th>
	            <th>背板木</th>
	            <th>顶端木</th>
	        </tr>
	    </thead>
	    <tbody>
        
        <% 
		Inventory inventory = new Inventory();
		inventory = (Inventory)request.getAttribute("result");
		List guitars = new ArrayList();
		guitars = inventory.getGuitar();
		System.out.print(guitars.size());
		if(guitars.size()>0){
		Iterator i = guitars.iterator();
		while(i.hasNext()){
			Guitar guitar = (Guitar) i.next();
		 %>
		 <tr>
        <td><%=guitar.getSerialNumber() %></td> 
        <td><%=guitar.getPrice()%></td>    
        <td><%=guitar.getSpec().getBuilder() %></td>   
        <td><%=guitar.getSpec().getModel() %></td>   
        <td><%=guitar.getSpec().getType() %></td>   
        <td><%=guitar.getSpec().getBackWood() %></td>    
        <td><%=guitar.getSpec().getTopWood() %></td></tr> 
        <%}}else{%>
		  <h3>仓库无该款吉他，请重新查询。<h3>   
			<%}%>
          
	    </tbody>
	    </table>
</body>
</html>
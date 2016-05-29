<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ page import="guitar.model.Type" %>
  <%@ page import="guitar.model.Wood" %>
  <%@ page import="guitar.model.Builder" %>
  <%@ page import="guitar.model.Guitar" %>
   <%@ page import="guitar.model.GuitarSpec" %>
   <%@ page import="guitar.conn.DbConn" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>查询吉他</title>
</head>
<body>
<form action="searchGuitar" method="post">
<label>生产商：</label><select name="builder" id="builder" >
                                              <option></option>
                                              <% for(int  i = 0; i<Builder.values().length;i++){%>
                                              <option value="<%=Builder.values()[i]%>"><%=Builder.values()[i]%></option>
                                              <%} %>
                                           </select>
<label>型号：</label><select name="model" id="model" >
                                            <option></option>
                                            <option value="Stratocastor">Stratocastor</option>
                                            <option value="CJ">CJ</option>
	                                        <option value="YAMAHA">YAMAHA</option>
                                      </select>
<br><br>
<label>类型：</label><select name="type" id="type">
                                          <option></option>
                                           <% for(int  i = 0; i<Type.values().length;i++){%>
                                              <option value="<%=Type.values()[i]%>"><%=Type.values()[i]%></option>
                                              <%} %>
                                          </select>
<label>背板木：</label><select name="backWood" id="backWood" >
                                              <option></option>
                                                 <% for(int  i = 0; i<Wood.values().length;i++){%>
                                              <option value="<%=Wood.values()[i]%>"><%=Wood.values()[i]%></option>
                                              <%} %>
                                           </select>
<label>顶端木：</label><select name="topWood" id="topWood" >
                                               <option></option>
                                                <% for(int  i = 0; i<Wood.values().length;i++){%>
                                                <option value="<%=Wood.values()[i]%>"><%=Wood.values()[i]%></option>
                                                 <%} %>
                                          </select>
<br><br>
&nbsp;&nbsp;&nbsp;
<input type="submit" name="find" id="find"  value="查询">
&nbsp;&nbsp;&nbsp;
<input type="reset" name="reset" value="重置">
<br><br>
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
try{
    Connection conn=DbConn.getConnection();
   //从数据库里面取出所有吉他
    String sql="select * from guitar";
	PreparedStatement stmt=conn.prepareStatement(sql);
	ResultSet rs= stmt.executeQuery();
	List<Guitar> guitars = new ArrayList<Guitar>();
	while (rs.next()) {
		%>
		<tr>
     	<td><%=rs.getString(1)%></td>
		<td><%=rs.getDouble(2)%></td>
		<td><%=rs.getString(3)%></td>
		<td><%=rs.getString(4)%></td>
		<td><%=rs.getString(5)%></td>
		<td><%=rs.getString(6)%></td>
		<td><%=rs.getString(7)%></td>
		</tr>    
	   
		 
	<%}
	
   }
catch (Exception e) {
	e.printStackTrace();
}
%>
 </tbody>
</table>
</body>

</html>
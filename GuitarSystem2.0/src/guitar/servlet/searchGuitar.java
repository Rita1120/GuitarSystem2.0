package guitar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guitar.conn.DbConn;
import guitar.model.Builder;
import guitar.model.Guitar;
import guitar.model.GuitarSpec;
import guitar.model.Type;
import guitar.model.Wood;
import guitar.service.Inventory;

/**
 * Servlet implementation class searchGuitar
 */
@WebServlet("/searchGuitar")
public class searchGuitar extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setCharacterEncoding("utf-8");
		   request.setCharacterEncoding("utf-8");
		   String builder=request.getParameter("builder");
		   String model=request.getParameter("model");
		   String type=request.getParameter("type");
		   String backWood=request.getParameter("backWood");
	       String topWood=request.getParameter("topWood");
	       //参数构成的吉他对象
		    Guitar guitar1 = new Guitar();
			GuitarSpec spec1 = new GuitarSpec();
		   if(builder!=null&&!builder.equals("")){
			   System.out.print("builder");
			    spec1.setBuilder(Builder.valueOf(builder.toUpperCase()));
		   }
		   if(model!=null&&!model.equals("")){
			    spec1.setModel(model);
		   }
		   if(type!=null&&!type.equals("")){
			    spec1.setType(Type.valueOf(type.toUpperCase()));
		   }
		   if(backWood!=null&&!backWood.equals("")){
			    spec1.setBackWood(Wood.valueOf(backWood.toUpperCase()));
		   }
		   if(topWood!=null&&!topWood.equals("")){
			    spec1.setTopWood(Wood.valueOf(topWood.toUpperCase()));
		   }
		    guitar1.setGuitarSpec(spec1);
			Inventory inventory = new Inventory();
			
			
		   try{
		    Connection conn=DbConn.getConnection();
		   //从数据库里面取出所有吉他
		    String sql="select * from guitar";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs= stmt.executeQuery();
			List guitars = new ArrayList();
			while (rs.next()) {
				Guitar guitar2 = new Guitar();
				GuitarSpec spec2= new GuitarSpec();
				spec2.setBuilder(Builder.valueOf(rs.getString("builder").toUpperCase()));
				spec2.setBackWood(Wood.valueOf(rs.getString("backWood").toUpperCase()));
				spec2.setTopWood(Wood.valueOf(rs.getString("topWood").toUpperCase()));
				spec2.setModel(rs.getString("model"));
				spec2.setType(Type.valueOf(rs.getString("type").toUpperCase()));
				guitar2.setPrice(rs.getDouble("price"));
				guitar2.setSerialNumber(rs.getString("serialNumber"));
				guitar2.setGuitarSpec(spec2);
				guitars.add(guitar2);
				System.out.println(guitar2);
			}
			stmt.close();
			inventory.setGuitar(guitars);
			inventory.search(guitar1);
			inventory.setGuitar(inventory.search(guitar1));
		    request.setAttribute("result", inventory);
		    request.getRequestDispatcher("guitar.jsp").forward(request, response);
		   }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
	}

}

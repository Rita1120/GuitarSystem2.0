package guitar.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import guitar.conn.DbConn;
public class utilTester {
     
	public static void main(String[] args) throws Exception {
		Connection conn = DbConn.getConnection();
		
		PreparedStatement pstmt = null;
		String sql1 = "INSERT INTO guitar(serialNumber,price,builder,model,type,backWood,topWood) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql1);
		pstmt.setString(1, "11222");
		pstmt.setDouble(2, 3999.95);
		pstmt.setString(3, "Collings");
		pstmt.setString(4, "CJ");
		pstmt.setString(5, "ACOUSTIC");
		pstmt.setString(6, "Sitka");
		pstmt.setString(7, "Maple");
		if (pstmt.executeUpdate() > 0) {
			System.out.print("sql1 yeah");
		}
		
		String sql2 = "INSERT INTO guitar(serialNumber,price,builder,model,type,backWood,topWood) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1, "V95685");
		pstmt.setDouble(2, 1499.95);
		pstmt.setString(3, "Fender");
		pstmt.setString(4, "Stratocastor");
		pstmt.setString(5, "ELECTRIC");
		pstmt.setString(6, "Alder");
		pstmt.setString(7, "Alder");
		if (pstmt.executeUpdate() > 0) {
			System.out.print("sql2 yeah");
		}
		String sql3 = "INSERT INTO guitar(serialNumber,price,builder,model,type,backWood,topWood) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql3);
		pstmt.setString(1, "V358");
		pstmt.setDouble(2,  1549.95);
		pstmt.setString(3, "Alder");
		pstmt.setString(4, "Stratocastor");
		pstmt.setString(5, "ELECTRIC");
		pstmt.setString(6, "Mahogany");
		pstmt.setString(7, "Maple");
		if (pstmt.executeUpdate() > 0) {
			System.out.print("sql3 yeah");
		}

	}

}

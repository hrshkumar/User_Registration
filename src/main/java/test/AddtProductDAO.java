	package test;

import java.sql.*;

public class AddtProductDAO {
	public int k = 0;

	public int insert(ProductBean pb) {
		try {
			Connection con = DBConnection.getCon();// Access DB Connection
			PreparedStatement ps = con.prepareStatement
					("insert into Product50 values(?,?,?,?)");
			ps.setString(1, pb.getCode());
			ps.setString(2, pb.getName());
			ps.setFloat(3, pb.getPrice());
			ps.setInt(4, pb.getQty());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;

	}
}

package db.look;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.utils.C3P0_Data_Source;
import model.Admin;

public class DB_lookuser {
	public static ArrayList<Admin> user_look(int id) {
		Connection connection = C3P0_Data_Source.getConnection();
		PreparedStatement preparedStatement = null;
		ArrayList<Admin> arr = new ArrayList();
		ResultSet rSet = null;
		try {
			preparedStatement = connection.prepareStatement("select * from   admin where usable=1 and id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Admin ad = new Admin();
				ad.setId(rs.getInt("id"));
				ad.setName(rs.getString("name"));
				arr.add(ad);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			C3P0_Data_Source.release(connection, preparedStatement, rSet);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}
}

package db.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.utils.C3P0_Data_Source;
import model.Admin;

public class DB_update {
	public static boolean update(Admin admin) {
		Connection connection = C3P0_Data_Source.getConnection();// 连接数据库
		PreparedStatement preparedStatement = null;// 预编译数据库语句
		ResultSet rSet = null;// 结果集
		try {
			preparedStatement = connection.prepareStatement("update admin set name=?,password=?,telephone=?,sex=? where id=?;");
			preparedStatement.setString(1,admin.getName());
			preparedStatement.setString(2,admin.getPassword());
			preparedStatement.setString(3,admin.getTelephone());
			preparedStatement.setInt(4,admin.getSex());
			preparedStatement.setInt(5,admin.getId());
			int count = preparedStatement.executeUpdate();
			if (count == 1 )
				return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			C3P0_Data_Source.release(connection, preparedStatement, rSet);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}

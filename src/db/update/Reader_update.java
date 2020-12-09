package db.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.utils.C3P0_Data_Source;

import model.Reader;

public class Reader_update {
	public static boolean update(Reader reader) {
		Connection connection = C3P0_Data_Source.getConnection();// 连接数据库
		PreparedStatement preparedStatement = null;// 预编译数据库语句
		ResultSet rSet = null;// 结果集
		try {
			preparedStatement = connection.prepareStatement("update reader set readername=?,readertelephone=?,readersex=? where readerid=?;");
			preparedStatement.setString(1,reader.getReadername());
			preparedStatement.setString(2,reader.getReadertelephone());
			preparedStatement.setInt(3,reader.getReadersex());
			//preparedStatement.setString(4,reader.getBooknumber());
			preparedStatement.setInt(4,reader.getReaderid());
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

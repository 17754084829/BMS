package db.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.utils.C3P0_Data_Source;
import model.Admin;
import model.Book;

public class Book_update {
	public static boolean update(Book book) {
		Connection connection = C3P0_Data_Source.getConnection();// 连接数据库
		PreparedStatement preparedStatement = null;// 预编译数据库语句
		ResultSet rSet = null;// 结果集
		try {
			//编号(主)，bookid(int)，书名，库存(int)，种类，位置，作者
			preparedStatement = connection.prepareStatement("update book set bookid=?,bookname=?,stock=?,kind=?,location=?,author=? where booknumber=?;");
			preparedStatement.setInt(1,book.getBookid());
			preparedStatement.setString(2,book.getBookname());
			preparedStatement.setInt(3,book.getStock());
			preparedStatement.setString(4,book.getKind());
			preparedStatement.setString(5,book.getLocation());
			preparedStatement.setString(6,book.getAuthor());
			preparedStatement.setString(7,book.getBooknumber());
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
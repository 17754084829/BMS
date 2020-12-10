package db.look;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.utils.C3P0_Data_Source;
import model.Admin;
import model.Book;

public class DB_lookbook {
public static ArrayList<Book> allbook_look() {
		//创建资源链接对象
		Connection connection = C3P0_Data_Source.getConnection();
		PreparedStatement preparedStatement = null;
		ArrayList<Book> arr = new ArrayList();
		ResultSet rSet = null;
		try {
			preparedStatement = connection.prepareStatement("select * from book where stock>0");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Book bo = new Book();
				bo.setBooknumber(rs.getString("booknumber"));
				bo.setBookid(rs.getInt("bookid"));
				bo.setBookname(rs.getString("bookname"));
				bo.setStock(rs.getInt("stock"));
				bo.setKind(rs.getString("kind"));
				bo.setLocation(rs.getString("location"));
				bo.setBookdate(rs.getDate("bookdate"));
				bo.setAuthor(rs.getString("author"));
				arr.add(bo);	
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

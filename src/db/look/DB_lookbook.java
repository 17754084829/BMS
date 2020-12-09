
	package db.look;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;

	import db.utils.C3P0_Data_Source;
	import model.Book;

	public class DB_lookbook {
		public static ArrayList<Book> book_look(int id) {
			Connection connection = C3P0_Data_Source.getConnection();
			PreparedStatement preparedStatement = null;
			ArrayList<Book> arr = new ArrayList();
			ResultSet rSet = null;
			try {
				preparedStatement = connection.prepareStatement("select * from book where usable=1 and id=?");
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					Book ad = new Book();
					ad.setBookid(rs.getInt("bookid"));
					ad.setBookname(rs.getString("bookname"));
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

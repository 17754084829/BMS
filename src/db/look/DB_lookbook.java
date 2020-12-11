package db.look;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.utils.C3P0_Data_Source;
import model.Book;

public class DB_lookbook {
	public static ArrayList<Book> book_look(String booknumber, int bookid,String bookname,String kind,String author) {
		//创建资源链接对象
		Connection connection = C3P0_Data_Source.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
        //用于存储查询的结果的
		ArrayList <Book> arr = new ArrayList<Book>();
        //用于存储查询的条件参数的
        ArrayList list = new ArrayList();
		try {
            //定义sql语句and 1 = 1
            String sql = "select * from book where 1=1";
            
            if (!"".equals(booknumber.trim())){
                sql = sql + " and booknumber = ?";
                list.add(booknumber);
            }
            if (bookid != 0) {
                sql = sql + " and bookid = ?";
                list.add(bookid);
            }
            if (!"".equals(bookname.trim())){
                sql = sql + " and bookname = ?";
                list.add(bookname);
            }
            if (!"".equals(kind.trim())){
                sql = sql + " and kind = ?";
                list.add(kind);
            }
            if(!"".equals(author.trim())) {
           	 sql = sql + " and author = ?";
                list.add(author);
           }

            preparedStatement = connection.prepareStatement(sql);
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    preparedStatement.setObject(i+1,list.get(i));
                }
            }
            
            //执行sql
            rs = preparedStatement.executeQuery();
            
            //遍历查询
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
			e.printStackTrace();
		}
		try {
			C3P0_Data_Source.release(connection, preparedStatement, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}

public static ArrayList<Book> allbook_look() {
		//创建资源链接对象
		Connection connection = C3P0_Data_Source.getConnection();
		PreparedStatement preparedStatement = null;
		ArrayList<Book> arr = new ArrayList();
		ResultSet rSet = null;
		try {
			preparedStatement = connection.prepareStatement("select * from book");
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

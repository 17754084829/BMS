package db.add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.utils.C3P0_Data_Source;
import model.Book;
public class addBook {
	
	public static boolean addbooks(Book book){
		
		Connection conn=C3P0_Data_Source.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet rSet=null;
		try {
			String sql="insert into book(booknumber,bookid,bookname,stock,kind,location,bookdate,author,logo) "
		    		+ "values(?,?,?,?,?,?,?,?,?)";
		    PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, book.getBooknumber());
			pstmt.setInt(2, book.getBookid());
			pstmt.setString(3, book.getBookname());
			pstmt.setInt(4, book.getStock());
			pstmt.setString(5, book.getKind());
			pstmt.setString(6, book.getLocation());
			pstmt.setDate(7, book.getBookdate());
			pstmt.setString(8, book.getAuthor());
			pstmt.setString(9, book.getLogo());
			
			int num= pstmt.executeUpdate();
						
			if(num==1)
		    	return true;
				} catch (Exception e) 
				{
					System.out.println(e.getMessage());
				}
				try {
					C3P0_Data_Source.release(conn, preparedStatement, rSet);
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				return false;
			}
		}
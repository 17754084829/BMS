package db.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.xpath.internal.operations.And;

import db.utils.C3P0_Data_Source;
import model.User;

public class DB_login{
	public static boolean  verify(String username, String passwd) {
		Connection connection=C3P0_Data_Source.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet rSet=null;
		try {
		preparedStatement=connection.prepareStatement("select NAME,PASSWORD from USER WHERE NAME=?");
		preparedStatement.setString(1,username);
		rSet=preparedStatement.executeQuery();
		while (rSet.next()) {
			if(passwd!=null && passwd.equals(rSet.getString("PASSWORD")))
				return true;
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			C3P0_Data_Source.release(connection, preparedStatement, rSet);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static boolean verify(User user) {
		user.getUsername();
		return false;
	}
	public static User getUserBYid(String sid) {
			
		
		return null;
	}
}

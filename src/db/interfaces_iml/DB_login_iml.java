package db.interfaces_iml;

import java.sql.ResultSet;


import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import com.sun.crypto.provider.RSACipher;

import db.interfaces.DB_Login;
import model.User;

public class DB_login_iml  implements DB_Login{
	@Override
	public boolean verify(String username, String passwd) {
		
		return false;
	}
	@Override
	public boolean verify(User user) {
		// TODO Auto-generated method stub
		user.getUsername();
		return false;
	}
	@Override
	public User getUserBYid(String sid) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		User user=null;
		while (resultSet.next()) {
			user=new User();
			user.setUsername(resultSet.getString(columnIndex))
			
		}
		return user;
	}
}

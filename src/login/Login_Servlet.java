package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.bcel.internal.generic.NEW;

import db.interfaces.DB_Login;
import db.interfaces_iml.DB_login_iml;
import jdk.nashorn.internal.runtime.JSONFunctions;
import model.User;

public class Login_Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	DB_Login db_Login= new DB_login_iml();
	User user=new User();
	user.setUsername(username);
	user.setPasswd(passwd);
	boolean b=db_Login.verify(user);
	user Udb_Login.getUserBYid(sid)

	
	
	};
		
	}
	
	
	
	
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}

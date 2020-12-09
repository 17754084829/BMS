package servlet.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.login.DB_login;
import filter.util.Filter_utils;
@WebServlet(name="login_servlet",urlPatterns= {"/login"})
public class Login_Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, String> hashMap=new HashMap<>();
		boolean b=DB_login.verify(req.getParameter("username")==null?"":req.getParameter("username").trim(), req.getParameter("passwd")==null?"":req.getParameter("passwd").trim());
		if(b) {
		hashMap.put("code", "200");
		req.getSession().setAttribute("verify", Filter_utils.getIpAddr(req));
		}else {
			hashMap.put("code", "-1");
		}
		resp.setContentType("application/json");
		PrintWriter printWriter=resp.getWriter();
		printWriter.write(Filter_utils.getJsonString(hashMap));
		printWriter.flush();
		printWriter.close();
	}
	
	
	
	
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}

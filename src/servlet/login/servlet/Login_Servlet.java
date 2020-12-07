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
		String code=req.getParameter("code");
		if(code!=null && code.equalsIgnoreCase((String) req.getSession().getAttribute("code"))) {
		boolean b=DB_login.verify(req.getParameter("username"), req.getParameter("passwd"));
		if(b) {
		hashMap.put("200", "登录成功");
		req.getSession().setAttribute("verify", Filter_utils.getIpAddr(req));
		}else {
			hashMap.put("-1", "账户或密码无效");
		}
		}else {
			hashMap.put("-1", "验证码不正确");
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

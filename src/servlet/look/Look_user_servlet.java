package servlet.look;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.look.DB_lookuser;
import filter.util.Filter_utils;
import model.Admin;

/**
 * Servlet implementation class lookuser
 */

@WebServlet(name = "look_user_servlet", urlPatterns = {"/look_user_servlet" })
public class Look_user_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, Object> hashMap = new HashMap<>();
		Admin admin = new Admin();
		String nmaes=req.getParameter("name");
		int ids=Integer.parseInt(req.getParameter("id"));
		
		/*
		String addtime1 = req.getParameter("addtime");
		Date addtime2 = new SimpleDateFormat("yyyy-MM-dd").parse(addtime1);
		*/
		
		ArrayList<Admin> b = DB_lookuser.user_look(nmaes, ids);
		if (b != null) {
			hashMap.put("200", "查询结果为：");
			req.getSession().setAttribute("verify", Filter_utils.getIpAddr(req));
		} else {
			hashMap.put("-1", "无法查询！");
		}
		hashMap.put("data", b);
		hashMap.put("length", b.size());
		
		resp.setContentType("application/json");
		PrintWriter printWriter = resp.getWriter();
		printWriter.write(Filter_utils.getJsonString(hashMap));
		printWriter.flush();
		printWriter.close();
	}
}

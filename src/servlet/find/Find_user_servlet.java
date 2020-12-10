package servlet.find;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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

@WebServlet(name = "find_user_servlet", urlPatterns = {"/find_user" })
public class Find_user_servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, Object> hashMap = new HashMap<>();
		Admin admin = new Admin();
		String nmaes=req.getParameter("name")==null?"":req.getParameter("name");
		int ids=Integer.parseInt(req.getParameter("id")==null?"0":req.getParameter("id"));
		String addtime1 = req.getParameter("addtime")==null?"0":req.getParameter("addtime");
		Date addtime2=null;
		if(addtime1!="0")
			addtime2 = new Date(Long.parseLong(addtime1));
		
		ArrayList<Admin> b = DB_lookuser.user_look(nmaes, ids,addtime2);
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

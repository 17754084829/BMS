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
@WebServlet(name = "look_user_servlet", urlPatterns = {"/look/look_user_servlet" })
public class Look_user_servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, Object> hashMap = new HashMap<>();
		int m = Integer.parseInt(req.getParameter("id")==null?"0":req.getParameter("id"));
		Admin admin = new Admin();
		admin.setId(m);
		ArrayList<Admin> b = DB_lookuser.user_look(m);
		if (b != null) {
			hashMap.put("200", "1");
			req.getSession().setAttribute("verify", Filter_utils.getIpAddr(req));
		} else {
			hashMap.put("-1", "0");
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

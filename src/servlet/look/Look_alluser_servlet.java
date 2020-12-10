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

@WebServlet(name = "look_alluser_servlet", urlPatterns = {"/look_alluser" })
public class Look_alluser_servlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, Object> hashMap = new HashMap<>();
		ArrayList<Admin> b = DB_lookuser.alluser_look();
		if (b != null) {
			hashMap.put("code", "200");
			req.getSession().setAttribute("verify", Filter_utils.getIpAddr(req));
		} else {
			hashMap.put("code", "-1");
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

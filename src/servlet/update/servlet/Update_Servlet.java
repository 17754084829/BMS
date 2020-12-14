package servlet.update.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.update.DB_update;
import filter.util.Filter_utils;
import model.Admin;

@WebServlet(name = "update_servlet", urlPatterns = { "/update" })
public class Update_Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, String> hashMap = new HashMap<>();
		Admin m = new Admin();
		//id，姓名，密码，电话，性别
		m.setId(Integer.parseInt(req.getParameter("id")==null?"0":req.getParameter("id")));
		m.setName(req.getParameter("name")==null?"xxxx":req.getParameter("name"));
		m.setPassword(req.getParameter("password")==null?"xxxx":req.getParameter("password"));
		m.setTelephone(req.getParameter("telephone")==null?"xxxx":req.getParameter("telephone"));
		m.setSex(Integer.parseInt(req.getParameter("sex")==null?"0":req.getParameter("sex")));
					
		boolean b = DB_update.update(m);
		if (b) {
			hashMap.put("code", "200");
			req.getSession().setAttribute("verify", Filter_utils.getIpAddr(req));
		} else {
			hashMap.put("code", "-1");
		}
		resp.setContentType("application/json");
		PrintWriter printWriter = resp.getWriter();
		printWriter.write(Filter_utils.getJsonString(hashMap));
		printWriter.flush();
		printWriter.close();
	}
}

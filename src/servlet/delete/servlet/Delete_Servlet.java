package servlet.delete.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.delete.DB_delete;
import filter.util.Filter_utils;

@WebServlet(name="delete_servlet",urlPatterns= {"/deleteadmin"})
public class Delete_Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, String> hashMap = new HashMap<>();
		int a=Integer.parseInt(req.getParameter("id"));
		boolean b=DB_delete.verify_delete(a);
		if(b) {
			hashMap.put("code","200");
			req.getSession().setAttribute("verify", Filter_utils.getIpAddr(req));
			}else {
				hashMap.put("code","-1");
		}
		resp.setContentType("application/json");
		PrintWriter printWriter=resp.getWriter();
		printWriter.write(Filter_utils.getJsonString(hashMap));
		printWriter.flush();
		printWriter.close();
	}
}
package servlet.delete.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.delete.DB_deletebook;
import filter.util.Filter_utils;

@WebServlet(name="deletebook_servlet",urlPatterns= {"/deletebook"})
public class Deletebook_Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, String> hashMap = new HashMap<>();
		String a=req.getParameter("booknumber");
		boolean b=DB_deletebook.verify_deletebook(a);
		if(b) {
			hashMap.put("code","200");
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
}

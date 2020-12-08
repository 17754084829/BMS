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

@WebServlet(name="delete_servlet",urlPatterns= {"/delete"})
public class Delete_Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, String> hashMap = new HashMap<>();
		int m=Integer.parseInt(req.getParameter("id"));
		boolean b=DB_delete.verify_delete(m);
		if(b) {
			hashMap.put("200","删除成功");
			req.getSession().setAttribute("verify", Filter_utils.getIpAddr(req));
			}else {
				hashMap.put("-1", "没有删除成功");
		}
		resp.setContentType("application/json");
		PrintWriter printWriter=resp.getWriter();
		printWriter.write(Filter_utils.getJsonString(hashMap));
		printWriter.flush();
		printWriter.close();
	}
}
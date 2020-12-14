package servlet.update.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.update.DB_update;
import db.update.Reader_update;
import filter.util.Filter_utils;
import model.Reader;

@WebServlet(name = "readerupdate_servlet", urlPatterns = { "/update/reader" })
public class ReaderUpdate_Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, String> hashMap = new HashMap<>();
		Reader reader = new Reader();
		//id，姓名，电话，性别，书编号
		reader.setReaderid(Integer.parseInt(req.getParameter("readerid")==null?"0":req.getParameter("readerid")));
		reader.setReadername(req.getParameter("readername")==null?"xxxx":req.getParameter("readername"));
		reader.setReadertelephone(req.getParameter("readertelephone")==null?"xxxx":req.getParameter("readertelephone"));
		reader.setReadersex(Integer.parseInt(req.getParameter("readersex")==null?"0":req.getParameter("readersex")));
		//reader.setBooknumber(req.getParameter("booknumber")==null?"xxxx":req.getParameter("booknumber"));
				
		boolean b = Reader_update.update(reader);
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

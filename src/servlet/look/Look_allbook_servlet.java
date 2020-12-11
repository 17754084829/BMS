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

import db.look.DB_lookbook;
import filter.util.Filter_utils;
import model.Book;

@WebServlet(name = "look_allbook_servlet", urlPatterns = {"/look_allbook" })
public class Look_allbook_servlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Object> hashMap = new HashMap<>();
		ArrayList<Book> b= DB_lookbook.allbook_look();
		if (b != null) {
			hashMap.put("code", "200");
			request.getSession().setAttribute("verify", Filter_utils.getIpAddr(request));
		} else {
			hashMap.put("code", "-1");
		}
		hashMap.put("data", b);
		hashMap.put("length", b.size());
		
		response.setContentType("application/json");
		PrintWriter printWriter = response.getWriter();
		printWriter.write(Filter_utils.getJsonString(hashMap));
		printWriter.flush();
		printWriter.close();
		doGet(request, response);
	}

}

package servlet.find;

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

/**
 * Servlet implementation class Find_book_servlet
 */

@WebServlet(name = "find_book_servlet", urlPatterns = {"/find_book" })
public class Find_book_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Object> hashMap = new HashMap<>();
		Book book = new Book();
		String booknumber=request.getParameter("booknumber")==null?"":request.getParameter("booknumber");
		int bookid=Integer.parseInt(request.getParameter("bookid")==null?"0":request.getParameter("bookid"));
		String bookname=request.getParameter("bookname")==null?"":request.getParameter("bookname");
		String kind=request.getParameter("kind")==null?"":request.getParameter("kind");
		String author=request.getParameter("author")==null?"":request.getParameter("author");
		
		ArrayList<Book> b = DB_lookbook.book_look(booknumber,bookid,bookname,kind,author);
		if (b != null) {
			hashMap.put("200", "查询结果为：");
			request.getSession().setAttribute("verify", Filter_utils.getIpAddr(request));
		} else {
			hashMap.put("-1", "无法查询！");
		}
		hashMap.put("data", b);
		hashMap.put("length", b.size());
		
		response.setContentType("application/json");
		PrintWriter printWriter = response.getWriter();
		printWriter.write(Filter_utils.getJsonString(hashMap));
		printWriter.flush();
		printWriter.close();

	}

}

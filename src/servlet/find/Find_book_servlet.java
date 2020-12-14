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
	protected void doGet(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, Object> hashMap = new HashMap<>();
		Book book = new Book();
		String booknumber=res.getParameter("booknumber")==null?"":res.getParameter("booknumber");
		int bookid=Integer.parseInt(res.getParameter("bookid")==null?"0":res.getParameter("bookid"));
		String bookname=res.getParameter("bookname")==null?"":res.getParameter("bookname");
		String kind=res.getParameter("kind")==null?"":res.getParameter("kind");
		String author=res.getParameter("author")==null?"":res.getParameter("author");
		
		ArrayList<Book> b = DB_lookbook.book_look(booknumber,bookid,bookname,kind,author);
		if (b != null) {
			hashMap.put("code", "200");
			res.getSession().setAttribute("verify", Filter_utils.getIpAddr(res));
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

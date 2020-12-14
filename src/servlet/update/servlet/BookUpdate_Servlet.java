package servlet.update.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.update.Book_update;
import db.update.DB_update;
import filter.util.Filter_utils;
import model.Book;

@WebServlet(name = "bookupdate_servlet", urlPatterns = { "/update/book" })
public class BookUpdate_Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, String> hashMap = new HashMap<>();
		Book book = new Book();
		//编号，bookid(int)，书名，库存(int)，种类，位置，作者
		book.setBooknumber(req.getParameter("booknumber")==null?"xxxx":req.getParameter("booknumber"));
		book.setBookid(Integer.parseInt(req.getParameter("bookid")==null?"0":req.getParameter("bookid")));
		book.setBookname(req.getParameter("bookname")==null?"xxxx":req.getParameter("bookname"));
		book.setStock(Integer.parseInt(req.getParameter("stock")==null?"0":req.getParameter("stock")));
		book.setKind(req.getParameter("kind")==null?"xxxx":req.getParameter("kind"));
		book.setLocation(req.getParameter("location")==null?"xxxx":req.getParameter("location"));
		book.setAuthor(req.getParameter("author")==null?"xxxx":req.getParameter("author"));
		
					
		boolean b = Book_update.update(book);
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


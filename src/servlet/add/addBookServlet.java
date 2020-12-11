package servlet.add;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import db.add.addBook;
import filter.util.Filter_utils;
import model.Book;

@WebServlet(name="addBook_servlet",urlPatterns= {"/add-book"})

public class addBookServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, String> hashMap=new HashMap<>();
		Book book = new Book();
		boolean b=false;
		
		try {
		book.setBooknumber(req.getParameter("booknumber")==null?"xxxx":req.getParameter("booknumber"));
		book.setBookid(Integer.parseInt(req.getParameter("bookid")==null?"0":req.getParameter("bookid")));
		book.setBookname(req.getParameter("bookname")==null?"0":req.getParameter("bookname"));
		book.setStock(Integer.parseInt(req.getParameter("stock")==null?"0":req.getParameter("stock")));
		book.setKind(req.getParameter("kind")==null?"0":req.getParameter("kind"));
		book.setLocation(req.getParameter("location")==null?"0":req.getParameter("location"));
		book.setBookdate(new Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(req.getParameter("bookdate")).getTime()));
		book.setAuthor((req.getParameter("author")==null?"0":req.getParameter("author")));
		book.setLogo((req.getParameter("logo")==null?"0":req.getParameter("logo")));
		b = addBook.addbooks(book);
		if (b) {
			hashMap.put("code", "200");//200:添加书籍成功
			req.getSession().setAttribute("verify", Filter_utils.getIpAddr(req));
		} else {
			hashMap.put("code", "-1");//添加书籍失败
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
        resp.setContentType("application/json; charset=UTF-8");
		PrintWriter printWriter=resp.getWriter();
		printWriter.write(JSON.toJSONString(hashMap));
		printWriter.flush();
		printWriter.close();
	   }
	}



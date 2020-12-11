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

import db.add.addAdmin;
import filter.util.Filter_utils;
import model.Admin;

@WebServlet(name="addadmin_servlet",urlPatterns= {"/add-admin"})
public class addAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, String> hashMap = new HashMap<>();
		Admin admin = new Admin();
		boolean b=false;
		try {
		admin.setName(req.getParameter("name")==null?"xxxx":req.getParameter("name"));
		admin.setPassword(req.getParameter("password")==null?"xxxx":req.getParameter("password"));
		admin.setTelephone(req.getParameter("telephone")==null?"xxxx":req.getParameter("telephone"));
		admin.setSex(Integer.parseInt(req.getParameter("sex")==null?"0":req.getParameter("sex")));
		
		admin.setAddtime(new Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(req.getParameter("addtime")).getTime()));
		admin.setRoles(Integer.parseInt(req.getParameter("roles")==null?"0":req.getParameter("roles")));
		admin.setUsable(Integer.parseInt(req.getParameter("usable")==null?"0":req.getParameter("usable")));
		
		b = addAdmin.verify_add(admin);
		if (b) {
			hashMap.put("code", "200");//200:添加成功
			req.getSession().setAttribute("verify", Filter_utils.getIpAddr(req));
		} else {
			hashMap.put("code", "-1");//添加失败
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("application/json");
		PrintWriter printWriter = resp.getWriter();
		printWriter.write(Filter_utils.getJsonString(hashMap));
		printWriter.flush();
		printWriter.close();
	}
}

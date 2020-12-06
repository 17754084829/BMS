package filter.login.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import filter.util.Filter_utils;


//过滤器,判断进入管理页面的请求是否合法
@WebFilter(filterName="login_filter",urlPatterns= {"/admin/*"})
public class Login_filter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2=(HttpServletRequest) request;
		HttpSession session=request2.getSession();
		String s_ip=(String)session.getAttribute("verify");
		if(null!=s_ip && s_ip.equals(Filter_utils.getIpAddr(request2)))
			chain.doFilter(request2, response);
		else {
			response.setContentType("application/json");
			PrintWriter print=response.getWriter();
			HashMap<String, String> hashMap=new HashMap<>();
			hashMap.put("code", "403");
			hashMap.put("msg", "非法用户");
			print.write(Filter_utils.getJsonString(hashMap));
			print.flush();
			print.close();
		}
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}

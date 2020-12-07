package filter.character.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//处理数据乱码问题
@WebFilter(filterName="character",urlPatterns= {"/*"})
public class Character_filter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2=(HttpServletRequest) request;
		if("POST".equals(request2.getMethod())) {
			request.setCharacterEncoding("UTF-8");
		
		}
		response.setCharacterEncoding("UTF-8");
		System.out.println("字符处理完成");
		chain.doFilter(request2, response);		
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("db.utils.C3P0_Data_Source");
			System.out.println("数据库连接池启动");
			}catch (Exception e) {
				System.out.println("数据库连接池失败");
			}
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

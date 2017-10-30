/**
 * Copyright (C), 2013, 山东安之畅智能交通科技有限公司
 * All right reserved.
 */
package ujn.school.cn.pub.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年10月30日 下午3:08:05
 * @version V1.0
 */
public class XssFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);
		chain.doFilter(xssRequest, response);
	}
	@Override
	public void destroy() {
	}
}

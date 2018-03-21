package com.catike_mall.catike_security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @disc Access Security Filter
 * 
 * @author Ma Xuefeng
 * @date 2017Äê6ÔÂ11ÈÕ
 * @version v1.0.0
 */

public class AccessSecurityFilter implements Filter {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private FilterChain chain;
	private HttpSession session;

	public AccessSecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Access Security Filter : doFilter
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		doFilter_First(arg0, arg1, arg2);

		if (isInProtect() && isSessionInvalid()) {
			request.getRequestDispatcher(loginPagePath()).forward(request, response);
		}

		chain.doFilter(request, response);
	}

	/*
	 * @Note Judge the Session is Invalid
	 * 
	 * @return Is Invalid - true Not Invalid - false
	 */
	private boolean isSessionInvalid() {

		if (session.isNew() || session.getAttribute("user.PkId") == null
				|| ((Integer) session.getAttribute("user.PkId")).intValue() == -1) {
			return true;
		}

		return false;
	}

	/*
	 * @Note Judge the RequestPath if in the Protect Path
	 * 
	 * @return Is in Protect Path - true Not in Protect Path - false
	 */
	private boolean isInProtect() {

		String servletPath = "";
		if (request.getServletPath() != null) {
			servletPath = request.getServletPath();
		}

		List<String> protectPathList = new ArrayList<String>();
		addProtectPath(protectPathList);

		for (String protectPath : protectPathList) {
			if (servletPath.equals(protectPath))
				return true;
		}

		return false;
	}

	/*
	 * Initilize the Filter
	 */
	private void doFilter_First(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) {
		this.request = (HttpServletRequest) arg0;
		this.response = (HttpServletResponse) arg1;
		this.chain = arg2;

		this.session = request.getSession();
	}

	/*
	 * the Login Page Path
	 */
	private String loginPagePath() {

		String loginPath = "/user/loginpage.shopping";

		return loginPath;
	}

	/*
	 * Add Protect Path
	 */
	private void addProtectPath(List<String> protectPathList) {
		protectPathList.add("/5.shopping");
	}

}

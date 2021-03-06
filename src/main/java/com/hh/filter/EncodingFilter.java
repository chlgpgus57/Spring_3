package com.hh.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**

 * Servlet Filter implementation class EncodingFilter

 */

public class EncodingFilter implements Filter {


	private String encode;
    /**

     * Default constructor. 

     */
    public EncodingFilter() {

        // TODO Auto-generated constructor stub

    }

	/**

	 * @see Filter#destroy()

	 */

	public void destroy() {

		// Filter 객체가 없어질 때 실행하는 메서드

	}

	/**

	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)

	 */

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// request 발생시 실행하는 구간

		request.setCharacterEncoding(this.encode);
		response.setCharacterEncoding(this.encode);
		System.out.println("Filter In");
		// place your code here
		// pass the request along the filter chain
		chain.doFilter(request, response);
		// response 발생시 실행하는 구간
		System.out.println("Filter Out");

	}


	/**

	 * @see Filter#init(FilterConfig)

	 */

	public void init(FilterConfig fConfig) throws ServletException {

		// 객체가 생성되고 나서 실행하는 초기화 메서드
		this.encode = fConfig.getInitParameter("encode");

	}



}
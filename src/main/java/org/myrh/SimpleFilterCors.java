/*package org.myrh;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleFilterCors  implements Filter{
	private static final Logger log=LoggerFactory.getLogger( SimpleFilterCors.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("Initialisation du logger!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requestToUse=(HttpServletRequest) request;
		HttpServletResponse responseToUse=(HttpServletResponse) response;
		responseToUse.setHeader("Access-Control-Allow-Origin", requestToUse.getHeader("Origin"));
		chain.doFilter(requestToUse, responseToUse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}*/

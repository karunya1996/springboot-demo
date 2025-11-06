package com.example.demo.filter;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class RequestFilter implements Filter{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException {
		jakarta.servlet.http.HttpServletRequest req =(HttpServletRequest) request;
		System.out.println("[Filter] Request URL: "+req.getRequestURI());
		chain.doFilter(request, response);
	}

	@Override
	public boolean isLoggable(LogRecord record) {
		// TODO Auto-generated method stub
		return false;
	}

}

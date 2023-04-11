package com.discovermarket.claimservice.configs;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import com.discovermarket.core.models.RequestCorrelation;

@Component
public class RequestFilter implements Filter{

	public static final String REQUEST_HEADER_NAME = "X-REQUEST-UUID";
	public static final String REQUEST_AUTHORIZATION = "authorization";
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String id = httpServletRequest.getHeader(REQUEST_HEADER_NAME);
        String token = httpServletRequest.getHeader(REQUEST_AUTHORIZATION);
        if (id == null || "".equals(id)) {
            id = UUID.randomUUID().toString();
        }
 
        //RequestContext.getContext().setId(id);
        RequestCorrelation.setId(id);
        RequestCorrelation.setToken(token);
        MDC.put("requestId", id);
		chain.doFilter(request, response);
		MDC.clear();
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Just Empty
	}
	
	@Override
	public void destroy() {
		// Just Empty
	}

}
package com.stack.engine.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		   final String header = httpServletRequest.getHeader("authorization");
	        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
	            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
	        } else {
	            if (header == null || !header.startsWith("Bearer")) {
	                throw new ServletException("Missing or Invalid authorization header");
	            }
	            final String token = header.substring(7);
	            final Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
	            httpServletRequest.setAttribute("claims", claims);
	        }
	        filterChain.doFilter(httpServletRequest, httpServletResponse);

	}
  }

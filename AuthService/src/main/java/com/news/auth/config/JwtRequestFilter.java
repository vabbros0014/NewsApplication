package com.news.auth.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.news.auth.Util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);
   
    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired 
    private MyUserDetailsService userDetailServie;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

        String authorizationToken = request.getHeader("Authorization");
        String userName = null;
        String token = null;
        if (authorizationToken != null && authorizationToken.startsWith("Bearer")) {
            token = authorizationToken.substring(7);
            try {
                userName = jwtTokenUtil.extractUsername(token);
            } catch (IllegalArgumentException | ExpiredJwtException exception) {
                logger.error(exception.getMessage());
            }
        } else {
            logger.warn("JWT token does not begin with Bearer");
        }
        // Validate token
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailServie.loadUserByUsername(userName);
            boolean tokenStatus = jwtTokenUtil.validateToken(token, userDetails);
            // if tokenStatus => true, configure spring security to manually set authorization
            if (tokenStatus) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
        }
        filterChain.doFilter(request, response);
		
	}
}

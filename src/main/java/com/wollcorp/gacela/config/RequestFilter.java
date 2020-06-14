package com.wollcorp.gacela.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wollcorp.gacela.util.JwtToken;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtToken jwtToken;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		String username = null;
		String token = null;
		
		if (requestTokenHeader != null) {
			
			token = requestTokenHeader;
			
			try {
				
				username = this.jwtToken.obtenerUsuario(token);
				
			} catch (IllegalArgumentException e) {
				
				// System.out.println("Unable to get JWT Token");
				log.error("Unable to get JWT Token");
				
			} catch (ExpiredJwtException e) {
				
				// System.out.println("JWT Token has expired");
				log.error("JWT Token has expired");
				
			}
		} else {
			
			log.warn("JWT Token does not begin with Bearer String");
			
		}
		
		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			
			// if token is valid configure Spring Security to manually set
			// authentication
			if (this.jwtToken.validateToken(token, userDetails)) {
				
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
																	userDetails,
																	null,
																	userDetails.getAuthorities()
																);
				
				auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		chain.doFilter(request, response);
	}

}

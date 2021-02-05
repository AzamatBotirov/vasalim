package com.salom.vasalim.security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtTokenFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
      if(token !=null && jwtTokenProvider.validityToken(token) ){
          Authentication authentication = jwtTokenProvider.getAuthentication(token);
      }
    }
}

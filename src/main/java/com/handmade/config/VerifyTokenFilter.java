package com.handmade.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;

import io.jsonwebtoken.JwtException;
import com.handmade.identity.TokenUtil;

/*
This filter checks if there is a token in the Request service header and the token is not expired
it is applied to all the routes which are protected
*/
public class VerifyTokenFilter extends GenericFilterBean {

    private final TokenUtil tokenUtil;
    RequestMatcher myMatcher = new AntPathRequestMatcher("/api/**");
    //private AuthenticationFailureHandler loginFailureHandler = new SimpleUrlAuthenticationFailureHandler();

    public VerifyTokenFilter(TokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest  request  = (HttpServletRequest)  req;
        HttpServletResponse response = (HttpServletResponse) res;
        if (myMatcher.matches(request)) {
            try {
                Optional<Authentication> authentication = tokenUtil.verifyToken(request);
                if (authentication.isPresent() && authentication.get().isAuthenticated()) {
                    SecurityContextHolder.getContext().setAuthentication(authentication.get());
                    filterChain.doFilter(req, res);
                } else {
                    SecurityContextHolder.getContext().setAuthentication(null);
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                }
            } catch (JwtException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            } finally {
                SecurityContextHolder.getContext().setAuthentication(null);
            }
        }
        else {
            filterChain.doFilter(req, res);
        }
    }

}

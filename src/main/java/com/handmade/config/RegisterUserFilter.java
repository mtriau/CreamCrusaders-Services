package com.handmade.config;

import com.handmade.dao.UserDAOImpl;
import com.handmade.model.RestfulResponse;
import com.handmade.model.User;
import com.handmade.services.UserService;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.transaction.Transactional;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import com.fasterxml.jackson.databind.*;

import io.jsonwebtoken.JwtException;
import com.handmade.identity.TokenUtil;

public class RegisterUserFilter extends GenericFilterBean {

    private UserService userService;

    RequestMatcher myMatcher = new AntPathRequestMatcher("/register");
    //private AuthenticationFailureHandler loginFailureHandler = new SimpleUrlAuthenticationFailureHandler();

    public RegisterUserFilter(UserService userService) { this.userService = userService; }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest  request  = (HttpServletRequest)  req;
        HttpServletResponse response = (HttpServletResponse) res;
        if (myMatcher.matches(request)) {
            String jsonString = IOUtils.toString(request.getInputStream(), "UTF-8");
            JSONObject userJSON = new JSONObject(jsonString);
            String username = userJSON.getString("username");
            String password = userJSON.getString("password");
            User user = new User(username, password, "fname", "lname");
            this.userService.addNewUser(user);

            RestfulResponse resp = new RestfulResponse();
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

            resp.setSuccess(true);
            resp.setMessage("Register Success");

            String jsonRespString = ow.writeValueAsString(resp);

            res.getWriter().write(jsonRespString);
            //res.getWriter().write(jsonResp.toString());
            res.getWriter().flush();
            res.getWriter().close();
        }
        else {
            filterChain.doFilter(req, res);
        }
    }
}

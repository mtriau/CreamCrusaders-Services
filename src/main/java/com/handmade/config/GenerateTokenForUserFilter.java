package com.handmade.config;

import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.*;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.json.*;

import com.handmade.identity.*;
import com.handmade.model.RestfulResponse;
import com.handmade.model.SessionItem;
import com.fasterxml.jackson.databind.*;


/* This filter maps to /session and tries to validate the username and password */
public class GenerateTokenForUserFilter extends AbstractAuthenticationProcessingFilter {

    private TokenUtil tokenUtil;

    protected GenerateTokenForUserFilter(String urlMapping, AuthenticationManager authenticationManager, TokenUtil tokenUtil) {
        super(new AntPathRequestMatcher(urlMapping));
        setAuthenticationManager(authenticationManager);
        this.tokenUtil = tokenUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException, JSONException {
        try{
            Logger log = Logger.getLogger("LoginRequest");
            String jsonString = IOUtils.toString(request.getInputStream(), "UTF-8");
            log.info(jsonString);
            /* using org.json */
            JSONObject userJSON = new JSONObject(jsonString);
            String username = userJSON.getString("username");
            String password = userJSON.getString("password");
            log.info(username);
            log.info(password);
            //final UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken("demo", "demo");
            final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
            return getAuthenticationManager().authenticate(authToken); // This will take to successfulAuthentication or faliureAuthentication function
        }
        catch( JSONException | AuthenticationException e){
            throw new AuthenticationServiceException(e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication ( HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication authToken) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authToken);
        /*
        JSONObject jsonResp = new JSONObject();
        TokenUser tokenUser = (TokenUser)authToken.getPrincipal();
        String newToken = this.tokenUtil.createTokenForUser(tokenUser);
        jsonResp.put("token",newToken);
        jsonResp.put("firstName",tokenUser.getUser().getFirstName());
        jsonResp.put("lastName",tokenUser.getUser().getLastName());
        jsonResp.put("email",tokenUser.getUser().getEmail());
        jsonResp.put("role",tokenUser.getRole());
        */
        TokenUser tokenUser = (TokenUser)authToken.getPrincipal();
        RestfulResponse resp = new RestfulResponse();
        SessionItem respItem = new SessionItem();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String tokenString = this.tokenUtil.createTokenForUser(tokenUser);

        respItem.setFirstName(tokenUser.getUser().getFirstName());
        respItem.setLastName(tokenUser.getUser().getLastName());
        respItem.setUserId(String.valueOf(tokenUser.getUser().getUserId()));
        respItem.setEmail(tokenUser.getUser().getEmail());
        respItem.setToken(tokenString);

        resp.setSuccess(true);
        resp.setMessage("Login Success");

        resp.setData(respItem);
        String jsonRespString = ow.writeValueAsString(resp);

        res.setStatus(HttpServletResponse.SC_OK);
        res.getWriter().write(jsonRespString);
        //res.getWriter().write(jsonResp.toString());
        res.getWriter().flush();
        res.getWriter().close();

        // DONT call supper as it contine the filter chain super.successfulAuthentication(req, res, chain, authResult);
    }
}

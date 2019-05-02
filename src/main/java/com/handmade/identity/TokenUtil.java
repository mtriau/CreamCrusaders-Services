package com.handmade.identity;

import com.handmade.dao.UserDAOImpl;
import com.handmade.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.handmade.model.User;

import io.jsonwebtoken.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.logging.Logger;


@Service
public class TokenUtil {

    //private static final long VALIDITY_TIME_MS = 10 * 24 * 60 * 60 * 1000;// 10 days Validity
    private static final long VALIDITY_TIME_MS =  60 * 60 * 1000; // 2 hours  validity
    private static final String AUTH_HEADER_NAME = "Authorization";

    @Autowired
    private UserRepository userRepo;

    private String secret="dontlookatme";

    public Optional<Authentication> verifyToken(HttpServletRequest request) {
      final String token = request.getHeader(AUTH_HEADER_NAME);
      if (token != null && !token.isEmpty()) {
          final TokenUser user = parseUserFromToken(token.replace("Bearer", "").trim());
          Gson gson = new Gson();
          long validTime = user.getCreateDate().getTime() + VALIDITY_TIME_MS;
          if (user == null) {
              return Optional.empty();
          }
          else if (user.getCreateDate().getTime() > validTime) {
              return Optional.empty();
          }
          else if (user.isClaimed()) {
              System.out.println("User is claimed");
          }
          if (user != null && userRepo.getUserByUserName(user.getUsername()) != null) {
              return Optional.of(new UserAuthentication(user));
          }
      }
      return Optional.empty();

    }

    //Get User Info from the Token
    public TokenUser parseUserFromToken(String token){

        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        User user = new User();
        user.setUserName( (String)claims.get("userName"));
        user.setUserId((Integer) claims.get("userId"));
        List<String> roles = (List<String>)claims.get("role");
        if (user.getUserName() != null && roles != null) {
            try {
                TokenUser t = new TokenUser(user, roles);
                t.setCreateDate(new Date((long)claims.get("createDate")));
                t.setClaimed((boolean)claims.get("claimed"));
                return t;

            }
            catch(Exception e){
                e.printStackTrace();
            }
            return new TokenUser(user);
        } else {
            return null;
        }
    }

    public static Integer getUserId(HttpServletRequest request){
        final String token = request.getHeader(AUTH_HEADER_NAME);
        Claims claims = Jwts.parser()
                .setSigningKey("mrin")
                .parseClaimsJws(token)
                .getBody();

        return (Integer)claims.get("userId");

    }
    public static String getUserName(HttpServletRequest request){
        final String token = request.getHeader(AUTH_HEADER_NAME);
        Claims claims = Jwts.parser()
                .setSigningKey("mrin")
                .parseClaimsJws(token)
                .getBody();

        return (String)claims.get("userName");

    }

    public String createTokenForUser(TokenUser tokenUser) {
      return createTokenForUser(tokenUser.getUser());
    }

    public String createTokenForUser(User user) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + VALIDITY_TIME_MS))
                .setSubject(user.getFirstName() + user.getLastName())
                .claim("userName", user.getUserName())
                .claim("userId", user.getUserId())
                .claim("role", AuthUtil.getRoles(user.getRoles()))
                .claim("createDate", System.currentTimeMillis())
                .claim("claimed", false)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

}

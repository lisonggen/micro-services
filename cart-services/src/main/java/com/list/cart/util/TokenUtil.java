package com.list.cart.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-16 16:46
 **/
public class TokenUtil {

    private static final String SECRET_KEY = "v9zKt!Q@C$kV!bY8fTz3Nd7LuPmX1aG4";

    /**
     * 解码 JWT token
     */
    public static Map<String, String> decodeToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);

            Map<String, String> map = new HashMap<>();
            map.put("username", jwt.getClaim("username").asString());
            map.put("uid", jwt.getClaim("uid").asString());
            map.put("role", jwt.getClaim("role").asString());
            return map;
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    /**
     * 从上下文中获取用户信息（从 token 中解析）
     */
    public static Map<String, String> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) return null;

        // Spring Security 会将 JWT 中的 claims 封装到 principal 中
        Object principal = authentication.getPrincipal();
        if (principal instanceof Jwt) {
            Jwt jwt = (Jwt) principal;
            Map<String, String> map = new HashMap<>();
            map.put("username", jwt.getClaim("username"));
            map.put("uid", jwt.getClaim("uid"));
            map.put("role", jwt.getClaim("role"));
            return map;
        }

        return null;
    }
}

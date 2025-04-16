package com.lisg.user.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import model.entity.User;

import java.util.Date;
import java.util.HashMap;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-11 16:35
 **/
public class JwtTokenUtils {

    // 过期时间
    private static final int EXPIRE_TIME = 24 * 60 * 60 * 1000;
    // 加密的密钥
    private static final String SECRET_KEY = "v9zKt!Q@C$kV!bY8fTz3Nd7LuPmX1aG4";

    public static String sign(User user) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        HashMap<String, Object> head = new HashMap<String, Object>();
        head.put("typ", "JWT");
        head.put("alg", "HS256");

        // 这块是 JWT 认证的一些声明信息
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        return JWT.create()
                .withHeader(head)
                .withClaim("uid", user.getUid())  // 把用户名整合到 token 里加密
                .withClaim("username", user.getUsername())
                .withClaim("role", user.getRole())
                .withExpiresAt(date).sign(algorithm);
    }

    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (IllegalArgumentException | JWTVerificationException e) {
            return false;
        }
    }

    public static User analyzeToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        User user = new User(jwt.getClaim("id").asString(),
                jwt.getClaim("username").asString(),
                jwt.getClaim("role").asString());
        return user;
    }
}

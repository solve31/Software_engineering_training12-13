package com.example01.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
//JTW生成工具类
public class JwtUtils {
    //七天过期
    private static long expire=604800;
    //32位密钥
    private static String secret="abcdefghijklmnopqrstuvwsyzabcefgh";
    //生成token
    public static String generateToken(String username){
        Date now=new Date();
        Date expiration=new Date(now.getTime()+1000*expire);
        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }
    //解析token
    public static Claims getClaimsByToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}

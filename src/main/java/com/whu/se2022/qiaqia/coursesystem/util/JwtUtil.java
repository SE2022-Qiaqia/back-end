package com.whu.se2022.qiaqia.coursesystem.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ConfigurationProperties(prefix="jwt")
public class JwtUtil {

    //定义token返回头部
    public static String header;

    //token前缀
    public static String tokenPrefix;

    //签名密钥
    public static String secret;

    //有效期
    public static long expireTime;

    //存进客户端的token的key名
    public static final String USER_LOGIN_TOKEN = "USER_LOGIN_TOKEN";


    public void setHeader(String header) {
        JwtUtil.header = header;
    }

    public void setTokenPrefix(String tokenPrefix) {
        JwtUtil.tokenPrefix = tokenPrefix;
    }

    public void setSecret(String secret) {
        JwtUtil.secret = secret;
    }

    public void setExpireTime(int expireTimeInt) {
        JwtUtil.expireTime = expireTimeInt*1000L*60;
    }

    //创建token
    public static String createToken(Long id){
        return tokenPrefix + JWT.create()
                .withClaim("id",id)//payload
                .withExpiresAt(new Date(System.currentTimeMillis() + expireTime))
                .sign(Algorithm.HMAC512(secret));//signature
    }

    //验证token
    public static Long validateToken(String token){
        try {
            return JWT.require(Algorithm.HMAC512(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""))
                    .getClaim("id").asLong();
        } catch (Exception e){
            //TODO
            return 0L;
        }
    }

    //检查token是否需要更新
    public static boolean isNeedUpdate(String token){
        //获取token过期时间
        Date expiresAt = null;
        try {
            expiresAt = JWT.require(Algorithm.HMAC512(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""))
                    .getExpiresAt();
        } catch (TokenExpiredException e){
            return true;
        }
        //如果剩余过期时间少于过期时常的一般时 需要更新
        return (expiresAt.getTime()-System.currentTimeMillis()) < (expireTime>>1);
    }
}

package com.pojo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

    public static String SECRET = "SDFEEdfdeFDRE";
    
    public static String createToken(String userId,String userName) throws Exception {

        System.out.println("拦截器里传递的值userId的值为：   "+userId);
        System.out.println("拦截器里传递的值userName的值为：   "+userName);

        //签发时间
//      Date istDate = new Date();

        //设置过期时间
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 24*60*30);
        Date expiresDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        String token = JWT.create()
                .withHeader(map)
                .withClaim("name", "token")
                .withClaim("id", userId)
                .withClaim("username",userName)
                .withExpiresAt(expiresDate)
//                .withIssuedAt(istDate)
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }


    public static Map<String, Claim> verifyToken(String token) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
        } catch (Exception e) {
            throw new RuntimeException("凭证过期！");
        }

        return jwt.getClaims();
    }



//    public static void main(String[] args) throws Exception {
//        String userId = null;
//        String token = JwtTokenUtil.createToken(userId);
//
//        System.out.println("  生成token值：   "+token+"   token位数： "+token.length());
//        //正常测试
//        Map<String, Claim> verifyToken = JwtTokenUtil.verifyToken(token);
//        String asString = verifyToken.get("name").asString();
//        System.out.println(" 验证token值    "+asString);
//
//        //过期测试
//        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoidGVzdCIsImV4cCI6MTUyNzQ5NzA3MiwiaWF0IjoxNTI3NDk3MDExLCJhZ2UiOjExfQ.yg1Hn4FT0OWu8KecNzvaayMEbbDrKctjWlI4bblcRfA";
//        Map<String, Claim> verifyToken2 = JwtTokenUtil.verifyToken(token);
//    }
}

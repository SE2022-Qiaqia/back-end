package com.whu.se2022.qiaqia.coursesystem.config;




import com.whu.se2022.qiaqia.coursesystem.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //http的header中获得token
        String token = request.getHeader("token");
        //token不存在
        if (token == null || token.equals("")) throw new RuntimeException("用户未登录");
        //验证token
        Long id = JwtUtil.validateToken(token);
        if (id == null || id==0L)
            throw new RuntimeException("token无效");


        //更新token有效时间 (如果需要更新其实就是产生一个新的token)
        if (JwtUtil.isNeedUpdate(token)){
            String newToken = JwtUtil.createToken(id);
            response.setHeader("token",token);
        }
        return true;
    }
}

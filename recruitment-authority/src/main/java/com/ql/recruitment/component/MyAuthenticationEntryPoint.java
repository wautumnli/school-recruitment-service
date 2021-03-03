package com.ql.recruitment.component;

import com.alibaba.fastjson.JSON;
import com.ql.recruitment.result.R;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/3 13:49
 * 访问接口发现无token，或者处于未登录状态，错误信息返回
 */
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSON.toJSONString(R.unAuthorized()));
        response.getWriter().flush();
    }
}

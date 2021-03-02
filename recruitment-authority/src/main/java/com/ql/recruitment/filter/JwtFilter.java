package com.ql.recruitment.filter;

import cn.hutool.core.util.StrUtil;
import com.ql.recruitment.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/1 13:51
 * JWT过滤器，对所有请求进行认证
 */
public class JwtFilter extends OncePerRequestFilter {

    // 携带token的头名
    @Value("${authority.headName}")
    private String headName;

    /**
     * token形式: tokenHead token
     * tokenHead有签名和未签名方式
     */
    @Value("${authority.tokenHead}")
    private String tokenHead;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String header = request.getHeader(headName);
        if (header != null && !StrUtil.hasBlank(header)) {
            String[] array = header.split(" ");
            if (array.length == 2 && StrUtil.equals(tokenHead, array[0])) {
                String token = array[1];
                String username = jwtUtil.getUserNameFromToken(token);
                if (!StrUtil.hasEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    if (jwtUtil.validateToken(token, userDetails)) {
                        UsernamePasswordAuthenticationToken authenticationToken =
                                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }
            }
        }
        chain.doFilter(request, response);
    }
}

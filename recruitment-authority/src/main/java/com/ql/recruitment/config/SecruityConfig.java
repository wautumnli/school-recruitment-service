package com.ql.recruitment.config;

import com.ql.recruitment.entity.authority.SysUser;
import com.ql.recruitment.component.SysUserDetails;
import com.ql.recruitment.filter.JwtFilter;
import com.ql.recruitment.service.SysUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/1 14:30
 * 权限安全设置
 */
@Configuration
@EnableWebSecurity
public class SecruityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private SysUserService sysUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    /***
     * 1.因为是基于token的，所以不需要csrf和session
     * 2.对除了登录注册接口外，其他都需要权限校验
     * 3.在发送POST请求时，会先发送一次OPTIONS请求
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated();

        http.headers().cacheControl();
        http.addFilterAfter(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return phone -> {
            SysUser sysUser = sysUserService.getUserFromPhone(phone);
            if (sysUser != null) {
                return new SysUserDetails(sysUser);
            }
            return null;
        };
    }
}

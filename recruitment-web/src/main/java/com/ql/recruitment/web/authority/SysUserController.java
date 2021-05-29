package com.ql.recruitment.web.authority;

import com.ql.recruitment.dto.authority.SysUserDto;
import com.ql.recruitment.result.R;
import com.ql.recruitment.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/1 16:34
 * 用户登录权限认证
 */
@Controller
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @PostMapping("/login")
    @ResponseBody
    public R login(@RequestBody SysUserDto sysUserDto) {
        Map<String, Object> result = sysUserService.login(sysUserDto);
        return R.ok().setData(result);
    }

    @PostMapping("/apply")
    @ResponseBody
    public R apply(@RequestBody SysUserDto sysUserDto) {
        return R.ok().setData(Collections.singletonMap("res", sysUserService.applyUser(sysUserDto)));
    }

}

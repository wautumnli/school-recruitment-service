package com.ql.recruitment.web.master;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ql.recruitment.dto.master.UserInfoDto;
import com.ql.recruitment.entity.master.RecruitM;
import com.ql.recruitment.entity.master.UserInfo;
import com.ql.recruitment.result.R;
import com.ql.recruitment.service.UserInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wautumnli
 * @date: 2021-05-19 05:26
 **/
@RestController
@RequestMapping("/info")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/userinfod")
    public R userInfoD(@RequestBody UserInfoDto userInfoDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("userinfo",userInfoService.getUserInfoD(userInfoDto));
        return R.ok().data(result);
    }

    @PostMapping("/update")
    public R update(@RequestBody UserInfoDto userInfoDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("update",userInfoService.updateUserInfo(userInfoDto));
        return R.ok().data(result);
    }

    @PostMapping("/home")
    public R home(@RequestBody UserInfoDto userInfoDto) {
        Map<String, Object> result = new HashMap<>();
        Page<UserInfo> page = new Page<UserInfo>(userInfoDto.getPageNum(),userInfoDto.getPageSize());
        result.put("userInfoList", userInfoService.getUserInfo(page, userInfoDto));
        return R.ok().data(result);
    }

    @PostMapping("/delete")
    public R delete(@RequestBody UserInfoDto userInfoDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("delete", userInfoService.deleteUser(userInfoDto));
        return R.ok().data(result);
    }

    @PostMapping("/check")
    public R check(@RequestBody UserInfoDto userInfoDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("check", userInfoService.checkUser(userInfoDto));
        return R.ok().data(result);
    }

    @PostMapping("/reject")
    public R reject(@RequestBody UserInfoDto userInfoDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("reject", userInfoService.checkUser(userInfoDto));
        return R.ok().data(result);
    }

    @PostMapping("/add")
    public R add(@RequestBody UserInfoDto userInfoDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("add", userInfoService.addUser(userInfoDto));
        return R.ok().data(result);
    }
}

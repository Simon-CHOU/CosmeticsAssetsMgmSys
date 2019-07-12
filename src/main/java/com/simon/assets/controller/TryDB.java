package com.simon.assets.controller;


import com.simon.assets.comm.Result;
import com.simon.assets.dao.UserMapper;
import com.simon.assets.entity.SysUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TryDB {
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "获取用户列表", notes = "")
    @GetMapping(value = "/userlist")
    public Result testSelect() {
        System.out.println(("----- selectAll method test ------"));
        System.out.println(userMapper);
        List<SysUser> sysUserList = userMapper.selectAll();
        System.out.println(sysUserList);
        sysUserList.forEach(System.out::println);
        return Result.success(sysUserList);
    }

}

package com.simon.assets;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simon.assets.dao.UserMapper;
import com.simon.assets.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectList method test ------"));
        System.out.println(userMapper);
        List<SysUser> sysUserList = userMapper.selectList(null);
        System.out.println(sysUserList);
        Assert.assertEquals(5, sysUserList.size());
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void selectPage() {
        IPage<SysUser> page = new Page<SysUser>(1,3);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>();
        queryWrapper.eq("age",20);// 设置where 条件 https://mybatis.plus/guide/wrapper.html

        IPage<SysUser> iPage  = userMapper.selectPage(page, queryWrapper);
        System.out.println("总页数："+ iPage.getPages());
        System.out.println("总记录数："+ iPage.getTotal());
        List<SysUser> userList = iPage.getRecords();
        userList.forEach(System.out::println);
    }

}
package com.simon.assets;


import com.simon.assets.dao.UserMapper;
import com.simon.assets.entity.SysUser;
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

}
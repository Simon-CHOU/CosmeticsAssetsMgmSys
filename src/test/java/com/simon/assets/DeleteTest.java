package com.simon.assets;

import com.simon.assets.dao.UserMapper;
import com.simon.assets.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUpdate() {
        SysUser sysUser = new SysUser();
        sysUser.setId(6L);
        sysUser.setAge(2);
        sysUser.setEmail("9999@fox.com");
        sysUser.setName("Nick");

        System.out.println(("----- delete method test ------"));
//        Integer ii  = userMapper.deleteById(sysUser.getId());
//        System.out.println(ii);
//        Assert.assertEquals(1, ii.intValue());
//        sysUserList.forEach(System.out::println);
    }
}

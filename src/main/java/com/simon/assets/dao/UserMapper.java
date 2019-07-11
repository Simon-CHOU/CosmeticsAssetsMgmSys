package com.simon.assets.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simon.assets.entity.SysUser;

import java.util.List;


public interface UserMapper extends BaseMapper<SysUser> {
    List<SysUser> selectAll();
}
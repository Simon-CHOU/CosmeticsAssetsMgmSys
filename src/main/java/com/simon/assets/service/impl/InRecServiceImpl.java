package com.simon.assets.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simon.assets.dao.InRecMapper;
import com.simon.assets.entity.InRec;
import com.simon.assets.service.InRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InRecServiceImpl implements InRecService {

    @Autowired
    private InRecMapper inRecMapper;

    @Override
    public List<InRec> findListAll() {
        return inRecMapper.selectList(null);
    }

    @Override
    public InRec findById(Integer id) {
        return inRecMapper.selectById(id);
    }

    @Override
    @Transactional
    public Integer insert(InRec inRec) {
        return inRecMapper.insert(inRec);
    }

    @Override
    @Transactional
    public Integer updateById(InRec inRec) {
        return inRecMapper.updateById(inRec);
    }

    @Override
    @Transactional
    public Integer deleteById(Integer id) {
        return inRecMapper.deleteById(id);
    }

    @Override
    public List<InRec> findPage(Integer current, Integer size) {
        IPage<InRec> page = new Page<InRec>(current,size);
        QueryWrapper<InRec> queryWrapper = new QueryWrapper<InRec>();

        IPage<InRec> iPage = inRecMapper.selectPage(page,queryWrapper);
        List<InRec> list = iPage.getRecords();

        return list;
    }
}
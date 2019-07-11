package com.simon.assets.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simon.assets.dao.OutRecMapper;
import com.simon.assets.entity.OutRec;
import com.simon.assets.service.OutRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutRecServiceImpl implements OutRecService {

    @Autowired
    private OutRecMapper outRecMapper;

    @Override
    public List<OutRec> findListAll() {
        return outRecMapper.selectList(null);

    }

    @Override
    public OutRec findById(Integer id) {
        return outRecMapper.selectById(id);
    }

    @Override
    public Integer insert(OutRec outRec) {
        return outRecMapper.insert(outRec);
    }

    @Override
    public Integer updateById(OutRec outRec) {
        return null;
    }

    @Override
    public Integer deleteById(Integer id) {
        return null;
    }

    @Override
    public List<OutRec> findPage(Integer current, Integer size) {

        IPage<OutRec> page = new Page<OutRec>(current,size);
        QueryWrapper<OutRec> queryWrapper = new QueryWrapper<OutRec>();

        IPage<OutRec> iPage = outRecMapper.selectPage(page,queryWrapper);
        List<OutRec> list = iPage.getRecords();

        return list;
    }
}
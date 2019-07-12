package com.simon.assets.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simon.assets.dao.AssetMapper;
import com.simon.assets.entity.Asset;
import com.simon.assets.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssetServiceImpl  implements AssetService {

    @Autowired
    private AssetMapper assetMapper;

    @Override
    public List<Asset> findListAll() {
        List<Asset> list =  assetMapper.selectList(null);
//        List<Asset> list =  assetMapper.findAll();
        list.forEach(System.out::println);
        return list;
    }

    @Override
    public Asset findById(Integer id) {
        return assetMapper.selectById(id);
    }

    @Override
    @Transactional
    public Integer insert(Asset asset) {
        return assetMapper.insert(asset);
    }

    @Override
    @Transactional
    public Integer updateById(Asset asset) {
        return assetMapper.updateById(asset);
    }

    @Override
    @Transactional
    public Integer deleteById(Integer id) {
        return assetMapper.deleteById(id);
    }

    @Override
    public List<Asset> findPage(Integer current, Integer size) {
        IPage<Asset> page = new Page<Asset>(current,size);
        QueryWrapper<Asset> queryWrapper = new QueryWrapper<Asset>();

        IPage<Asset> iPage  = assetMapper.selectPage(page, queryWrapper);
        List<Asset> list = iPage.getRecords();
        return list;
    }
}
package com.simon.assets.service;

import com.simon.assets.entity.Asset;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface AssetService {
    public List<Asset> findListAll();
    public Asset findById(Integer id);
    public Integer insert(Asset asset);
    public Integer updateById(Asset asset);
    public Integer deleteById(Integer id);

    //分页查询
    public List<Asset> findPage(Integer current, Integer size);
}

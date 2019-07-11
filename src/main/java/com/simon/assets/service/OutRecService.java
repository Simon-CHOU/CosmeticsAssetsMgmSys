package com.simon.assets.service;

import com.simon.assets.entity.OutRec;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OutRecService {
    public List<OutRec> findListAll();
    public OutRec findById(Integer id);
    public Integer insert(OutRec outRec);
    public Integer updateById(OutRec outRec);
    public Integer deleteById(Integer id);

    //分页查询
    public List<OutRec> findPage(Integer current, Integer size);
}

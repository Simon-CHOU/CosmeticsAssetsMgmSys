package com.simon.assets.service;

import com.simon.assets.entity.InRec;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InRecService {
    public List<InRec> findListAll();
    public InRec findById(Integer id);
    public Integer insert(InRec inRec);
    public Integer updateById(InRec inRec);
    public Integer deleteById(Integer id);

    //分页查询
    public List<InRec> findPage(Integer current, Integer size);
}

package com.simon.assets.entity;

import lombok.Data;

import java.util.Date;

/**
 * 对应资产列表
 * @author simon
 */
@Data
public class Asset {
    private Integer id;//自增Id
    private String code;//资产编号
    private String name;//名称
    private String type;//种类
    private Date buy_date;//购买日期
    private Double price;//购入价格
    private Integer guaranteeMonth;//保质期，以月为单位
}

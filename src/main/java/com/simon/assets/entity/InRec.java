package com.simon.assets.entity;

import lombok.Data;

import java.util.Date;

/**
 * 出库记录
 * @author simon
 */
@Data
public class InRec {
    private Integer id;
    private String code;//资产编号
    private Date in_date;//入库日期
    private String note;//备注
}

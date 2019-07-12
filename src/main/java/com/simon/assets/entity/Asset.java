package com.simon.assets.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


/**
 * 对应资产列表
 * @author simon
 */
@Data
public class Asset {
    private Integer id;//自增Id
    @NotBlank(message = "编号不能为空")
    private String code;//资产编号
    @NotBlank(message = "名称不能为空")
    private String name;//名称
    private String type;//种类
    private LocalDate buyDate;//购买日期
    private Double price;//购入价格
    private Integer guaranteeMonth;//保质期，以月为单位
}

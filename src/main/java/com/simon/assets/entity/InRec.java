package com.simon.assets.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * 出库记录
 *
 * @author simon
 */
@Data
public class InRec {
    private Integer id;
    @NotBlank(message = "编号不能为空")
    private String code;//资产编号
    //    @NotBlank(message = "日期不能为空")
    //TODO 自定义LocalDate 的参数验证
    private LocalDate inDate;//入库日期
    private String note;//备注
}

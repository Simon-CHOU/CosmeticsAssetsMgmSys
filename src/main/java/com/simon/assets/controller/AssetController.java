package com.simon.assets.controller;

import com.simon.assets.comm.Result;
import com.simon.assets.entity.Asset;
import com.simon.assets.service.impl.AssetServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javafx.scene.chart.ValueAxis;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    private AssetServiceImpl assetService;

    @GetMapping(value = "/list")
    @ApiOperation(value = "获取所有资产列表", notes = "")
    public Result findListAll() {
        return Result.success(assetService.findListAll());
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "获取指定id的资产信息", notes = "")
    @ApiImplicitParam(name = "id", value = "资产ID", required = true, dataType = "int")
    public Result findById(@PathVariable("id") Integer id) {
        return Result.success(assetService.findById(id));
    }

    @PostMapping(value = "")
    @ApiOperation(value = "插入新的资产信息", notes = "")
    @ApiImplicitParam(name = "asset", value = "资产详细实体", required = true, dataType = "Asset")
    public Result insert(@Valid @RequestBody Asset asset) {
        int res = assetService.insert(asset);
        return Result.success(res);
    }//TODO 如何插入才能保证id自动增加

    @PutMapping(value = "")
    @ApiOperation(value = "根据ID更新资产信息列表", notes = "")
    @ApiImplicitParam(name = "asset", value = "资产详细实体", required = true, dataType = "Asset")
    public Result update(@RequestBody Asset asset) {
        int res = assetService.updateById(asset);
        return Result.success(res);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "根据ID删除资产信息", notes = "")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int")
    public Result delete(@PathVariable("id") Integer id) {
        int res = assetService.deleteById(id);
        return Result.success(res);
    }

    @GetMapping(value = "/{current}/{size}")
    @ApiOperation(value = "分页查询资产列表", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页结果条数", required = true, dataType = "int")
    })
    public Result findPage(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        List<Asset> list = assetService.findPage(current, size);
        return Result.success(list);
    }

    @GetMapping(value = "/export")
    @ApiOperation(value = "导出资产列表为Excel", notes = "")
    public void Export(HttpServletResponse response) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("资产详情表");
        List<Asset> assetList = assetService.findListAll();

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(currentTime);
        // 设置要导出的文件的名字
        String fileName = "AssetDump" + dateString + ".xls";

        // 新增数据行，并且设置单元格数据
        int rowNum = 1;

        // headers表示excel表中第一行的表头 在excel表中添加表头
        String[] headers = {"id", "资产编号", "类型", "购买日期", "价格", "保质期（月）"};
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (Asset item : assetList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(item.getId());
            row1.createCell(1).setCellValue(item.getCode());
            row1.createCell(2).setCellValue(item.getType());
            row1.createCell(3).setCellValue(item.getBuyDate().toString());
            row1.createCell(4).setCellValue(item.getPrice());
            row1.createCell(5).setCellValue(item.getGuaranteeMonth());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}

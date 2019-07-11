package com.simon.assets.controller;

import com.simon.assets.comm.Result;
import com.simon.assets.entity.Asset;
import com.simon.assets.service.impl.AssetServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ApiImplicitParam(name = "id", value = "资产ID", required = true, dataType = "Integer")
    public Result findById(@PathVariable("id") Integer id) {
        return Result.success(assetService.findById(id));
    }

    @PostMapping(value = "")
    @ApiOperation(value = "插入新的资产信息", notes = "")
    @ApiImplicitParam(name = "asset", value = "资产详细实体", required = true, dataType = "Asset")
    public Result insert(@Valid @RequestBody Asset asset) {
        int res = assetService.insert(asset);
        return Result.success(res);
    }

    @PutMapping(value = "")
    @ApiOperation(value = "根据ID更新资产信息列表", notes = "")
    @ApiImplicitParam(name = "asset", value = "资产详细实体", required = true, dataType = "Asset")
    public Result update(@RequestBody Asset asset) {
        int res = assetService.updateById(asset);
        return Result.success(res);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "根据ID删除资产信息", notes = "")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Integer")
    public Result delete(@PathVariable("id") Integer id) {
        int res = assetService.deleteById(id);
        return Result.success(res);
    }

    @GetMapping(value = "/{cur}/{size}")
    @ApiOperation(value = "分页查询资产列表", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "每页结果条数", required = true, dataType = "Integer")
    })
    public Result findPage(@PathVariable("cur") Integer current, @PathVariable("size") Integer size) {
        List<Asset> list = assetService.findPage(current, size);
        return Result.success(list);
    }
}

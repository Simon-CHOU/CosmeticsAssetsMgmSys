package com.simon.assets.controller;

import com.simon.assets.comm.Result;
import com.simon.assets.entity.OutRec;
import com.simon.assets.service.impl.OutRecServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/out")
public class OutRecController {

    @Autowired
    private OutRecServiceImpl outRecService;

    @GetMapping(value = "/list")
    @ApiOperation(value="获取所有出库记录", notes="")
    public Result findListAll() {
        return Result.success(outRecService.findListAll());
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="获取指定ID的出库记录", notes="")
    @ApiImplicitParam(name = "id", value = "出库记录ID", required = true, dataType = "int")
    public Result findById(@PathVariable("id") Integer id) {
        return Result.success(outRecService.findById(id));
    }

    @PostMapping(value = "")
    @ApiOperation(value="新增出库记录", notes="")
    @ApiImplicitParam(name = "outRec", value = "出库记录详细实体", required = true, dataType = "OutRec")
    public Result insert(@Valid @RequestBody OutRec outRec) {
        int res = outRecService.insert(outRec);
        return Result.success(res);
    }

    @PutMapping(value = "")
    @ApiOperation(value="根据ID修改出库记录", notes="")
    @ApiImplicitParam(name = "outRec", value = "出库记录详细实体", required = true, dataType = "OutRec")
    public Result update(@RequestBody OutRec outRec) {
        int res = outRecService.updateById(outRec);
        return Result.success(res);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value="根据ID删除出库记录", notes="")
    @ApiImplicitParam(name = "id", value = "出库记录ID", required = true, dataType = "int")
    public Result delete(@PathVariable("id") Integer id) {
        int res = outRecService.deleteById(id);
        return Result.success(res);
    }

    @GetMapping(value = "/{current}/{size}")
    @ApiOperation(value="分页查询出库记录", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页结果条数", required = true, dataType = "int")
    })
    public Result findPage(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        List<OutRec> list = outRecService.findPage(current, size);
        return Result.success(list);
    }
}

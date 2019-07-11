package com.simon.assets.controller;

import com.simon.assets.comm.Result;
import com.simon.assets.entity.InRec;
import com.simon.assets.service.impl.InRecServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/in")
public class InRecController {
    @Autowired
    private InRecServiceImpl inRecService;

    @GetMapping(value = "/list")
    @ApiOperation(value="获取所有入库记录", notes="")
    public Result findListAll() {
        return Result.success(inRecService.findListAll());
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="获取指定ID的所有入库记录", notes="")
    @ApiImplicitParam(name = "id", value = "入库记录ID", required = true, dataType = "Integer")
    public Result findById(@PathVariable("id") Integer id) {
        return Result.success(inRecService.findById(id));
    }

    @PostMapping(value = "")
    @ApiOperation(value="新增入库记录", notes="")
    @ApiImplicitParam(name = "inRec", value = "入库记录详细实体", required = true, dataType = "InRec")
    public Result insert(@Valid @RequestBody InRec inRec) {
        int res = inRecService.insert(inRec);
        return Result.success(res);
    }

    @PutMapping(value = "")
    @ApiOperation(value="根据ID更新入库记录", notes="")
    @ApiImplicitParam(name = "inRec", value = "入库记录详细实体", required = true, dataType = "InRec")
    public Result update(@RequestBody InRec inRec) {
        int res = inRecService.updateById(inRec);
        return Result.success(res);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value="根据ID删除入库记录", notes="")
    @ApiImplicitParam(name = "id", value = "入库记录ID", required = true, dataType = "Integer")
    public Result delete(@PathVariable("id") Integer id) {
        int res = inRecService.deleteById(id);
        return Result.success(res);
    }

    @GetMapping(value = "/{cur}/{size}")
    @ApiOperation(value="分页查询入库记录", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "每页结果条数", required = true, dataType = "Integer")
    })
    public Result findPage(@PathVariable("cur") Integer current, @PathVariable("size") Integer size) {
        List<InRec> list = inRecService.findPage(current, size);
        return Result.success(list);
    }
}

package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pojo.Clazz;
import com.example.service.ClazzService;
import com.example.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: AlbertHPW
 * @Date: 2025/1/9 12:49
 */
@Api(tags = "班级管理器")
@RestController
@RequestMapping("/sms/clazzController")
public class ClazzController {

    @Autowired
    ClazzService clazzService;

    /**
     * 分页带条件查询班级信息
     *
     * @param pageNo
     * @param pageSize
     * @param clazz
     * @return
     */
    // sms/clazzController/getClazzsByOpr/1/3?gradeName=&name=
    @ApiOperation("分页带条件查询班级信息")
    @GetMapping("/getClazzsByOpr/{pageNo}/{pageSize}")
    public Result getClazzByOpr(
            @ApiParam("分页查询的页码数") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("分页查询页大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("分页查询的查询条件") Clazz clazz
    ) {
        Page<Clazz> page = new Page<>(pageNo, pageSize);

        IPage<Clazz> iPage = clazzService.getClazzsByOpr(page, clazz);

        return Result.ok(iPage);
    }

    /**
     * 增加或者修改班级信息
     *
     * @param clazz
     * @return
     */
    //	/sms/clazzController/saveOrUpdateClazz
    @ApiOperation("增加或者修改班级信息")
    @PostMapping("/saveOrUpdateClazz")
    public Result saveOrUpdateClazz(@ApiParam("JSON格式的班级信息") @RequestBody Clazz clazz) {
        clazzService.saveOrUpdate(clazz);
        return Result.ok();
    }

    /**
     * 删除单个和多个班级
     *
     * @param ids
     * @return
     */
    // DELETE sms/clazzController/deleteClazz  [1,2,3]
    @ApiOperation("删除单个和多个班级")
    @DeleteMapping("/deleteClazz")
    public Result deleteClazz(@ApiParam("要删除的多个班级的ID的JSON数组") @RequestBody List<Integer> ids) {
        clazzService.removeByIds(ids);
        return Result.ok();
    }

    /**
     * 查询所有班级信息
     *
     * @return
     */
    //GET /sms/clazzController/getClazzs
    @ApiOperation("查询所有班级信息")
    @GetMapping("/getClazzs")
    public Result getClazzs() {
        List<Clazz> clazzs = clazzService.getClazzs();
        return Result.ok(clazzs);
    }
}

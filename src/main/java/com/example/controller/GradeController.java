package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pojo.Grade;
import com.example.service.GradeService;
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
@Api(tags = "年级控制器")
@RestController
@RequestMapping("/sms/gradeController")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    //sms/gradeController/getGrades/1/3?gradeName=%E4%B8%89

    /**
     * 根据年级名称模糊查询,带分页
     *
     * @param pageNo
     * @param pageSize
     * @param gradeName
     * @return
     */
    @ApiOperation("根据年级名称模糊查询,带分页")
    @GetMapping("/getGrades/{pageNo}/{pageSize}")
    public Result getGrades(
            @ApiParam("分页查询的页码数") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("分页查询的页大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("分页查询模糊匹配的名称") String gradeName
    ) {
        // 分页 带条件查询
        Page<Grade> page = new Page<>(pageNo, pageSize);
        // 通过服务层
        IPage<Grade> pageRs = gradeService.getGradeByOpr(page, gradeName);

        // 封装Result对象并返回
        return Result.ok(pageRs);
    }


    /**
     * 新增或修改年级信息
     *
     * @param grade
     * @return
     */
    @ApiOperation("新增或修改grade,有id属性是修改,没有则是增加")
    @PostMapping("/saveOrUpdateGrade")
    public Result saveOrUpdateGrade(@ApiParam("JSON的Grade对象") @RequestBody Grade grade) {
        // 接收参数
        // 调用服务层方法完成增减或者修改
        gradeService.saveOrUpdate(grade);
        return Result.ok();
    }

    /**
     * 批量删除Grade信息
     *
     * @param ids
     * @return
     */
    //sms/gradeController/deleteGrade
    @ApiOperation("删除Grade信息")
    @DeleteMapping("/deleteGrade")
    public Result deleteGrade(@ApiParam("要删除的所有的grade的id的JSON集合") @RequestBody List<Integer> ids) {
        // 批量删除
        gradeService.removeByIds(ids);
        return Result.ok();
    }

    /**
     * 获取全部年级信息
     *
     * @return
     */
    // /sms/gradeController/getGrades
    @ApiOperation("获取全部年级")
    @GetMapping("/getGrades")
    public Result getGrades() {
        // 获取全部年级信息
        List<Grade> grades = gradeService.getGrades();
        //gradeService.list(null);
        return Result.ok(grades);
    }

}

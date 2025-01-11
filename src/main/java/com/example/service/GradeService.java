package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Grade;

import java.util.List;

/**
 * @Author: AlbertHPW
 * @Date: 2025/1/9 12:42
 */
public interface GradeService extends IService<Grade> {
    /**
     * 根据年级名称模糊查询,带分页
     * @param pageParam
     * @param gradeName
     * @return
     */
    IPage<Grade> getGradeByOpr(Page<Grade> pageParam, String gradeName);

    /**
     * 获取所有年级
     * @return
     */
    List<Grade> getGrades();
}

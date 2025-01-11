package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Clazz;

import java.util.List;

/**
 * @Author: AlbertHPW
 * @Date: 2025/1/9 12:41
 */
public interface ClazzService extends IService<Clazz> {
    /**
     * 分页带条件查询班级信息
     * @param page
     * @param clazz
     * @return
     */
    IPage<Clazz> getClazzsByOpr(Page<Clazz> page, Clazz clazz);

    /**
     * 查询所有班级信息
     * @return
     */
    List<Clazz> getClazzs();
}

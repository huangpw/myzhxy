package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.LoginForm;
import com.example.pojo.Teacher;

/**
 * @Author: AlbertHPW
 * @Date: 2025/1/9 12:43
 */
public interface TeacherService extends IService<Teacher> {
    /**
     * 教师登录
     * @param loginForm
     * @return
     */
    Teacher login(LoginForm loginForm);

    /**
     * 根据id查询教师信息
     * @param userId
     * @return
     */
    Teacher getByTeacherById(Long userId);

    IPage<Teacher> getTeachersByOpr(Page<Teacher> paraParam, Teacher teacher);
}

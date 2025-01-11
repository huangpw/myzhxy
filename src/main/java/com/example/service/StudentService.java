package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.LoginForm;
import com.example.pojo.Student;

/**
 * @Author: AlbertHPW
 * @Date: 2025/1/9 12:42
 */
public interface StudentService extends IService<Student> {
    /**
     * 学生登录
     * @param loginForm
     * @return
     */
    Student login(LoginForm loginForm);

    /**
     * 根据id查询学生信息
     * @param userId
     * @return
     */
    Student getStudentById(Long userId);

    IPage<Student> getStudentByOpr(Page<Student> pageParam, Student student);
}

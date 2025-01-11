package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Admin;
import com.example.pojo.LoginForm;

/**
 * @Author: AlbertHPW
 * @Date: 2025/1/9 12:40
 */
public interface AdminService extends IService<Admin> {

    /**
     * 管理员登录
     * @param loginForm
     * @return
     */
    Admin login(LoginForm loginForm);

    /**
     * 根据id查询管理员信息
     * @param userId
     * @return
     */
    Admin getAdminById(Long userId);

    IPage<Admin> getAdminsByOpr(Page<Admin> pageParam, String adminName);
}

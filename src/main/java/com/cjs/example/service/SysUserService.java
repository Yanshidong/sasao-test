package com.cjs.example.service;

import com.cjs.example.entity.SysUser;

public interface SysUserService {
    SysUser findUserByUsername(String username);

}

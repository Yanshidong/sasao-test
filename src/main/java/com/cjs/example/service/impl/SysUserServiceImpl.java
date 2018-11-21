package com.cjs.example.service.impl;

import com.cjs.example.dao.SysUserMapper;
import com.cjs.example.entity.SysUser;
import com.cjs.example.entity.SysUserQuery;
import com.cjs.example.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserByUsername(String username) {
        SysUserQuery sysUserQuery=new SysUserQuery();
        sysUserQuery.createCriteria().andUsernameEqualTo(username);
        List<SysUser> hasOne=sysUserMapper.selectByExample(sysUserQuery);
        if(!hasOne.isEmpty()){
            return hasOne.get(0);
        }
        return null;
    }
}

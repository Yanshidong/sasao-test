package com.cjs.example.controller;

import com.cjs.example.dao.SysUserMapper;
import com.cjs.example.domain.UserInfo;
import com.cjs.example.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.web.bind.annotation.*;
import com.cjs.example.defines.defines;

import java.security.Principal;


@RestController
@RequestMapping("/index")
public class MainController {

    @Autowired
    ClientDetailsServiceConfigurer clientDetailsServiceConfigurer;

    @Autowired
    SysUserMapper sysUserMapper;

    @GetMapping("/sayHello")
    public String sayHello(String name) {
        return "Hello, " + name;
    }


    @PreAuthorize("hasRole('SADMIN')")
    @RequestMapping("/cSAdmin")
    public String checkSAdmin(Principal principal)
    {
        return "hi,this is super admin! "+principal.toString();
    }

    @PreAuthorize("hasAuthority('"+defines.AUTHORITY_USER_ADD+"')")
    @RequestMapping("/sayHi")
    public String sayHi() {
        return "hahaha,欢迎admin来到此页;";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/userInfo")
    public Principal userInfo(Principal principal) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(principal.getName());
        return principal;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public SysUser hi(@PathVariable Integer id)
    {

        return sysUserMapper.selectByPrimaryKey(id);
    }


}

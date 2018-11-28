package com.wd7.sso.controller;

import com.wd7.sso.config.WebSecurityConfig;
import com.wd7.sso.dao.SysUserRepository;
import com.wd7.sso.defines.defines;
import com.wd7.sso.entity.UserEntity;
import org.apache.tomcat.util.descriptor.web.ContextHandler;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.util.SpringContentTypeUtils;

import java.security.Principal;


@RestController
@RequestMapping("/index")
public class MainController {

    @Autowired
    ClientDetailsServiceConfigurer clientDetailsServiceConfigurer;

    @Autowired
    SysUserRepository sysUserRepository;


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

    @PreAuthorize(value = "hasAuthority('"+ defines.AUTHORITY_USER_ADD+"')")
    @RequestMapping("/sayHi")
    public String sayHi(Authentication authentication) {

        return "hahaha,欢迎"+(authentication.getPrincipal().toString())+"来到此页;";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/userInfo")
    public Principal userInfo(Principal principal) {
        return principal;
    }

    @RequestMapping("/user/{id}")
    public String getUserById(@PathVariable Integer id)
    {
        return  sysUserRepository.getOne(id).toString();
    }


    @RequestMapping(value = "/login")
    public String userLogin()
    {
        return "/my/login";
    }




}

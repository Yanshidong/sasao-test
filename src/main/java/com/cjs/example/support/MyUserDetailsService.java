package com.cjs.example.support;

import com.cjs.example.entity.SysPermission;
import com.cjs.example.entity.SysRole;
import com.cjs.example.entity.SysUser;
import com.cjs.example.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    SysUserServiceImpl sysUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser=sysUserService.findUserByUsername(username);
        if(sysUser==null)throw new UsernameNotFoundException(username);
        //查询指定username的用户拥有的所有角色和权限。
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        for(SysRole role:sysUser.getRoleList())
        {
            //load角色
            authorities.add(new SimpleGrantedAuthority("ROLE_"+(role.getRole().toUpperCase())));
            if(role.getSysPermissionList()==null)continue;
            for(SysPermission permission:role.getSysPermissionList())
            {
                //load权限.
                authorities.add(new SimpleGrantedAuthority(permission.getPermission()));
            }
        }

        //后续添加用户可用性的一些信息，那么判断用户可用性也是问题，其实用户需要一直判断可用性，并非一次登录就一直可用
//        return  new User(sysUser.getUsername(),sysUser.getPassword(),authorities);
        //使用user的完整构造
        throw new SecurityException("系统临时更新");
//        return  new User(sysUser.getUsername(),sysUser.getPassword(),true,true,true,true,authorities);



    }

}

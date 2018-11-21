package com.wd7.sso.dao;

import com.wd7.sso.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<UserEntity,Integer> {
    public UserEntity findByUsername(String username);
}

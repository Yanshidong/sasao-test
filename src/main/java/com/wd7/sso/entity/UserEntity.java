package com.wd7.sso.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="sys_user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected   Integer id;
    protected   String  username;
    protected   String  password;
    protected   boolean accountNonExpired;
    protected   boolean accountNonLocked;
    protected   boolean credentialsNonExpired;
    protected   boolean enabled;


}

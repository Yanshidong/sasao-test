package com.wd7.sso;

import lombok.Data;

@Data
public class User{
    protected Integer id;
    protected String username;
    protected Integer isEnable;
    public User(Integer id,String username,Integer isEnable){
        this.id=id;
        this.username=username;
        this.isEnable=isEnable;
    }
    public boolean getIsEnable()
    {
        return true;
    }

    @Override
    public String toString() {
        return "User{\n" +
                "id=" + getId() +
                "\nusername='" + getUsername() + '\'' +
                "\nisEnable=" + getIsEnable() +
                "\n}";
    }
}

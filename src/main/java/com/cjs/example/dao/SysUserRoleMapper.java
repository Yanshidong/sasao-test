package com.cjs.example.dao;

import com.cjs.example.entity.SysUserRole;
import com.cjs.example.entity.SysUserRoleQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    long countByExample(SysUserRoleQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int deleteByExample(SysUserRoleQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int insert(SysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int insertSelective(SysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    List<SysUserRole> selectByExampleWithRowbounds(SysUserRoleQuery example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    List<SysUserRole> selectByExample(SysUserRoleQuery example);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleQuery example);
}
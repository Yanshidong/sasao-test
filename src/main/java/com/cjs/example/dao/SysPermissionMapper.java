package com.cjs.example.dao;

import com.cjs.example.entity.SysPermission;
import com.cjs.example.entity.SysPermissionQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface SysPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    long countByExample(SysPermissionQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int deleteByExample(SysPermissionQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int insert(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int insertSelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    List<SysPermission> selectByExampleWithRowbounds(SysPermissionQuery example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    List<SysPermission> selectByExample(SysPermissionQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    SysPermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> selectByRoleid(Integer roleid);
}
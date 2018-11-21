package com.cjs.example.dao;

import com.cjs.example.entity.OauthClientToken;
import com.cjs.example.entity.OauthClientTokenQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OauthClientTokenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    long countByExample(OauthClientTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    int deleteByExample(OauthClientTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String authenticationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    int insert(OauthClientToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    int insertSelective(OauthClientToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    List<OauthClientToken> selectByExampleWithBLOBsWithRowbounds(OauthClientTokenQuery example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    List<OauthClientToken> selectByExampleWithBLOBs(OauthClientTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    List<OauthClientToken> selectByExampleWithRowbounds(OauthClientTokenQuery example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    List<OauthClientToken> selectByExample(OauthClientTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    OauthClientToken selectByPrimaryKey(String authenticationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") OauthClientToken record, @Param("example") OauthClientTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") OauthClientToken record, @Param("example") OauthClientTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") OauthClientToken record, @Param("example") OauthClientTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OauthClientToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(OauthClientToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_token
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OauthClientToken record);
}
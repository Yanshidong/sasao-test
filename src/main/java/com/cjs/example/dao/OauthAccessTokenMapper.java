package com.cjs.example.dao;

import com.cjs.example.entity.OauthAccessToken;
import com.cjs.example.entity.OauthAccessTokenQuery;
import com.cjs.example.entity.OauthAccessTokenWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OauthAccessTokenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    long countByExample(OauthAccessTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    int deleteByExample(OauthAccessTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String authenticationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    int insert(OauthAccessTokenWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    int insertSelective(OauthAccessTokenWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    List<OauthAccessTokenWithBLOBs> selectByExampleWithBLOBsWithRowbounds(OauthAccessTokenQuery example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    List<OauthAccessTokenWithBLOBs> selectByExampleWithBLOBs(OauthAccessTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    List<OauthAccessToken> selectByExampleWithRowbounds(OauthAccessTokenQuery example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    List<OauthAccessToken> selectByExample(OauthAccessTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    OauthAccessTokenWithBLOBs selectByPrimaryKey(String authenticationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") OauthAccessTokenWithBLOBs record, @Param("example") OauthAccessTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") OauthAccessTokenWithBLOBs record, @Param("example") OauthAccessTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") OauthAccessToken record, @Param("example") OauthAccessTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OauthAccessTokenWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(OauthAccessTokenWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_access_token
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OauthAccessToken record);
}
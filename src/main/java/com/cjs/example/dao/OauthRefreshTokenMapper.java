package com.cjs.example.dao;

import com.cjs.example.entity.OauthRefreshToken;
import com.cjs.example.entity.OauthRefreshTokenQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OauthRefreshTokenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_refresh_token
     *
     * @mbg.generated
     */
    long countByExample(OauthRefreshTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_refresh_token
     *
     * @mbg.generated
     */
    int deleteByExample(OauthRefreshTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_refresh_token
     *
     * @mbg.generated
     */
    int insert(OauthRefreshToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_refresh_token
     *
     * @mbg.generated
     */
    int insertSelective(OauthRefreshToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_refresh_token
     *
     * @mbg.generated
     */
    List<OauthRefreshToken> selectByExampleWithBLOBsWithRowbounds(OauthRefreshTokenQuery example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_refresh_token
     *
     * @mbg.generated
     */
    List<OauthRefreshToken> selectByExampleWithBLOBs(OauthRefreshTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_refresh_token
     *
     * @mbg.generated
     */
    List<OauthRefreshToken> selectByExampleWithRowbounds(OauthRefreshTokenQuery example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_refresh_token
     *
     * @mbg.generated
     */
    List<OauthRefreshToken> selectByExample(OauthRefreshTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_refresh_token
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") OauthRefreshToken record, @Param("example") OauthRefreshTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_refresh_token
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") OauthRefreshToken record, @Param("example") OauthRefreshTokenQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_refresh_token
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") OauthRefreshToken record, @Param("example") OauthRefreshTokenQuery example);
}
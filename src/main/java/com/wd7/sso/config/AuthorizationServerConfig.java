package com.wd7.sso.config;

import com.wd7.sso.support.MyAuthorizationCodeServices;
import com.wd7.sso.support.MyClientDetailsService;
import com.wd7.sso.support.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private MyClientDetailsService myClientDetailsService;


    @Autowired
    AuthenticationManager authenticationManager;

    @Resource
    private DataSource dataSource;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private MyAuthorizationCodeServices myAuthorizationCodeServices;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients()
                .passwordEncoder(new BCryptPasswordEncoder())


        ;


//        security.realm("realm?")
//        security.checkTokenAccess();//这里是token校验的？

        ;

    }
    //配置clientDetails 存储位置
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        //region 测试用 将 clientDetails 写内存
//        clients.inMemory()
//                .withClient("barClientIdPassword")
//                .secret(bCryptPasswordEncoder.encode("secret"))
//                .authorizedGrantTypes("authorization_code", "refresh_token","password")
//                .scopes("userInfo:view", "userInfo:add", "execute")
//                .redirectUris("https://www.getpostman.com/oauth2/callback")
        ;
        //endregion

        //region 将 client信息 写jdbc,在表 oauth_client_details
//        clients.jdbc(dataSource);

        //endregion
        clients.withClientDetails(myClientDetailsService)
                ;

    }

    //配置token存储位置
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        JdbcAuthorizationCodeServices jdbcAuthorizationCodeServices=new JdbcAuthorizationCodeServices(dataSource);

        TokenEnhancerChain  tokenEnhancerChain=new TokenEnhancerChain();

        //设置token存储
        endpoints.tokenStore(tokenStore());

//        endpoints.setClientDetailsService(myClientDetailsService);
        endpoints.approvalStore(new JdbcApprovalStore(dataSource)) //jdbc

        .authenticationManager(authenticationManager) //默认

        .userDetailsService(userDetailsService) //默认

        .authorizationCodeServices(myAuthorizationCodeServices) //jdbc

        .tokenEnhancer(tokenEnhancerChain)


//        endpoints.approvalStoreDisabled();
//        endpoints

//                .tokenEnhancer(accessTokenConverter())
//                .tokenStore(tokenStore())
        ;


    }

    @Bean
    public TokenStore tokenStore() {

        RedisTokenStore redisTokenStore= new RedisTokenStore(connectionFactory);
//        redisTokenStore.setAuthenticationKeyGenerator(new CustomRandomKeyGenerator());
        return redisTokenStore;
    }

//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        return converter;
//    }



}

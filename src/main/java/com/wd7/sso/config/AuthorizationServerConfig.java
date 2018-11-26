package com.wd7.sso.config;

import com.wd7.sso.support.MyClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Autowired
    private MyClientDetailsService myClientDetailsService;


    AuthenticationManager authenticationManager=new OAuth2AuthenticationManager();

    @Resource
    private DataSource dataSource;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);

//        security.realm("realm?")


        ;

    }
    //配置clientDetails 存储位置
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        //region 测试用 将 clientDetails 写内存
//        clients.inMemory()
//                .withClient("barClientIdPassword")
//                .secret(bCryptPasswordEncoder.encode("secret"))
//                .authorizedGrantTypes("authorization_code", "refresh_token")
//                .scopes("read", "write", "execute")
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
        //设置token存储
        endpoints.tokenStore(tokenStore());
//        endpoints.setClientDetailsService(myClientDetailsService);
        endpoints.approvalStore(new JdbcApprovalStore(dataSource));
//        endpoints.approvalStoreDisabled();
        endpoints
                .authenticationManager(authenticationManager)
//                .tokenEnhancer(accessTokenConverter())
                .tokenStore(tokenStore())
        ;


    }

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }

//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        return converter;
//    }

}

package com.wd7.sso.config;

import com.wd7.sso.hadler.CustomAuthenticationSuccessHandler;
import com.wd7.sso.hadler.CustomLogoutSuccessHandler;
import com.wd7.sso.service.impl.CustomRequestMatcher;
import com.wd7.sso.support.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.ForwardLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder())

        ;

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/plugins/**", "/favicon.ico");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        HttpStatusReturningLogoutSuccessHandler httpStatusReturningLogoutSuccessHandler=new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK);
        SimpleUrlLogoutSuccessHandler simpleUrlLogoutSuccessHandler=new SimpleUrlLogoutSuccessHandler();
        ForwardLogoutSuccessHandler forwardLogoutSuccessHandler=new ForwardLogoutSuccessHandler("http://www.baidu.com");
        AuthenticationSuccessHandler customAuthenticationSuccessHandler=new CustomAuthenticationSuccessHandler();
        LogoutSuccessHandler customLogoutSuccessHandler=new CustomLogoutSuccessHandler();
        http
                .authorizeRequests()    //以这个开头，然后配置需要放行的url，最后拦截其他所有url
                .antMatchers("/logout","/login","/my/login").permitAll()
                .anyRequest().authenticated()
            .and().formLogin()
                .successHandler(customAuthenticationSuccessHandler)//登录成功的后续处理,日志等
//                .loginPage("/index/login")
                    .permitAll()//配置login页面
            .and().httpBasic()
            .and().rememberMe()
            .and()
                .logout()
//                  .logoutUrl("/my/logout")
                    .logoutSuccessHandler(customLogoutSuccessHandler)//RestAPI调用时直接给个状态码返回
//                    .logoutRequestMatcher()
//                      .logoutSuccessHandler(customLogoutSuccessHandler)//自定义登出后续处理
//                        .logoutSuccessHandler(forwardLogoutSuccessHandler)
//                  .logoutSuccessUrl("/my/login").permitAll()
            .and()
                .csrf()
                    .disable() //logout必备选项，据说不disable就要全post,可是为什么我post就不行捏
        ;

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

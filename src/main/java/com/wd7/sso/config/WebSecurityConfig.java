package com.wd7.sso.config;

import com.wd7.sso.hadler.CustomAuthenticationSuccessHandler;
import com.wd7.sso.hadler.CustomLogoutSuccessHandler;
import com.wd7.sso.service.impl.CustomRequestMatcher;
import com.wd7.sso.support.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.token.auth.DefaultClientAuthenticationHandler;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.authentication.logout.*;
import org.springframework.security.web.csrf.CsrfLogoutHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

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
        ForwardAuthenticationSuccessHandler forwardAuthenticationSuccessHandler=new ForwardAuthenticationSuccessHandler("http://127.0.0.1:8080/index/sayHi");
        AuthenticationSuccessHandler customAuthenticationSuccessHandler=new CustomAuthenticationSuccessHandler();
        SimpleUrlAuthenticationSuccessHandler simpleUrlAuthenticationSuccessHandler=new SimpleUrlAuthenticationSuccessHandler();
        SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler=new SavedRequestAwareAuthenticationSuccessHandler();

        SimpleUrlAuthenticationFailureHandler simpleUrlAuthenticationFailureHandler=new SimpleUrlAuthenticationFailureHandler();
        ExceptionMappingAuthenticationFailureHandler exceptionMappingAuthenticationFailureHandler=new ExceptionMappingAuthenticationFailureHandler();
//        DelegatingAuthenticationFailureHandler delegatingAuthenticationFailureHandler=new DelegatingAuthenticationFailureHandler();


        HttpStatusReturningLogoutSuccessHandler httpStatusReturningLogoutSuccessHandler=new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK);
        SimpleUrlLogoutSuccessHandler simpleUrlLogoutSuccessHandler=new SimpleUrlLogoutSuccessHandler();
        ForwardLogoutSuccessHandler forwardLogoutSuccessHandler=new ForwardLogoutSuccessHandler("http://www.baidu.com");
        LogoutSuccessHandler customLogoutSuccessHandler=new CustomLogoutSuccessHandler();


//        CompositeLogoutHandler compositeLogoutHandler=new CompositeLogoutHandler();
//        CsrfLogoutHandler csrfLogoutHandler=new CsrfLogoutHandler();


        http
                .authorizeRequests()    //以这个开头，然后配置需要放行的url，最后拦截其他所有url
                .antMatchers("/logout","/login","/my/login","/my/logout").permitAll()
                .anyRequest().authenticated()
            .and().formLogin()
                .successHandler(customAuthenticationSuccessHandler)//登录成功的后续处理,日志等
//                  .successHandler(forwardAuthenticationSuccessHandler)
//                .successHandler(simpleUrlAuthenticationSuccessHandler)
//                .successHandler(savedRequestAwareAuthenticationSuccessHandler)
//                  .successHandler()
//                .loginPage("/index/login")
//                .failureForwardUrl("/login?loginfail=loginfail")
                .failureHandler(exceptionMappingAuthenticationFailureHandler)
                    .permitAll()//配置login页面
            .and().httpBasic()
            .and().rememberMe()
            .and().logout()
                  .logoutUrl("/my/logout")
                    .deleteCookies("JSESSIONID")
//                .addLogoutHandler(compositeLogoutHandler)
                .clearAuthentication(true)
                    .logoutSuccessHandler(customLogoutSuccessHandler)//RestAPI调用时直接给个状态码返回
//                      .logoutSuccessHandler(simpleUrlLogoutSuccessHandler)//自定义登出后续处理
//                        .logoutSuccessHandler(forwardLogoutSuccessHandler)//重定向

                  .logoutSuccessUrl("/login")
                      .permitAll()
            .and()
                .csrf()
                    .disable() //logout必备选项，据说不disable就要全post,可是为什么我post就不行捏
        ;

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//                return bCryptPasswordEncoder.encode(charSequence.toString());
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//                return true;
//            }
//        };
//    }

    /**
     * Override this method to expose the {@link AuthenticationManager} from
     * {@link #configure(AuthenticationManagerBuilder)} to be exposed as a Bean. For
     * example:
     * <p>
     * <pre>
     * &#064;Bean(name name="myAuthenticationManager")
     * &#064;Override
     * public AuthenticationManager authenticationManagerBean() throws Exception {
     *     return super.authenticationManagerBean();
     * }
     * </pre>
     *
     * @return the {@link AuthenticationManager}
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

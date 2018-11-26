package com.wd7.sso.hadler;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    org.slf4j.Logger logger= LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
    /**
     * Called when a user has been successfully authenticated.
     *
     * @param request        the request which caused the successful authentication
     * @param response       the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("**********:AuthenticationSuccess logger start:*******************");
        logger.info("principal::"+(authentication.getPrincipal()==null?"null":authentication.getPrincipal().toString()));
        logger.info("authorities::"+(authentication.getAuthorities()==null?"null":authentication.getAuthorities().toString()));
        logger.info("credentials::"+(authentication.getCredentials()==null?"null":authentication.getCredentials().toString()));
        logger.info("details::"+(authentication.getDetails()==null?"null":authentication.getDetails().toString()));
    }
}

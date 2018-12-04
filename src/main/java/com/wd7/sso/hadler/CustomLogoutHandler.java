package com.wd7.sso.hadler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomLogoutHandler implements LogoutHandler {

    @Autowired
    TokenStore tokenStore;

    /**
     * Causes a logout to be completed. The method must complete successfully.
     *
     * @param request        the HTTP request
     * @param response       the HTTP response
     * @param authentication the current principal details
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

    }
}

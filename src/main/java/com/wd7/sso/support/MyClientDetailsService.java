package com.wd7.sso.support;

import com.wd7.sso.details.CustomClientDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MyClientDetailsService implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        CustomClientDetails clientDetails=new CustomClientDetails();
        Set<String> resourceIds=new HashSet<String>();
        Set<String> scopes=new HashSet<String>();
        Set<String> authorizationGrantTypes=new HashSet<String>();
        Set<String> registeredRedirectUri=new HashSet<String>();
        Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        Map<String,Object> additionalInfomation=new HashMap<String,Object>();

        resourceIds.add("oauth2-resource");
        scopes.add("userInfo:view");
//        scopes.add("userInfo:add");
        authorizationGrantTypes.add("password");
        authorizationGrantTypes.add("authorization_code");
        authorizationGrantTypes.add("refresh_token");
        authorizationGrantTypes.add("client_credentials");

        registeredRedirectUri.add("https://www.getpostman.com/oauth2/callback");
//        authorities.add("");
        additionalInfomation.put("name","这里是测试client");

        clientDetails.setClientId("barClientIdPassword");
        clientDetails.setResourceIds(resourceIds);//secret
        clientDetails.setClientSecret("$2a$10$CfgefMFbRVygtavhRyJqzOLUQtHO58Vvwt3aQq/Cpj9Yguc/D9Zse");
        clientDetails.setScope(scopes);
        clientDetails.setAuthorizedGrantTypes(authorizationGrantTypes);
        clientDetails.setRegisteredRedirectUri(registeredRedirectUri);
        clientDetails.setAuthorities(authorities);
        clientDetails.setAccessTokenValiditySeconds(36000);
        clientDetails.setRefreshTokenValiditySeconds(36000);
        clientDetails.setAdditionalInformation(additionalInfomation);
        clientDetails.setAutoApprove(true);


     return clientDetails;
    }
}

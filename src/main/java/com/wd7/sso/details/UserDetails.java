package com.wd7.sso.details;

import com.wd7.sso.entity.UserEntity;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetails extends UserEntity implements org.springframework.security.core.userdetails.UserDetails, CredentialsContainer {

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetails(String username, String password, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled,Collection<? extends GrantedAuthority> authorities) {
        setUsername(username);
        setPassword(password);
        setAccountNonExpired(accountNonExpired);
        setAccountNonLocked(accountNonLocked);
        setCredentialsNonExpired(credentialsNonExpired);
        setEnabled(enabled);
        this.authorities=authorities;

    }

    @Override
    public void eraseCredentials() {
        setPassword(null);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

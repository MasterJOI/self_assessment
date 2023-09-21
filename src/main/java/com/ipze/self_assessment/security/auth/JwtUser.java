package com.ipze.self_assessment.security.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ipze.self_assessment.model.entity.AuthPermission;
import com.ipze.self_assessment.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Security based wrapper for {@link User} entity.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class JwtUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    private final User user;
    private final Set<SimpleGrantedAuthority> grantedAuthorities;
    private final Set<String> permissionNames;

    public JwtUser(User user) {
        this.user = user;
        this.permissionNames = user.getAuthPermissions()
                .stream()
                .map(AuthPermission::getName)
                .collect(Collectors.toSet());
        this.grantedAuthorities = this.permissionNames.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @JsonIgnore
    public UUID getId() {
        return this.user.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    /*public String getIdentifier() {
        return this.user.getIdentifier();
    }*/

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean hasGroup(String group) {
        return user.getAuthGroups()
                .stream()
                .anyMatch(userGroup -> userGroup.getName().equals(group));
    }

    public boolean containsPermission(String permissionName) {
        return permissionNames.contains(permissionName);
    }


    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}

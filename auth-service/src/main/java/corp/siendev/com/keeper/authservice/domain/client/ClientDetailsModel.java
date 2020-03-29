/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.authservice.domain.client;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClientDetailsModel implements ClientDetails {

    private String clientId;
    private String clientSecret;
    private Set<String> scope;
    private Set<String> authorizedGrantTypes;
    private Collection<GrantedAuthority> authorities;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;

    public ClientDetailsModel(ClientModel clientModel) {
        this.clientId = clientModel.getClientId();
        this.clientSecret = clientModel.getClientSecret();

        String[] scopes = clientModel.getScope().split(",");
        this.scope = new HashSet<>(Arrays.asList(scopes));

        String[] grantTypes = clientModel.getAuthorizedGrantTypes().split(",");
        this.authorizedGrantTypes = new HashSet<>(Arrays.asList(grantTypes));

        String[] authorities = clientModel.getAuthorities().split(",");
        Collection<GrantedAuthority> grandAuthorities = Collections.EMPTY_LIST;
        for (String authority: authorities) {
            grandAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        this.authorities = grandAuthorities;

        this.accessTokenValiditySeconds = clientModel.getAccessTokenValidity();
        this.refreshTokenValiditySeconds = clientModel.getRefreshTokenValidity();
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}

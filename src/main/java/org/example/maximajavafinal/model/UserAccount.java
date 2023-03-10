package org.example.maximajavafinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework. security.core.userdetails.UserDetails;

import java.util.List;

@Entity
public class UserAccount implements UserDetails {

    @Id
    private String username;
    private String password;
    private List<String> authorities;
    private boolean enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserAccount() {
    }

    public UserAccount(String username, String password, List<String> authorities, boolean enabled) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
    }
}

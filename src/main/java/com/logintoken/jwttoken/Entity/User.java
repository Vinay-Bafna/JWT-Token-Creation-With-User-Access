package com.logintoken.jwttoken.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinTable(name ="user_role", joinColumns = @JoinColumn(name = "user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = this.roles.stream().map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {

        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String name, String email, String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }


}

package io.Spring.Security.SpringSecurityWithJwt.service;

import io.Spring.Security.SpringSecurityWithJwt.domain.UserRole;
import io.Spring.Security.SpringSecurityWithJwt.domain.AppUser;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser appUser);
    UserRole saveRole(UserRole userRole);
    void addRoleToUser(String userName, String roleName );
    AppUser getUser(String userName);
    List<AppUser>getUsers();
}

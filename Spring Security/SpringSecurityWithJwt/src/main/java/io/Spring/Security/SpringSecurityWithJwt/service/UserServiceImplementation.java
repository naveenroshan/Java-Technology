package io.Spring.Security.SpringSecurityWithJwt.service;

import io.Spring.Security.SpringSecurityWithJwt.domain.UserRole;
import io.Spring.Security.SpringSecurityWithJwt.domain.AppUser;
import io.Spring.Security.SpringSecurityWithJwt.repo.UserRepo;
import io.Spring.Security.SpringSecurityWithJwt.repo.UserRoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplementation implements UserService , UserDetailsService {

    private final UserRepo userRepo;

    private final UserRoleRepo userRoleRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("Saving user {}", appUser.getUserName());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return userRepo.save(appUser);
    }

    @Override
    public UserRole saveRole(UserRole userRole) {
        log.info("Saving  user role {}", userRole.getName());
        return userRoleRepo.save(userRole);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Adding role {} to user {}",roleName, userName );
        AppUser appUser = userRepo.findByUserName(userName);
        UserRole userRole = userRoleRepo.findByName(roleName);
        appUser.getUserRoles().add(userRole);
    }

    @Override
    public AppUser getUser(String userName) {
        log.info("Getting user {}" , userName);
        return userRepo.findByUserName(userName);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Getting all user");
        return userRepo.findAll();
    }

    // Spring finds the user from the use of JPA.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepo.findByUserName(username);
        if(user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else{
            log.info("user found in the database : {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getUserRoles().forEach(userRole -> {
            authorities.add(new SimpleGrantedAuthority(userRole.getName()));
        });
        return new User(user.getName(),user.getPassword(),authorities);
    }
}

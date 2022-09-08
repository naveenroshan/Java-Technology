package io.Spring.Security.SpringSecurityWithJwt.api;

import io.Spring.Security.SpringSecurityWithJwt.domain.AppUser;
import io.Spring.Security.SpringSecurityWithJwt.domain.UserRole;
import io.Spring.Security.SpringSecurityWithJwt.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser){
        URI uri =  URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                                                         .path("/api/user/save")
                                                         .toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(appUser));
    }

    @PostMapping("/role/save")
    public ResponseEntity<UserRole> saveRole(@RequestBody UserRole userRole){
        URI uri =  URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/role/save")
                .toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(userRole));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserFrom roleToUserFrom){
        userService.addRoleToUser(roleToUserFrom.getUsername(), roleToUserFrom.getRolename());
        return ResponseEntity.ok().build();
    }

    @Data
    class RoleToUserFrom{
        private String username;
        private String rolename;
    }

}

package io.Spring.Security.SpringSecurityWithJwt.repo;

import io.Spring.Security.SpringSecurityWithJwt.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
    UserRole findByName(String name);
}

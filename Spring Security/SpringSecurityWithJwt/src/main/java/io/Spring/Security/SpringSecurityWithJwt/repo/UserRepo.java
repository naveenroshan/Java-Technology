package io.Spring.Security.SpringSecurityWithJwt.repo;

import io.Spring.Security.SpringSecurityWithJwt.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}

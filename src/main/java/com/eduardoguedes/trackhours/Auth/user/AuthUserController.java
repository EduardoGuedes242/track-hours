package com.eduardoguedes.trackhours.Auth.user;

import com.eduardoguedes.trackhours.user.UserEntity;
import com.eduardoguedes.trackhours.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

  @Autowired
  private UserRepository userRepository;

  private AuthenticationService  authUserService;

  public AuthUserController(AuthenticationService  authUserService) {
    this.authUserService = authUserService;
  }

  @PostMapping("/user")
  public String authenticate(Authentication authentication) {
    String username = authentication.getName();
    Optional<UserEntity> user = userRepository.findByEmail(username);
    return authUserService.authenticate(authentication, user.get().getTenantId());
  }
}

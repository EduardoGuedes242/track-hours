package com.eduardoguedes.trackhours.Auth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

  private AuthenticationService  authUserService;

  public AuthUserController(AuthenticationService  authUserService) {
    this.authUserService = authUserService;
  }

  @PostMapping("/user")
  public String authenticate(Authentication authentication) {
    return authUserService.authenticate(authentication);
  }
}

package com.eduardoguedes.trackhours.Auth.user;

import com.eduardoguedes.trackhours.infra.security.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  private JwtService jwtService;

  public AuthenticationService(JwtService jwtService) {
    this.jwtService = jwtService;
  }

  public String authenticate(Authentication authentication, Integer tenantId) {
    return jwtService.generateToken(authentication, tenantId);
  }
}

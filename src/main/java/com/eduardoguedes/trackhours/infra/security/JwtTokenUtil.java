package com.eduardoguedes.trackhours.infra.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {

  public Integer getTenantIdFromToken() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
      Jwt jwt = (Jwt) authentication.getPrincipal();
      return Integer.parseInt(jwt.getClaimAsString("tenantId"));
    }
    return null;
  }
}
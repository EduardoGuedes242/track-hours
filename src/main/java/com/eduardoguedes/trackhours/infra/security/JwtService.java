package com.eduardoguedes.trackhours.infra.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtService {

  private final JwtEncoder encoder;

  public JwtService(JwtEncoder encoder) {
    this.encoder = encoder;
  }

  public String generateToken(Authentication authentication, Integer tenantId) {
    Instant now = Instant.now();
    long expired = 3600L;

    String scope = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(" "));

    var claims = JwtClaimsSet.builder()
            .issuer("spring-security-jwt")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expired))
            .subject(authentication.getName())
            .claim("scope", scope)
            .claim("tenantId", tenantId)
            .build();

    return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
  }
}
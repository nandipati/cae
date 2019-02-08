package com.rsi.adaptive.api.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.List;
import java.util.stream.Collectors;

public class SecurityTestUtils {

  public static void authenticateAs(CAEUser user) {
    SecurityContextHolder.getContext()
        .setAuthentication(new PreAuthenticatedAuthenticationToken(user, user.getPassword(), user.getAuthorities()));
  }

  public static void clearSecurityContext() {
    SecurityContextHolder.clearContext();
  }

  public static CAEUser createUser(String id, List<String> grants) {
    return new CAEUser(id,
        grants.stream().map(grant -> new SimpleGrantedAuthority(grant)).collect(Collectors.toList()));
  }
}

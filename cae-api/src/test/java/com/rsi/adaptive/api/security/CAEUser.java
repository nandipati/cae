package com.rsi.adaptive.api.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.UUID;

public class CAEUser extends User {

  private static final long serialVersionUID = 2319550281067485889L;

  private UUID userGuid;

  public CAEUser(String username, Collection<? extends GrantedAuthority> authorities) {
    super(username, "password", authorities);
  }

  public UUID getUserGuid() {
    return userGuid;
  }

  public void setUserGuid(UUID userGuid) {
    this.userGuid = userGuid;
  }

}

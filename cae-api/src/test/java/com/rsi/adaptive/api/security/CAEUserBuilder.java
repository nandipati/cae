package com.rsi.adaptive.api.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.rsi.security.common.converter.RSIRoleConverter.ROLE_TRUSTEDAPI;

/**
 * Created by suryadevarap on 2/7/19.
 */
public class CAEUserBuilder {
  private UUID userGuid;
  private String[] roles;

  public CAEUser build() {
    CAEUser scoringUser = new CAEUser(userGuid.toString(),
        Arrays.stream(roles).map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

    scoringUser.setUserGuid(userGuid);
    return scoringUser;
  }

  public static CAEUserBuilder trustedApi() {
    return user(randomId(), ROLE_TRUSTEDAPI);
  }

  public CAEUserBuilder withUserGuid(UUID userGuid) {
    this.userGuid = userGuid;
    return this;
  }

  public CAEUserBuilder withRoles(String... roles) {
    this.roles = roles;
    return this;
  }

  private CAEUserBuilder createUser(UUID userGuid, String... roles) {
    this.userGuid = userGuid;
    this.roles = roles;
    return this;
  }

  private static CAEUserBuilder user(UUID userGuid, String... roles) {
    return new CAEUserBuilder().createUser(userGuid, roles);
  }

  private static UUID randomId() {
    return UUID.randomUUID();
  }

}

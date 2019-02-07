package com.rsi.adaptive.api.testUtils;

import com.rsi.adaptive.api.security.CAEUserBuilder;
import com.rsi.adaptive.api.security.SecurityTestUtils;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.UUID;

import static com.rsi.adaptive.api.testUtils.AuthenticateAs.AuthType;

public class AuthenticationRule extends TestWatcher {

  @Override
  protected void starting(Description description) {
    AuthenticateAs auth = description.getAnnotation(AuthenticateAs.class);
    if (auth == null) {
      return;
    }

    AuthType authType = auth.value();
    CAEUserBuilder userBuilder;

    switch (authType) {

      case TRUSTED_API: {
        userBuilder = CAEUserBuilder.trustedApi();
        break;
      }

      default: {
        throw new NotImplementedException("no implementation for this authType, pls add one");
      }
    }

    if (!StringUtils.isBlank(auth.userId())) {
      userBuilder.withUserGuid(UUID.fromString(auth.userId()));
    }

    SecurityTestUtils.authenticateAs(userBuilder.build());
  }

  @Override
  protected void finished(Description description) {
    SecurityTestUtils.clearSecurityContext();
  }
}
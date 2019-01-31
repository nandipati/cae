package com.rsi.adaptive.api.testUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AuthenticateAs {

    AuthType value();

    String userId() default "";

    enum AuthType {
        TRUSTED_API
    }
}

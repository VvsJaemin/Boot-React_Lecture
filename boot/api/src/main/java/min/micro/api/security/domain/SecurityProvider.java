package min.micro.api.security.domain;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class SecurityProvider implements AuthenticationProvider { //스프링 시큐리티에서 제공하는 인터페이스를 구현 -> 인증 허용

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}

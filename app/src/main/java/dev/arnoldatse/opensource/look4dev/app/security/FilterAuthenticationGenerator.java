package dev.arnoldatse.opensource.look4dev.app.security;

import dev.arnoldatse.opensource.look4dev.core.http.httpError.exceptions.NotFoundHttpErrorException;
import org.springframework.security.core.Authentication;

public interface FilterAuthenticationGenerator {
    public Authentication generate(String userId) throws NotFoundHttpErrorException;
}

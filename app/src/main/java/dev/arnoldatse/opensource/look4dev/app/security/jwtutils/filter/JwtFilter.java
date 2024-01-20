package dev.arnoldatse.opensource.look4dev.app.security.jwtutils.filter;

import dev.arnoldatse.opensource.look4dev.app.dao.userUserProfile.UserUserProfileRepository;
import dev.arnoldatse.opensource.look4dev.app.dao.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.app.security.CustomUserDetailsService;
import dev.arnoldatse.opensource.look4dev.core.auth.TokenManager;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserUserProfileRepository userUserProfileRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader("Authorization");
        String userId;
        String token;
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            token = tokenHeader.substring(7);
            try {
                userId = tokenManager.getTokenUserId(token);
            } catch (IllegalArgumentException e) {
                throw new ServletException("Unable to get Token");
            } catch (ExpiredJwtException e) {
                throw new ServletException("Token has expired");
            }catch (SignatureException e) {
                throw new ServletException("Invalid Token");
            }
        } else {
            throw new ServletException("Token missed");
        }
        if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try{
               Authentication authenticationToken = new JwtUsernamePasswordAuthenticationTokenGenerator(userId, userRepository, userUserProfileRepository).generate();
                successfulAuthentication(request, response, authenticationToken);
            }
            catch (NotFoundException e){
                throw new ServletException("user in token not found");
            }
        }
        filterChain.doFilter(request, response);
    }


    private void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult){
        SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();
        SecurityContext context = securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authResult);
        securityContextHolderStrategy.setContext(context);
        new RequestAttributeSecurityContextRepository().saveContext(context, request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().startsWith("/auth");
    }
}

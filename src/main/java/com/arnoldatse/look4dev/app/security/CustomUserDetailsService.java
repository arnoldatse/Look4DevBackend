package com.arnoldatse.look4dev.app.security;

import com.arnoldatse.look4dev.core.entities.user.User;
import com.arnoldatse.look4dev.core.entities.userProfile.UserProfileSimple;
import com.arnoldatse.look4dev.core.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByEmailOrPseudo(username);
        if (user != null) {
            /*List<UserRole> userRoles = user.getUserRoles();
            ArrayList<String> roles = new ArrayList<>();
            for (UserRole userRole : userRoles) {
                roles.add(userRole.getRole().getName());
            }*/

            String[] profiles = user.getUserProfiles()
                    .stream()
                    .map(UserProfileSimple::getName)
                    .toArray(String[]::new);

            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(profiles)
                    .build();
        }
        throw new UsernameNotFoundException("User not found");
    }
}

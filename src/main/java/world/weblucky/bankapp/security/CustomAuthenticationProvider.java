//package world.weblucky.bankapp.security;
//
//import jakarta.servlet.http.HttpSession;
//import lombok.NoArgsConstructor;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import world.weblucky.bankapp.dto.ClientDTO;
//import world.weblucky.bankapp.entity.Client;
//import world.weblucky.bankapp.util.User;
//
//import java.util.UUID;
//
//@Component
//@NoArgsConstructor
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    private UserDetailsService userDetailsService;
//    private PasswordEncoder passwordEncoder;
//
//    public CustomAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
//        this.userDetailsService = userDetailsService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String email = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
//
//        if (passwordEncoder.matchPassword(password, userDetails.getPassword())) {
//            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//        }
//
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//
//
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
////        super.additionalAuthenticationChecks(userDetails, authentication);
//
//        if (userDetails instanceof User user) {
//            String clientId = user.getId(); // Получаем id клиента
//            String role = "CLIENT"; //user.getAuthorities().iterator().next().getAuthority(); // Получаем роль
//
//            // Сохраняем в сессию
//            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
//            session.setAttribute("clientId", clientId);
//            session.setAttribute("role", role);
//        }
//    }
//
//}

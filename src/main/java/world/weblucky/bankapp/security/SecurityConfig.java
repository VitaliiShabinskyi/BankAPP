//package world.weblucky.bankapp.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.SecurityFilterChain;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    @Bean
//    public DefaultSecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/client/**").hasRole("CLIENT")
//                                .requestMatchers("/manager/**").hasRole("MANAGER")
//                                .requestMatchers("/login", "/css/**", "/js/**").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .formLogin(withDefaults());
//
//        http
//                .authenticationProvider(customAuthenticationProvider());
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationProvider customAuthenticationProvider() {
//        return new CustomAuthenticationProvider();
//    }
//}

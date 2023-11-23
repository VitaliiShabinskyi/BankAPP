//package world.weblucky.bankapp.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
////    private DataSource dataSource;
//
//    private final PasswordEncoder passwordEncoder;
//
//    private final String[] PERMIT_ALL = {
//            "/",
//            "/login",
//            "/signin",
////            "/css",
//            "/css/**",
//            "/js/**",
//            "/images/**",
//            "/swagger-ui/**"
//    };
//
////    @Autowired
////    public SecurityConfig(DataSource dataSource, PasswordEncoder passwordEncoder) {
////        this.dataSource = dataSource;
////        this.passwordEncoder = passwordEncoder;
////    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeHttpRequests((authorizeRequests) ->
//                        authorizeRequests
//                                .requestMatchers("/client/**").hasRole("CLIENT")
//                                .requestMatchers("/manager/**").hasRole("MANAGER")
//                                .requestMatchers(PERMIT_ALL).permitAll()
////                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//
////                                .anyRequest().authenticated()
//                )
////                .formLogin(withDefaults());
//                .formLogin(form -> form.loginPage("/login").permitAll())
//                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
//                        .deleteCookies()
//                        .logoutSuccessUrl("/"));
//
////        http
////                .authenticationProvider(customAuthenticationProvider());
//
//       return http.build();
//    }
//
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.jdbcAuthentication()
////                .dataSource(dataSource)
////                .passwordEncoder()
////    }
//
////    @Bean
////    public AuthenticationProvider customAuthenticationProvider() {
////        return new CustomAuthenticationProvider();
////    }
//}

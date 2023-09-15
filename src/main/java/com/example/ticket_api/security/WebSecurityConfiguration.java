package com.example.ticket_api.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // Activation de la configuration personnalisée de la sécurité
public class WebSecurityConfiguration {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    //Initialisation d'une instance de BCrypt pour hacher les mots de passe
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Définition des filtres sur les URLs
    // Accès en fonction d'un état authentifié ou non
    //Accès en fonction de l'utilisateur authentifié (désactivé, expiré...etc)
    //Accès en fonction des rôles

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Désactivation de la gestion des en-têtes Cors au sein de Spring Security
        http
                .cors(new Customizer<CorsConfigurer<HttpSecurity>>() {
                    @Override
                    public void customize(CorsConfigurer<HttpSecurity> httpSecurityCorsConfigurer) {
                        httpSecurityCorsConfigurer.disable();
                    }
                });

        //desactivation CSRF
        http.csrf(new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
                httpSecurityCsrfConfigurer.disable();
            }
        });

        //Configuration des règles d'autorisation concernant les requêtes HTTP
        http.authorizeHttpRequests(requests -> {
            requests
                    //Toutes les requêtes HTTP /api/users sont autorisées pour tout le monde (authentifié ou non)
//                    .requestMatchers("/api/allusers").permitAll()
//                    .requestMatchers("/api/*").permitAll()

                    .requestMatchers("/auth/login").permitAll()
                    .requestMatchers("/auth/register").permitAll()
                    //Toutes les requêtes HTTP nécessitent une authentification
                    .anyRequest().authenticated();
        });
        //Configuration de la session Spring sécurité : aucune session ne sera créée côté serveur
        //Moins coûteux et inutile lorsque nous sommes dans une configuration RESTful
        http.sessionManagement(httpSecuritySessionManagementConfigurer -> {
            httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        //Ajout un filtre personnalisé qui s'exécutera avant le filtre UsernamePasswordAuthenticationFilter
        // Ce filtre pour gérer l'authentification basée sur le JWT reçu dans les en-têtes des requêtes
        //Le filtre UsernamePasswordAuthenticationFilter est un filtre de base de Spring Security
        //Il est exécuté pour gérer l'authentification par username et mot de passe

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    AuthJwtTokenFilter authenticationJwtTokenFilter(){
        return new AuthJwtTokenFilter();
    }

}


package com.diee.attendi.config;

import com.diee.attendi.model.ApiKey;
import com.diee.attendi.repository.ApiKeyRepository;
import com.diee.attendi.service.ApiKeyService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyRequestFilter extends OncePerRequestFilter {

    private final ApiKeyService apiKeyService;

    public ApiKeyRequestFilter(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;}

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiKeyValue = request.getHeader("X-Api-Key");
        System.out.println(apiKeyValue);
        if (apiKeyValue != null && !apiKeyValue.isEmpty()) {
            System.out.println("Entra aqui");
//            if (ApiToken.isValid(apiTokenValue, crc32SecretKey)) {
                var apiKey = apiKeyService.getActiveApiKey(apiKeyValue);
                if (apiKey.isPresent()) {
                    System.out.println("Y aqui");
//                    SecurityContextHolder.getContext().setAuthentication(;
                    var fakeUser = new User("api-token");
                    SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(apiKeyValue,null, null));
                }
        }
        filterChain.doFilter(request, response);
    }
}

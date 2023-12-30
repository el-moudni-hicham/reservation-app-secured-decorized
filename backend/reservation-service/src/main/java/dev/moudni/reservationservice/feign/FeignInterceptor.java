package dev.moudni.reservationservice.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        SecurityContext context = SecurityContextHolder.getContext();
        JwtAuthenticationToken authentication = (JwtAuthenticationToken)
                context.getAuthentication();
        String tokenValue = authentication.getToken().getTokenValue();
        requestTemplate.header("Authorization","Bearer "+tokenValue);
    }
}


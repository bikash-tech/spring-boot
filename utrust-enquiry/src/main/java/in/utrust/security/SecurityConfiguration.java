package in.utrust.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class SecurityConfiguration extends WebMvcConfigurerAdapter
{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST","PUT","DELETE","PATCH").allowedOrigins("*").allowedHeaders("*").allowCredentials(true).exposedHeaders("uctdmsId","auth_token","refresh_token");
    }
    
    
}
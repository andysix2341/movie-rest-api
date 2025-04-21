package com.movie.Config;

import com.movie.Service.MovieService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfig {
    
    @Bean
    protected MovieService movieServiceImpl() {
        return new MovieService();
    }

}

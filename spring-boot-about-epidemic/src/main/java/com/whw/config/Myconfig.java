package com.whw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Configuration
public class Myconfig {
    @Bean
    public LocaleResolver  localeResolver(){
        return new MyLocaleResolver();
    }
}

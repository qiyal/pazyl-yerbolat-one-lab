package kz.one.tech.prac.one.onetechpracone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

@Configuration
@ComponentScan("kz.one.tech.prac.one.onetechpracone")
public class MySpringConfig {

    @Bean
    public BufferedReader bufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}

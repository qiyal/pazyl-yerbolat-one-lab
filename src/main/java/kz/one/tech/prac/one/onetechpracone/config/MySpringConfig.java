package kz.one.tech.prac.one.onetechpracone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
@ComponentScan("kz.one.tech.prac.one.onetechpracone")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MySpringConfig {

}

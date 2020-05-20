package eu.banking.casco.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("eu.banking.casco.repository, eu.banking.casco.service")
public class TestConfiguration {
}

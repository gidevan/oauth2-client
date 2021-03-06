package com.example.demo.oauth2.client;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@EnableOAuth2Sso
@RestController
public class Oauth2ClientApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Oauth2ClientApplication.class)
				.properties("spring.config.name=client").run(args);
	}

	@RequestMapping("/")
	public String home(Principal user) {
		return "Hello " + user.getName();
	}
}

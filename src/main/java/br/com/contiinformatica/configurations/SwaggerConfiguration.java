package br.com.contiinformatica.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API - Agenda -  Conti Informática")
                        .version("1.0")
                        .description("Documentação da API Agenda da Conti Informática")
                        .contact((new Contact()
                        	.name("COTI Informatica")
                        	.email("contato@gmail.com")	
                        	.url("www.cotiinformatica.com.br")
                        	)
                        		)
                		
                		
                		
                		);
    }

}

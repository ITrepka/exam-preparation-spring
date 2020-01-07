package com.example.pretkej.springpreparation.point10.beans.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleConfiguration {
    //Stworzenie beana typu DatabaseCredential
    @Bean
    public DatabaseCredential databaseCredential() {
        return new DatabaseCredential("admin", "admin");
    }
}

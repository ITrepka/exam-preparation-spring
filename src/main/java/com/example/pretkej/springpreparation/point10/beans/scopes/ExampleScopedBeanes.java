package com.example.pretkej.springpreparation.point10.beans.scopes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//Przykłady beanów o różnych zakresach. Funkcja bardzo rzadko używana

@Configuration
public class ExampleScopedBeanes {

    //Bean typu Singleton
    //Jeden bean na cala aplikacje - domyslny
    @Bean("singletonNamesService1")
    @Scope("singleton")
    public NamesService createBeanSingleton1() {
        return new NamesService();
    }

    @Bean("singletonNamesService2")
    @Scope("singleton")
    public NamesService createBeanSingleton2() {
        return new NamesService();
    }

    //Bean typu session
    //Tworzony jest nowy bean dla każdej sesji http
    @Bean("sessionNamesService")
    @Scope("session")
    public NamesService createBeanSession() {
        return new NamesService();
    }

    //Bean typu Prototype
    //Za kazdym wstrzyknieciem tworzony jest nowy bean
    @Bean("prototypeNamesService")
    @Scope("prototype")
    public NamesService createBeanPrototype() {
        return new NamesService();
    }

    //Bean typu Request
    //Tworzony jest nowy bean dla każdego żądania http
    @Bean("requestNamesService")
    @Scope("request")
    public NamesService createBeanRequest() {
        return new NamesService();
    }
}

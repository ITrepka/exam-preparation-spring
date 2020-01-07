package com.example.pretkej.springpreparation.point10.beans.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanUsageExampleController2 {
    private DatabaseCredential databaseCredential;

    //inny sposob wstrzykiwania - oznaczenie konstruktora adnotacja @Autowired
    @Autowired
    public BeanUsageExampleController2(DatabaseCredential databaseCredential){
        this.databaseCredential = databaseCredential;
    }

    @GetMapping("/databaseCredentials2")
    public String getDbCredentials() {
        return "User : " + databaseCredential.getUsername() + ", pass: " + databaseCredential.getPassword();
    }
}

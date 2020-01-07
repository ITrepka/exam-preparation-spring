package com.example.pretkej.springpreparation.point10.beans.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanUsageExampleController1 {
    @Autowired
    private DatabaseCredential databaseCredential;

    @GetMapping("databaseCredentials1")
    public String getDbCredentials() {
        return "User : " + databaseCredential.getUsername() + ", pass: " + databaseCredential.getPassword();
    }
}

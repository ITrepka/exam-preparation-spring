package com.example.pretkej.springpreparation.point10.beans.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BeanInjectingMethodsController {
    @Autowired
    private NamesService singletonNamesService1;

    //dopasowanie beana za pomoca kwalifikatora
    @Autowired
    @Qualifier("singletonNamesService1")
    private NamesService xyz;
}

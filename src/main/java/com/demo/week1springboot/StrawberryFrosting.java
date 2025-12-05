package com.demo.springbootCourse;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component("strawberryFrosting")
@ConditionalOnProperty(name = "frosting.name", havingValue = "strawberry")
public class StrawberryFrosting implements Frosting {

    @Override
    public String getFrostingType() {
        return "Strawberry Frosting";
    }
}

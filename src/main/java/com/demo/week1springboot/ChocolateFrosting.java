package com.demo.springbootCourse;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("chocolateFrosting")
@ConditionalOnProperty(name = "frosting.name", havingValue = "chocolate", matchIfMissing = true)
@Primary
public class ChocolateFrosting implements Frosting {
    @Override
    public String getFrostingType() {
        return "Chocolate Frosting";
    }
}

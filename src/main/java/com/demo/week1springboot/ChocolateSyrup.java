package com.demo.week1springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("chocolateSyrup")
@ConditionalOnProperty(name = "syrup.name", havingValue = "chocolate", matchIfMissing = true)
@Primary
public class ChocolateSyrup implements Syrup {
    @Override
    public String getSyrupType() {
        return "Chocolate Syrup";
    }
}

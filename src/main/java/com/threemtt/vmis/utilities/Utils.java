package com.threemtt.vmis.utilities;

import org.springframework.context.annotation.Configuration;
import java.util.Random;

@Configuration
public class Utils {

    public String generateString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder("VMIS");

        // Generate 5 random digits
        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(10); // Generate random digit
            sb.append(digit);
        }

        return sb.toString();
    }
}

package eu.banking.casco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CascoCalcApplication {
    public static void main(final String[] args) {
        try {
            SpringApplication.run(CascoCalcApplication.class, args);
        } catch(Throwable e) {
        }
    }
}

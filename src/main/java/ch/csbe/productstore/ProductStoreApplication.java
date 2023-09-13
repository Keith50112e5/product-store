package ch.csbe.productstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ProductStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductStoreApplication.class, args);
    }

}

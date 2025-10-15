package br.com.locacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.locacao")
public class LocacaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocacaoApplication.class, args);
    }
}

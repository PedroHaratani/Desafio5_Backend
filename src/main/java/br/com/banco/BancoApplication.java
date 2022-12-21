package br.com.banco;


import br.com.banco.controllers.ContaController;
import br.com.banco.controllers.TransferenciaController;
import br.com.banco.services.ContaService;
import br.com.banco.services.TransferenciaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJpaRepositories("br.com.banco.repositories")
@ComponentScan(basePackageClasses = {ContaController.class, TransferenciaController.class, ContaService.class, TransferenciaService.class})
public class BancoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BancoApplication.class, args);
    }

    @GetMapping("/")
    public String teste(){
        return "Hello World";
    }

}

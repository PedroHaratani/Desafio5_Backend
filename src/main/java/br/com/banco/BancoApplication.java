package br.com.banco;

import br.com.banco.controllers.ContaController;
import br.com.banco.dto.ContaDTO;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.services.ContaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.com.models")
@EnableJpaRepositories(basePackages = "br.com.banco.repositories")
@ComponentScan(basePackageClasses = {ContaController.class, ContaDTO.class, ContaService.class, ContaRepository.class})
public class BancoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BancoApplication.class, args);
    }

}

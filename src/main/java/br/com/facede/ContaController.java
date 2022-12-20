package br.com.facede;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaController {
    @GetMapping("/contas")
    public String texto(){
        return "Acessei a API";
    }
}

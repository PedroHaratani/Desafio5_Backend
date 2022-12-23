package br.com.banco.controllers;


import br.com.banco.dtos.ContaDto;
import br.com.banco.models.ContaModel;
import br.com.banco.services.ContaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/conta")
public class ContaController {

    final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarConta(@RequestBody ContaDto contaDto){
        var contaModel = new ContaModel();
        BeanUtils.copyProperties(contaDto,contaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.save(contaModel));
    }

    @GetMapping
    public ResponseEntity<List<ContaModel>> getAllConta(){
        return ResponseEntity.status(HttpStatus.OK).body(contaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneConta(@PathVariable(value="id") int id){
        Optional<ContaModel> contaModelOptional = contaService.findById(id);
        if(!contaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não achei conta");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contaModelOptional.get());
    }

}

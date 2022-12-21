package br.com.banco.controllers;


import br.com.banco.dto.ContaDTO;
import br.com.banco.models.Conta;
import br.com.banco.services.ContaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/contas")
public class ContaController {
    final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody ContaDTO contaDTO){
        Optional<Conta> contaOptional = contaService.findById(id);
        if(!contaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado");
        }
        var conta = new Conta();
        BeanUtils.copyProperties(contaDTO,conta);
        conta.setId_conta(contaDTO.getId_conta());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(contaService.update(conta));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Conta>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(contaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value="id") int id){
        Optional<Conta> contaOptional = contaService.findById(id);
        if(!contaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contaOptional.get());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Object> create(@RequestBody ContaDTO contaDTO){
        if(contaService.existsName(contaDTO.getNome_responsavel())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não pode ter o mesmo nome");
        }
        var conta = new Conta();
        BeanUtils.copyProperties(contaDTO,conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.create(conta));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        Optional<Conta> contaOptional = contaService.findById(id);
        if(!contaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado");
        }
        contaService.delete(contaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }
}

package br.com.banco.controllers;


import br.com.banco.models.Transferencia;
import br.com.banco.services.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping(value = "/transferencias")
public class TransferenciaController {
    final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping("/{nome}/{time}")
    public ResponseEntity<List<Transferencia>> getByNameAndDate(@PathVariable("nome") String nome, @PathVariable("time") Timestamp time){
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findByNameAndDate(nome,time));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<Transferencia>> getByNameOperator(@PathVariable("nome")String nome){
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findByNameOperator(nome));
    }

    @GetMapping("/{time}")
    @ResponseBody
    public ResponseEntity<List<Transferencia>> getByDate(@PathVariable("time")Timestamp time){
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.getByDate(time));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Transferencia>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.getAll());
    }


}

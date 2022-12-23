package br.com.banco.controllers;


import br.com.banco.dtos.TransferenciaDto;
import br.com.banco.models.TransferenciaModel;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/transferencia")
public class TransferenciaController {
    final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService contaService) {
        this.transferenciaService = contaService;
    }


    @PostMapping
    public ResponseEntity<Object> salvarConta(@RequestBody TransferenciaDto transferenciaDto){
        var transferenciaModel = new TransferenciaModel();
        BeanUtils.copyProperties(transferenciaDto,transferenciaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaService.save(transferenciaModel));
    }

    @GetMapping
    public ResponseEntity<List<TransferenciaModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findAll());
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<TransferenciaModel>> getByDate(@PathVariable("date") Timestamp date){
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findByDate(date));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<TransferenciaModel>> getByName(@PathVariable("name") String name){
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findByName(name));
    }

    @GetMapping("/test/{name2}/{date}")
    public ResponseEntity<List<TransferenciaModel>> getByNameAndDate(@PathVariable("name2")String name,@PathVariable("date") LocalDateTime date){
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findByNameAndDate(name,date));
    }
}

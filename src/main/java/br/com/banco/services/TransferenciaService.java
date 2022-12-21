package br.com.banco.services;


import br.com.banco.models.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TransferenciaService {

    final TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }


    public List<Transferencia> getByDate(Timestamp time){
        return transferenciaRepository.findByDate(time);
    }

    public List<Transferencia> getAll(){
        return transferenciaRepository.findAll();
    }



    public List<Transferencia> findByNameOperator(String nome) {
        return transferenciaRepository.findByNome_operador_transacao(nome);
    }

    public List<Transferencia> findByNameAndDate(String nome, Timestamp time) {
        return transferenciaRepository.findByNome_operador_transacaoAndData_transferencia(nome,time);
    }
}

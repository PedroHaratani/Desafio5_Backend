package br.com.banco.services;


import br.com.banco.models.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Component
@Service
public class TransferenciaService {

    final TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }


    public List<Transferencia> getByDate(Date time){
        return transferenciaRepository.findByDataTransferencia(time);
    }

    public List<Transferencia> getAll(){
        return transferenciaRepository.findAll();
    }



    public List<Transferencia> findByNameOperator(String nome) {
        return transferenciaRepository.findByNomeOperadorTransacao(nome);
    }

    public List<Transferencia> findByNameAndDate(String nome, Date time) {
        return transferenciaRepository.findByNomeOperadorTransacaoAndDataTransferencia(nome,time);
    }
}

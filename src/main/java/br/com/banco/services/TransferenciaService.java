package br.com.banco.services;

import br.com.banco.models.TransferenciaModel;
import br.com.banco.repositories.TranferenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {
    final TranferenciaRepository tranferenciaRepository;

    public TransferenciaService(TranferenciaRepository tranferenciaRepository) {
        this.tranferenciaRepository = tranferenciaRepository;
    }

    public TransferenciaModel save(TransferenciaModel transferenciaModel) {
        return tranferenciaRepository.save(transferenciaModel);
    }

    public List<TransferenciaModel> findAll() {
        return tranferenciaRepository.findAll();
    }

    public List<TransferenciaModel> findByName(String name) {
        return tranferenciaRepository.findByNome_operador_transacaoAllIgnoreCase(name);
    }

    public List<TransferenciaModel> findByDate(LocalDateTime date) {
        return tranferenciaRepository.findByData_tranferenciaGreaterThanEqual(date);
    }

    public List<TransferenciaModel> findByNameAndDate(String name, LocalDateTime date) {
        return tranferenciaRepository.findByNome_operador_transacaoLikeAndData_tranferenciaGreaterThanEqual(name,date);
    }
}

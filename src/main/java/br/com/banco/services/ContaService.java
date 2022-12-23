package br.com.banco.services;

import br.com.banco.models.ContaModel;
import br.com.banco.repositories.ContaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Transactional
    public ContaModel save(ContaModel contaModel) {
        return contaRepository.save(contaModel);
    }

    public List<ContaModel> findAll() {
        return contaRepository.findAll();
    }

    public Optional<ContaModel> findById(int id) {
        return contaRepository.findById(id);
    }
}

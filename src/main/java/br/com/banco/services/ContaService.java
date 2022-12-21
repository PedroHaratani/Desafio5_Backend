package br.com.banco.services;


import br.com.banco.models.Conta;
import br.com.banco.repositories.ContaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Component
@Service
public class ContaService {

    final ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Conta create(Conta conta){
        return repository.save(conta);
    }
    public Conta update(Conta conta){
        return repository.save(conta);
    }

    public List<Conta> getAll(){
        return repository.findAll();
    }

    @Transactional
    public void delete(Conta conta){
        repository.delete(conta);
    }


    public Optional<Conta> findById(int id) {
        return repository.findById(id);
    }
}

package br.com.facede;

import br.com.classes.Conta;
import br.com.services.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaFacade {
    @Autowired
    private ContaRepository repository;

    public ContaDTO create(ContaDTO contaDTO){
        Conta conta = new Conta();
        conta.setNomeResponsavel(contaDTO.getNomeResponsavel());
        repository.save(conta);
        conta.setId(contaDTO.getId());
        return contaDTO;
    }
    public ContaDTO update(ContaDTO contaDTO,int id){
        Conta conta = repository.getOne(id);
        conta.setNomeResponsavel(contaDTO.getNomeResponsavel());
        return contaDTO;
    }
    private ContaDTO convert (Conta conta){
        return ContaDTO;
    }

    public List<ContaDTO> getAll(){
        return repository.findAll().stream().map(this::).collect(Collectors.toList());
    }
}

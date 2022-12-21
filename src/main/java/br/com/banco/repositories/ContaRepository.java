package br.com.banco.repositories;

import br.com.banco.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository  extends JpaRepository<Conta,Integer> {
    boolean existsName(String nome);
}

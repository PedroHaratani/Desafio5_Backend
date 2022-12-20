package br.com.services;

import br.com.classes.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository  extends JpaRepository<Conta,Integer> {
}

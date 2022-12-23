package br.com.banco.repositories;

import br.com.banco.models.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Integer> {
}

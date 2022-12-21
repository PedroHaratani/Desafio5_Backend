package br.com.banco.repositories;

import br.com.banco.models.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia,Integer> {
    List<Transferencia> findByNomeOperadorTransacaoAndDataTransferencia(String nomeOperadorTransacao, Date dataTransferencia);
    List<Transferencia> findByNomeOperadorTransacao(String nomeOperadorTransacao);
    List<Transferencia> findByDataTransferencia(Date dataTransferencia);

}

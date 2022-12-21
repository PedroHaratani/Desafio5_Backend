package br.com.banco.repositories;

import br.com.banco.models.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia,Integer> {
    List<Transferencia> findByNome_operador_transacaoAndData_transferencia(String nome_operador_transacao, Timestamp data_transferencia);
    List<Transferencia> findByNome_operador_transacao(String nome_operador_transacao);
    List<Transferencia> findByDate(Timestamp time);
}

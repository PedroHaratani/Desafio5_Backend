package br.com.banco.repositories;

import br.com.banco.models.TransferenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TranferenciaRepository extends JpaRepository<TransferenciaModel,Integer> {
    @Query("select t from TransferenciaModel t where t.id is not null")
    List<TransferenciaModel> findByIdNotNull();
    @Query("select t from TransferenciaModel t where t.data_tranferencia between ?1 and ?2")
    List<TransferenciaModel> findByData_tranferenciaBetween(LocalDateTime data_tranferenciaStart, LocalDateTime data_tranferenciaEnd);
    @Query("select t from TransferenciaModel t where t.nome_operador_transacao like ?1 and t.data_tranferencia >= ?2")
    List<TransferenciaModel> findByNome_operador_transacaoLikeAndData_tranferenciaGreaterThanEqual(String nome_operador_transacao, LocalDateTime data_tranferencia);
    @Query("select t from TransferenciaModel t where upper(t.nome_operador_transacao) = upper(?1)")
    List<TransferenciaModel> findByNome_operador_transacaoAllIgnoreCase(String nome_operador_transacao);


}

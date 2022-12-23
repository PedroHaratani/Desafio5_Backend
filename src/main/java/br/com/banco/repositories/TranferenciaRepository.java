package br.com.banco.repositories;

import br.com.banco.models.TransferenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TranferenciaRepository extends JpaRepository<TransferenciaModel,Integer> {
    @Query("select t from TransferenciaModel t where t.nome_operador_transacao like ?1 and t.data_tranferencia >= ?2")
    List<TransferenciaModel> findByNome_operador_transacaoLikeAndData_tranferenciaGreaterThanEqual(String nome_operador_transacao, LocalDateTime data_tranferencia);
    @Query("select t from TransferenciaModel t where t.data_tranferencia >= ?1")
    List<TransferenciaModel> findByData_tranferenciaGreaterThanEqual(LocalDateTime data_tranferencia);
    @Query("select t from TransferenciaModel t where upper(t.nome_operador_transacao) = upper(?1)")
    List<TransferenciaModel> findByNome_operador_transacaoAllIgnoreCase(String nome_operador_transacao);
}

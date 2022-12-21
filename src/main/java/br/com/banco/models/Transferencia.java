package br.com.banco.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
//@Table(name = "transferencia", uniqueConstraints = {@UniqueConstraint(columnNames = {"conta_id"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    private Timestamp data_transferencia;
    private double valor;
    private String tipo;
    private String nome_operador_transacao;
   // @ManyToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name = "conta.id")
    private int conta_id;
}

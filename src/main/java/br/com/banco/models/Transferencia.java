package br.com.banco.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
//@Table(name = "transferencia", uniqueConstraints = {@UniqueConstraint(columnNames = {"conta_id"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transferencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "data_transferencia")
    private Date data_transferencia;
    @Column
    private double valor;
    @Column
    private String tipo;
    @Column(name = "nome_operador_transacao")
    private String nome_operador_transacao;
    @Column
    private int conta_id;
}

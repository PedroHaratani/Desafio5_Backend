package br.com.banco.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transferencia")
public class TransferenciaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date data_tranferencia;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = true)
    private String tipo;

    @Column(nullable = true)
    private String nome_operador_transacao;

    @Column
    private int conta_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_tranferencia() {
        return data_tranferencia;
    }

    public void setData_tranferencia(Date data_tranferencia) {
        this.data_tranferencia = data_tranferencia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome_operador_transacao() {
        return nome_operador_transacao;
    }

    public void setNome_operador_transacao(String nome_operador_transacao) {
        this.nome_operador_transacao = nome_operador_transacao;
    }

    public int getConta_id() {
        return conta_id;
    }

    public void setConta_id(int conta_id) {
        this.conta_id = conta_id;
    }
}

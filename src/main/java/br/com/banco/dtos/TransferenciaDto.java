package br.com.banco.dtos;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class TransferenciaDto {

    private LocalDateTime data_tranferencia;

    private double valor;

    private String nome_operador_transacao;

    public LocalDateTime getData_tranferencia() {
        return data_tranferencia;
    }

    public void setData_tranferencia(LocalDateTime data_tranferencia) {
        this.data_tranferencia = data_tranferencia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome_operador_transacao() {
        return nome_operador_transacao;
    }

    public void setNome_operador_transacao(String nome_operador_transacao) {
        this.nome_operador_transacao = nome_operador_transacao;
    }
}

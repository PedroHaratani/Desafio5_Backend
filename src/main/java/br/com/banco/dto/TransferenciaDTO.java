package br.com.banco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaDTO {

    private int id;
    private Timestamp data_transferencia;
    private double valor;
    private String tipo;
    private String nome_operador_transacao;

    private int conta_id;
}

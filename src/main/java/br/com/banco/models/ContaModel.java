package br.com.banco.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="conta")
public class ContaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_conta;
    @Column(nullable = true,length = 80)
    private String nome_responsavel;

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }
}

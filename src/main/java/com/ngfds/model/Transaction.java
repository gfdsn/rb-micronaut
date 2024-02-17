package com.ngfds.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import java.sql.Timestamp;

@MappedEntity(value = "transactions")
public class Transaction {

    @Id
    @GeneratedValue
    private int id;
    private int client_id;
    private int valor;
    private char tipo;
    private String descricao;
    private Timestamp realizada_em;

    public Transaction(int id, int client_id, int valor, char tipo, String descricao, Timestamp realizada_em) {
        this.id = id;
        this.client_id = client_id;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.realizada_em = realizada_em;
    }

    public int getId() {
        return id;
    }

    public int getClient_id() {
        return client_id;
    }

    public int getValor() {
        return valor;
    }

    public char getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Timestamp getRealizada_em() {
        return realizada_em;
    }

}

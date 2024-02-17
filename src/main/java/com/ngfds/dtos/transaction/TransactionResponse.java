package com.ngfds.dtos.transaction;

import io.micronaut.serde.annotation.Serdeable;

import java.sql.Timestamp;

@Serdeable
public class TransactionResponse {

    private int valor;
    private String tipo;
    private String descricao;
    private Timestamp realizada_em;

    public TransactionResponse(int valor, String tipo, String descricao, Timestamp realizada_em) {
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.realizada_em = realizada_em;
    }

    public int getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Timestamp getRealizada_em() {
        return realizada_em;
    }
}

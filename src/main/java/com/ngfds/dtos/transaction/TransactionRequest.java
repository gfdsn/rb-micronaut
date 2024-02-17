package com.ngfds.dtos.transaction;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class TransactionRequest {

    private String valor;
    private char tipo;
    private String descricao;

    public TransactionRequest(String valor, char tipo, String descricao) {
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public int getValor() {
        return Integer.parseInt(valor);
    }

    public char getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean verify(){
        return isAmountValid() && verifyTipo() && verifyDescricao();
    }

    private boolean isAmountValid() {
        if(valor != null) {
            int amount;
            try{
                amount = Integer.parseInt(valor);
            }catch (Exception e){
                return false;
            }
            return amount > 0;
        }
        else return false;
    }

    private boolean verifyTipo(){
        return tipo == 'c' || tipo == 'd';
    }

    private boolean verifyDescricao() {
        return descricao != null && descricao.length() > 0 && descricao.length() <= 10;
    }
}

package com.ngfds.dtos.extract;

import com.ngfds.dtos.transaction.TransactionResponse;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class ExtractResponse {

    private Balance saldo;
    private List<TransactionResponse> ultimas_transacoes;

    public ExtractResponse(Balance saldo, List<TransactionResponse> ultimas_transacoes) {
        this.saldo = saldo;
        this.ultimas_transacoes = ultimas_transacoes;
    }

    public Balance getSaldo() {
        return saldo;
    }

    public List<TransactionResponse> getUltimas_transacoes() {
        return ultimas_transacoes;
    }

}

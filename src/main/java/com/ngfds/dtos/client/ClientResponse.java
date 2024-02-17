package com.ngfds.dtos.client;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ClientResponse {

    private long limite;
    private long saldo;

    public ClientResponse(long limite, long saldo) {
        this.limite = limite;
        this.saldo = saldo;
    }

    public long getLimite() {
        return limite;
    }

    public long getSaldo() {
        return saldo;
    }

}

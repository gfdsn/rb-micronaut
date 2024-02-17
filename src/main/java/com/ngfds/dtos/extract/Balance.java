package com.ngfds.dtos.extract;

import io.micronaut.serde.annotation.Serdeable;

import java.util.Date;

@Serdeable
public class Balance {

    private int total;
    private Date data_extrato;
    private int limite;

    public int getTotal() {
        return total;
    }

    public Date getData_extrato() {
        return data_extrato;
    }

    public int getLimite() {
        return limite;
    }

    public Balance(int total, Date data_extrato, int limite) {
        this.total = total;
        this.data_extrato = data_extrato;
        this.limite = limite;
    }
}

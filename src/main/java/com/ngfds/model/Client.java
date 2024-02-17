package com.ngfds.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity(value = "clients")
public class Client {

    @Id
    @GeneratedValue
    private int id;
    private int limite;
    private int saldo;

    public Client(int id, int limite, int saldo) {
        this.id = id;
        this.limite = limite;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public int getLimite() {
        return limite;
    }

    public int getSaldo() {
        return saldo;
    }
}

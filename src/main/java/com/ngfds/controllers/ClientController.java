package com.ngfds.controllers;

import com.ngfds.dtos.transaction.TransactionRequest;
import com.ngfds.interfaces.ClientInterface;
import com.ngfds.services.ExtractService;
import com.ngfds.services.TransactionService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import jakarta.inject.Inject;

@Controller("/clientes")
public class ClientController implements ClientInterface {

    @Inject private TransactionService transactionService;
    @Inject private ExtractService extractService;

    @Override
    public HttpResponse<?> store(int id, @Body TransactionRequest request) {
        return transactionService.store(id, request);
    }

    @Override
    public HttpResponse<?> get(int id) {
        return extractService.get(id);
    }


}

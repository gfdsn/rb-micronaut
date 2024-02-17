package com.ngfds.services;

import com.ngfds.dtos.client.ClientResponse;
import com.ngfds.dtos.transaction.TransactionRequest;
import com.ngfds.model.Client;
import com.ngfds.repositories.ClientRepository;
import com.ngfds.repositories.TransactionRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.scheduling.annotation.Async;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Singleton
public class TransactionService {

    @Inject protected ClientRepository clientRepository;
    @Inject protected  TransactionRepository transactionRepository;

    @Transactional
    public HttpResponse<?> store(int id, TransactionRequest request) {

        if(!request.verify()) return HttpResponse.status(HttpStatus.UNPROCESSABLE_ENTITY);

        Optional<Client> oClient = clientRepository.findById((long) id);
        if(oClient.isEmpty()) return HttpResponse.status(HttpStatus.NOT_FOUND);

        Client client = oClient.get();
        char tipo = request.getTipo();

        int newBal;

        if (tipo == 'c')
            newBal = transactionRepository.insertCredit(client.getId(), request.getValor(), request.getDescricao(), null);

        else if (tipo == 'd') {

            if (checkBalance(client, request.getValor())) return HttpResponse.status(HttpStatus.UNPROCESSABLE_ENTITY);

            newBal = transactionRepository.insertDebit(client.getId(), request.getValor(), request.getDescricao(), null);

        }
        else return HttpResponse.status(HttpStatus.UNPROCESSABLE_ENTITY);

        return HttpResponse.status(HttpStatus.OK).body(new ClientResponse(client.getLimite(), newBal));

    }

    private boolean checkBalance(Client client, int valor) {
        return client.getSaldo() - valor < client.getLimite() * -1;
    }

}

package com.ngfds.services;

import com.ngfds.dtos.extract.Balance;
import com.ngfds.dtos.extract.ExtractResponse;
import com.ngfds.dtos.extract.ExtractTransaction;
import com.ngfds.dtos.transaction.TransactionResponse;
import com.ngfds.model.Client;
import com.ngfds.repositories.ClientRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

import java.util.*;

@Singleton
public class ExtractService {

    @Inject ClientRepository clientRepository;

    @Transactional
    public HttpResponse<?> get(int id) {

        Optional<Client> oClient = clientRepository.findById((long) id);
        if(oClient.isEmpty()) return HttpResponse.status(HttpStatus.NOT_FOUND);

        Client client = oClient.get();

        List<TransactionResponse> clientTransactions = clientRepository.getTransactions(id).stream()
                .sorted(Comparator.comparing(ExtractTransaction::getRealizada_em).reversed())
                .map(ExtractTransaction::toDto)
            .toList();

        if (clientTransactions.isEmpty()) return  HttpResponse.status(HttpStatus.OK).body(
                new ExtractResponse(new Balance(0, null, client.getLimite()), Collections.emptyList())
        );

        return HttpResponse.status(HttpStatus.OK).body(
                new ExtractResponse(
                        new Balance(client.getSaldo(), new Date(), client.getLimite()),
                        clientTransactions
                )
        );
    }
}

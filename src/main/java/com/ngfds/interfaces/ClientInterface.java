package com.ngfds.interfaces;

import com.ngfds.dtos.client.ClientResponse;
import com.ngfds.dtos.transaction.TransactionRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.concurrent.CompletionStage;

public interface ClientInterface {

    @Post("/{id}/transacoes")
    HttpResponse<?> store(int id, @Body TransactionRequest request);

    @Get("/{id}/extrato")
    HttpResponse<?> get(int id);

}

package com.ngfds.repositories;

import com.ngfds.model.Transaction;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.PageableRepository;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    /* res como placeholder para o return da procedure */
    @Transactional
    @Query(value = "CALL credit(:clientId, :valor, :descricao, :res);", nativeQuery = true)
    int insertCredit(int clientId, int valor, String descricao, @Nullable Integer res);

    @Transactional
    @Query(value = "CALL debit(:clientId, :valor, :descricao, :res);", nativeQuery = true)
    int insertDebit(int clientId, int valor, String descricao, @Nullable Integer res);

}



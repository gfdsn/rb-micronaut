package com.ngfds.repositories;

import com.ngfds.dtos.extract.ExtractTransaction;
import com.ngfds.model.Client;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Override
    @Query("SELECT * FROM clients where id = :aLong FOR UPDATE;")
    @NonNull Optional<Client> findById(@NonNull Long aLong);

    @Query("SELECT * FROM get_transactions(:id)")
    List<ExtractTransaction> getTransactions(int id);
}

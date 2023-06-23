package com.reactive.rpc.repository;

import com.reactive.rpc.entity.BankAccount;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BankAccountRepository extends R2dbcRepository<BankAccount,Integer> {

}

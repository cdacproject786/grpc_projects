package com.reactive.rpc.service;

import com.reactive.rpc.entity.BankAccount;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BankAccountService {

    Mono<com.reactive.rpc.entity.BankAccount> createBankAccount(BankAccount bankAccount);

    Mono<com.reactive.rpc.entity.BankAccount> getBankAccountById(int id);
}

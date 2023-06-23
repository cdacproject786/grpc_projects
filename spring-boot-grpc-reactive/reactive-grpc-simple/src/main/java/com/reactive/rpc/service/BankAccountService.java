package com.reactive.rpc.service;

import com.grpc.bank.service.BankAccount;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BankAccountService {

    Mono<BankAccount> createBankAccount(BankAccount bankAccount);

    Mono<BankAccount> getBankAccountById(int id);
}

package com.reactive.rpc.service;

import com.grpc.bank.service.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    public List<BankAccount> accounts;

    @Override
    public Mono<BankAccount> createBankAccount(BankAccount bankAccount) {
        accounts.add(bankAccount);
        return Mono.just(bankAccount);
    }

    @Override
    public Mono<BankAccount> getBankAccountById(int id) {
        return Mono.just(accounts.get(0));
    }
}

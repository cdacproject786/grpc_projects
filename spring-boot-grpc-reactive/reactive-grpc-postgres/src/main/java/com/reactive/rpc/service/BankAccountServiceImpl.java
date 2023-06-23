package com.reactive.rpc.service;

import com.reactive.rpc.entity.BankAccount;
import com.reactive.rpc.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;
@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public Mono<com.reactive.rpc.entity.BankAccount> createBankAccount(com.reactive.rpc.entity.BankAccount bankAccount) {
        return this.bankAccountRepository.save(bankAccount);
    }

    @Override
    public Mono<BankAccount> getBankAccountById(int id) {
        return this.bankAccountRepository.findById(id);
    }
}

package com.reactive.rpc.endpoint;

import com.grpc.bank.service.BankAccount;
import com.grpc.bank.service.ReactorBankAccountServiceGrpc;
import com.reactive.rpc.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactorBankAccountEndpoint extends ReactorBankAccountServiceGrpc.BankAccountServiceImplBase {

    @Autowired
    private BankAccountService bankAccountService;
    public Mono<BankAccount.CreateBankAccountResponse> createBankAccount(Mono<BankAccount.CreateBankAccountRequest> request) {
        return request.flatMap(req -> bankAccountService.createBankAccount(req))
    }
}

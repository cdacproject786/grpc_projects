package com.reactive.rpc.endpoint;

import com.grpc.bank.service.BankAccount;
import com.grpc.bank.service.BankAccountServiceGrpc;
import com.reactive.rpc.service.BankAccountService;
import io.grpc.stub.StreamObserver;

import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

@GrpcService
public class FrontReactiveService extends BankAccountServiceGrpc.BankAccountServiceImplBase {

    @Autowired
    private BankAccountService bankAccountService;

    @Override
    public BankAccount createBankAccount(BankAccount account, StreamObserver<BankAccount> responseObserver)
    {

        Mono<BankAccount> savedAccount = this.bankAccountService.createBankAccount(account);
        return savedAccount.block();
    }

    @Override
    public BankAccount getBankAccountById(String id, StreamObserver<BankAccount> responseObserver)
    {
        int idInt = Integer.parseInt(id);
        return this.bankAccountService.getBankAccountById(idInt).block();
    }

}

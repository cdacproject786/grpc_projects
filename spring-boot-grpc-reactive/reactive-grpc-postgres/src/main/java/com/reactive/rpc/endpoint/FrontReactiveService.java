package com.reactive.rpc.endpoint;

import com.grpc.bank.service.BankAccount;
import com.grpc.bank.service.BankAccountServiceGrpc;
import com.reactive.rpc.service.BankAccountService;
import io.grpc.stub.StreamObserver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class FrontReactiveService extends BankAccountServiceGrpc.BankAccountServiceImplBase {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BankAccount createBankAccount(BankAccount account, StreamObserver<BankAccount> responseObserver)
    {
        com.reactive.rpc.entity.BankAccount accountEntity = this.modelMapper.map(account, com.reactive.rpc.entity.BankAccount.class);
        Mono<com.reactive.rpc.entity.BankAccount> savedAccount = this.bankAccountService.createBankAccount(accountEntity);
        return this.modelMapper.map(savedAccount,BankAccount.class);
    }

    @Override
    public BankAccount getBankAccountById(String id, StreamObserver<BankAccount> responseObserver)
    {
        int idInt = Integer.parseInt(id);
      Mono<com.reactive.rpc.entity.BankAccount> account = this.bankAccountService.getBankAccountById(idInt);
      return this.modelMapper.map(account, BankAccount.class);
    }

}

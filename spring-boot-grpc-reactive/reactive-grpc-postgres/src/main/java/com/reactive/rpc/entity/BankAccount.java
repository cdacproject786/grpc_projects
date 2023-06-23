package com.reactive.rpc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@Table(name = "bank_acc")
public class BankAccount {

    @Id
    @Column("id")
    private Integer id;

    @Column("EMAIL")
    private String email;

    @Column("FIRST_NAME")
    private String firstName;

    @Column("LAST_NAME")
    private String lastName;

    @Column("ADDRESS")
    private String address;

    @Column("PHONE")

    private String phone;


    @Column("BALANCE")
    private BigDecimal balance;

    @Column("CREATED_AT")
    private LocalDateTime createdAt;

    @Column("UPDATED_AT")
    private LocalDateTime updatedAt;




}

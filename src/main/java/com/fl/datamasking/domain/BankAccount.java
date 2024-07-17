package com.fl.datamasking.domain;

import com.fl.datamasking.annotations.MaskData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @MaskData
    private String accountNumber;
    private double balance;
    @Column(name = "user_id")
    private Long userId;
}
package com.fl.datamasking.domain;

import com.fl.datamasking.annotations.MaskData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "app_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String username;

    @MaskData
    private String password;
    @MaskData
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<BankAccount> bankAccounts;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Card> cards;
}
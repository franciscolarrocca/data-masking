package com.fl.datamasking.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fl.datamasking.annotations.MaskData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    @MaskData
    private String number;
    @JsonFormat(pattern = "MM/yyyy")
    private Date expirationDate;
    @Column(name = "user_id")
    private Long userId;
}
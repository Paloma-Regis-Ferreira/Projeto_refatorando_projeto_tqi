package com.paloma.testeapiemprestimo.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Data
@Document(collection = "loan")
public class Loan{

    @Id
    private String id;

    private Double value;
    private Date firstInstallment;
    private Integer qtdInstallments;

    private List<InstallmentDTO> installmentDTOS = new ArrayList<>();

    public Loan(Double value, Date firstInstallment, Integer qtdInstallments) {
        this.value = value;
        this.firstInstallment = firstInstallment;
        this.qtdInstallments = qtdInstallments;
    }
}

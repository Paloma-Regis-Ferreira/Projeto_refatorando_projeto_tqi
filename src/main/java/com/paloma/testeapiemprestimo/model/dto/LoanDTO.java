package com.paloma.testeapiemprestimo.model.dto;

import com.paloma.testeapiemprestimo.model.Loan;
import lombok.Data;

@Data
public class LoanDTO {

    private String id;
    private Double value;
    private Integer qtdInstallments;

    public LoanDTO(Loan loan){
        this.id = loan.getId();
        this.value = loan.getValue();
        this.qtdInstallments = loan.getQtdInstallments();
    }
}

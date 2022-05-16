package com.paloma.testeapiemprestimo.model.dto;

import com.paloma.testeapiemprestimo.model.Loan;
import lombok.Data;

import java.util.Date;

@Data
public class LoanFormDTO {

    private Double value;
    private Date firstInstallment;
    private Integer qtdInstallments;

    public LoanFormDTO(Double value, Date firstInstallment, Integer qtdInstallments) {
        this.value = value;
        this.firstInstallment = firstInstallment;
        this.qtdInstallments = qtdInstallments;
    }

    public Loan toLoan(){
        Loan loan = new Loan();
        loan.setValue(this.getValue());
        loan.setFirstInstallment(this.getFirstInstallment());
        loan.setQtdInstallments(this.getQtdInstallments());

        return loan;
    }
}

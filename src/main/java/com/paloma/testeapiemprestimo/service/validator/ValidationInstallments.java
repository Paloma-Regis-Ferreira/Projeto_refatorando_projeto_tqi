package com.paloma.testeapiemprestimo.service.validator;

import com.paloma.testeapiemprestimo.model.Loan;

public class ValidationInstallments implements Validation{
    @Override
    public void validar(Loan loan) {
        if (loan.getQtdInstallments()> 60) {
            throw new IllegalArgumentException("excesso de parcelas");
        }
    }
}

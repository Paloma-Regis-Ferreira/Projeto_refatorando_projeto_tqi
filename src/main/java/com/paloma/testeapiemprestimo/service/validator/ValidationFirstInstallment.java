package com.paloma.testeapiemprestimo.service.validator;

import com.paloma.testeapiemprestimo.model.Loan;

import java.util.Date;

public class ValidationFirstInstallment implements Validation{
    @Override
    public void validar(Loan loan) {
        if (loan.getFirstInstallment().getTime() < new Date().getTime()) {
            throw new IllegalArgumentException("data passada anterior a atual");
        }
    }
}

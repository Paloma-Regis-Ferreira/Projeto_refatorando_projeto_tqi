package com.paloma.testeapiemprestimo.service.validator;

import com.paloma.testeapiemprestimo.model.Loan;
import com.paloma.testeapiemprestimo.service.tools.AddMonth;

import java.util.Date;

public class ValidationMaximumMonths implements Validation{
    @Override
    public void validar(Loan loan) {
        Date today = new Date();
        Date maximun = new AddMonth().executeAddMonth(today, 3);

        if (loan.getFirstInstallment().getTime() > maximun.getTime()){
            throw new IllegalArgumentException("maximo de tempo permitido");
        }
    }
}

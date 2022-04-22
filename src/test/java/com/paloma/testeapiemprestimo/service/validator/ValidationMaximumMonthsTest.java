package com.paloma.testeapiemprestimo.service.validator;

import com.paloma.testeapiemprestimo.model.Loan;
import com.paloma.testeapiemprestimo.service.LoanService;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ValidationMaximumMonthsTest {

    @Test
    public void naoDeveriaPermitirQuantidadeDeParcelasMaiorQue60(){
        Loan loan = new Loan(600.00, new Date(), 70);
        assertThrows(IllegalArgumentException.class, () -> new LoanService().create(loan));
    }

}
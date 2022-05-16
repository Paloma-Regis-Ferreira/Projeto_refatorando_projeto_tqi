package com.paloma.testeapiemprestimo.service.validator;

import com.paloma.testeapiemprestimo.model.dto.LoanFormDTO;
import com.paloma.testeapiemprestimo.service.LoanService;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ValidationMaximumMonthsTest {

    @Test
    public void naoDeveriaPermitirQuantidadeDeParcelasMaiorQue60(){
        LoanFormDTO loan = new LoanFormDTO(600.00, new Date(), 70);
        assertThrows(IllegalArgumentException.class, () -> new LoanService().create(loan));
    }

}
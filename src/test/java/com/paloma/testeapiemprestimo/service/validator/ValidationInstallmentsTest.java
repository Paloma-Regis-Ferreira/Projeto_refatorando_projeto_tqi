package com.paloma.testeapiemprestimo.service.validator;

import com.paloma.testeapiemprestimo.model.dto.LoanFormDTO;
import com.paloma.testeapiemprestimo.service.LoanService;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ValidationInstallmentsTest {

    @Test
    public void naoDeveriaPermitirDataDaPrimeiraParcelaAnteriorAHoje(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse("01/01/1990");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LoanFormDTO loan = new LoanFormDTO(600.00, date, 2);
        assertThrows(IllegalArgumentException.class, () -> new LoanService().create(loan));
    }

}
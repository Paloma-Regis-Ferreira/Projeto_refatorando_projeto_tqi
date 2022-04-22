package com.paloma.testeapiemprestimo.service.validator;

import com.paloma.testeapiemprestimo.model.Loan;
import com.paloma.testeapiemprestimo.service.LoanService;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ValidationFirstInstallmentTest {

    @Test
    public void naoDeveriaPermitirDataDaPrimeiraParcelaMaiorQueTresMeses(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse("10/10/3000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Loan loan = new Loan(600.00, date, 2);
        assertThrows(IllegalArgumentException.class, () -> new LoanService().create(loan));
    }

}
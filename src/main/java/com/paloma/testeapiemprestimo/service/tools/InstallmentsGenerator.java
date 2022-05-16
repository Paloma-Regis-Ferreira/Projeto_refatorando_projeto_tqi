package com.paloma.testeapiemprestimo.service.tools;

import com.paloma.testeapiemprestimo.model.vo.InstallmentVO;
import com.paloma.testeapiemprestimo.model.Loan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InstallmentsGenerator {

    private Loan loan;

    public InstallmentsGenerator (Loan loan){
        this.loan = loan;
    }

    public Loan getLoan() {
        return this.loan;
    }

    public Loan generator(){
        Double resultPrice = this.loan.getValue() / this.loan.getQtdInstallments(); //preco de cada parcela
        List<InstallmentVO> installmentsVO = new ArrayList<>();
        Date date = this.loan.getFirstInstallment();

        for (int i = 0; i < this.loan.getQtdInstallments(); i++) {
            installmentsVO.add(new InstallmentVO(i + 1, resultPrice, new AddMonth().executeAddMonth(date, i)));//adicionando mes a mes na lista de parcelas e valor
        }

        this.loan.setInstallmentsVO(installmentsVO);//completando o emprestimo enviado pelo cliente com a lista de parcelas

        return this.loan;//retornando emprestimo pronto
    }
}

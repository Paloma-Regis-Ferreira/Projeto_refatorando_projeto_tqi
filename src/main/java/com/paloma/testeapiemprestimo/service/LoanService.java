package com.paloma.testeapiemprestimo.service;

import com.paloma.testeapiemprestimo.model.Loan;
import com.paloma.testeapiemprestimo.model.dto.LoanDTO;
import com.paloma.testeapiemprestimo.model.dto.LoanFormDTO;
import com.paloma.testeapiemprestimo.repository.LoanRepository;
import com.paloma.testeapiemprestimo.service.tools.InstallmentsGenerator;
import com.paloma.testeapiemprestimo.service.validator.ValidationFirstInstallment;
import com.paloma.testeapiemprestimo.service.validator.ValidationInstallments;
import com.paloma.testeapiemprestimo.service.validator.ValidationMaximumMonths;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    public Loan findById(String id) {
        Optional<Loan> loan = repository.findById(id);
        return loan.orElseThrow(() -> new IllegalArgumentException("Objeto não encontrado"));//fazer tratamento da exceção
    }

    public List<LoanDTO> findAll() {
        List<Loan> loans = repository.findAll();
        List<LoanDTO> loanDTOs = new ArrayList<>();
        for (Loan loan: loans) {
            loanDTOs.add(new LoanDTO(loan));
        }
        return loanDTOs;
    }

    public Loan create(LoanFormDTO newLoan) {
        Loan loan = newLoan.toLoan();

        new ValidationMaximumMonths().validar(loan);
        new ValidationFirstInstallment().validar(loan);
        new ValidationInstallments().validar(loan);

        InstallmentsGenerator gerarParcelas = new InstallmentsGenerator(loan);
        loan = gerarParcelas.generator();

        return repository.insert(loan);
    }

    @NotNull
    public Loan update(@NotNull LoanFormDTO updateLoanDTO, String id) {
        Loan loan = updateLoanDTO.toLoan();
        loan.setId(id);

        Loan updateLoan = findById(loan.getId());

        new ValidationMaximumMonths().validar(updateLoan);
        new ValidationFirstInstallment().validar(updateLoan);
        new ValidationInstallments().validar(updateLoan);

        updateLoan.setValue(loan.getValue());
        updateLoan.setFirstInstallment(loan.getFirstInstallment());
        updateLoan.setQtdInstallments(loan.getQtdInstallments());

        InstallmentsGenerator gerarParcelas = new InstallmentsGenerator(loan);
        updateLoan = gerarParcelas.generator();

        repository.save(updateLoan);
        return updateLoan;
    }

    public void delete(String id) {
        this.findById(id);
        repository.deleteById(id);
    }
}

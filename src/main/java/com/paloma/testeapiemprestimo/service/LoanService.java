package com.paloma.testeapiemprestimo.service;

import com.paloma.testeapiemprestimo.model.Loan;
import com.paloma.testeapiemprestimo.repository.LoanRepository;
import com.paloma.testeapiemprestimo.service.tools.InstallmentsGenerator;
import com.paloma.testeapiemprestimo.service.validator.ValidationFirstInstallment;
import com.paloma.testeapiemprestimo.service.validator.ValidationInstallments;
import com.paloma.testeapiemprestimo.service.validator.ValidationMaximumMonths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Loan> findAll() {
        List<Loan> loans = repository.findAll();
        return loans;
    }

    public Loan create(Loan newLoan) {

        new ValidationMaximumMonths().validar(newLoan);
        new ValidationFirstInstallment().validar(newLoan);
        new ValidationInstallments().validar(newLoan);

        InstallmentsGenerator gerarParcelas = new InstallmentsGenerator(newLoan);
        newLoan = gerarParcelas.generator();

        return repository.insert(newLoan);
    }

    public void update(Loan updateLoan, String id) {
        Loan loan = this.findById(id);

        new ValidationMaximumMonths().validar(updateLoan);
        new ValidationFirstInstallment().validar(updateLoan);
        new ValidationInstallments().validar(updateLoan);

        loan.setValue(updateLoan.getValue());
        loan.setFirstInstallment(updateLoan.getFirstInstallment());
        loan.setQtdInstallments(updateLoan.getQtdInstallments());

        InstallmentsGenerator gerarParcelas = new InstallmentsGenerator(updateLoan);
        loan = gerarParcelas.generator();

        repository.save(loan);
    }

    public void delete(String id) {
        this.findById(id);
        repository.deleteById(id);
    }
}

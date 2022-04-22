package com.paloma.testeapiemprestimo.repository;

import com.paloma.testeapiemprestimo.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends MongoRepository<Loan, String> {
}

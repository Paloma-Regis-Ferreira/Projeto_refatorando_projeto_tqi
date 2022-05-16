package com.paloma.testeapiemprestimo.resource;

import com.paloma.testeapiemprestimo.model.Loan;
import com.paloma.testeapiemprestimo.model.dto.LoanDTO;
import com.paloma.testeapiemprestimo.model.dto.LoanFormDTO;
import com.paloma.testeapiemprestimo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/loans")
public class LoanResource {

    @Autowired
    private LoanService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<Loan> findById(@PathVariable String id){
        Loan loan = service.findById(id);
        return ResponseEntity.ok().body(loan);
    }

    @GetMapping
    public ResponseEntity<List<LoanDTO>> findAll(){
        List<LoanDTO> loans = service.findAll();
        return ResponseEntity.ok().body(loans);
    }

    @PostMapping
    public ResponseEntity<Loan> create(@RequestBody LoanFormDTO newLoan){
        Loan loan = service.create(newLoan);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(loan.getId()).toUri();
        return ResponseEntity.created(uri).body(loan);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Loan> update (@PathVariable String id, @RequestBody LoanFormDTO updateLoan){
        Loan loan = service.update(updateLoan, id);
        return ResponseEntity.ok(loan);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

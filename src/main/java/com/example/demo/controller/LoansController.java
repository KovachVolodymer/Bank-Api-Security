package com.example.demo.controller;

import com.example.demo.model.Loans;
import com.example.demo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam String id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }

    @PatchMapping("/patch")
    public void patchLoan(@RequestParam String id, @RequestParam String status){
        Loans loan = loanRepository.findById(id).get();
        loan.setStatus(status);
        loanRepository.save(loan);
    }

    // Add a new endpoint to get the loan details for a specific account
    @GetMapping("/myLoan")
    public List<Loans> forMy(@RequestParam String id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }

    @DeleteMapping
    public void deleteLoan(@RequestParam String id){
        loanRepository.deleteById(id);
    }

    @PostMapping("/add")
    public void addLoan(@RequestBody Loans loan){
        loanRepository.save(loan);
    }

    @PutMapping("/update")
    public void updateLoan(@RequestBody Loans loan){
        loanRepository.save(loan);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/allLoans")
    public List<Loans> getAllLoans(){
        return loanRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/loan")
    public List<Loans> getLoan(@RequestParam String id){
        return loanRepository.findByCustomerIdOrderByStartDtDesc(id);
    }
    
}

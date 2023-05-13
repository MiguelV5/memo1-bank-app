package com.aninfo.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.aninfo.exceptions.InvalidTransactionTypeException;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }

    public Collection<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public Transaction createTransaction(Double amount, String type, Long cbu) {

        if(type.equals("withdraw")) {
            accountService.withdraw(cbu, amount);
        }
        else if(type.equals("deposit")){
            accountService.deposit(cbu, amount);
        }else{
            throw new InvalidTransactionTypeException("Invalid transaction type. Use 'deposit' or 'withdraw'.");
        }

        Transaction transaction = new Transaction(amount, type, cbu);
        return transactionRepository.save(transaction);
    }

    public Collection<Transaction> getTransactionsByCbu(Long cbu) {

        List<Transaction> transactionsCbu = new ArrayList<Transaction>();
        List<Transaction> all = transactionRepository.findAll();

        for (Transaction transaction: all) {
            if (transaction.getCbu().equals(cbu)) {
                transactionsCbu.add(transaction);
            }
        }
        return transactionsCbu;
    }
}
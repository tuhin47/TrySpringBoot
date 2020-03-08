package com.tuhin.springboot.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalService {
    @Autowired
    TransactionRepository transactionRepository;

    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(long to, long from, int amount) throws Exception {
        debitFromAccount(from, amount);
        creditToAccount(to, amount);
    }

    public void debitFromAccount(long from, int amount) {
        //do staff and debited money from data base
        Account account = transactionRepository.findAccountById(from);
        account.setAmmount(account.getAmmount() + amount);
        transactionRepository.save(account);
    }

    public void creditToAccount(long to, int amount) throws Exception {
        //do straff
        Account account = transactionRepository.findAccountById(to);
        account.setAmmount(account.getAmmount() - amount);
        transactionRepository.save(account);
        throw new Exception("Error during credit");
    }

}

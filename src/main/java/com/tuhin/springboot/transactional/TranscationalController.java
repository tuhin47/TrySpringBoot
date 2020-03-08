package com.tuhin.springboot.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TranscationalController {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionalService transactionalService;

    @RequestMapping(method = RequestMethod.POST, value = "/accounts")
    public void saveAccounts(@RequestBody Account account) {
        transactionRepository.save(account);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/transfer")
    public void transfer(@RequestParam long from, @RequestParam long to,
                         @RequestParam int ammount) throws Exception {
        transactionalService.transferMoney(from, to, ammount);
    }
}

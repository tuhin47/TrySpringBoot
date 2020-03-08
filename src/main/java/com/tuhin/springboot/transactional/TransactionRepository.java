package com.tuhin.springboot.transactional;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Account, Long> {
    Account findOneAccountById(long id);
}

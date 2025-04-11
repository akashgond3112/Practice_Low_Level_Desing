package com.java.lld.design.java;


import com.java.lld.design.java.model.Account;
import com.java.lld.design.java.model.common.Tag;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findById(String id);
    Optional<Account> findByUsername(String username);
    List<Account> findAll();
    List<Account> findByTag(Tag tag);
    void deleteById(String id);
}

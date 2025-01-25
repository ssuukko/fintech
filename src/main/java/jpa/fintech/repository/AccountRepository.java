package jpa.fintech.repository;

import jpa.fintech.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);
}
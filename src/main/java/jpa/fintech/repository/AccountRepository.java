package jpa.fintech.repository;

import jpa.fintech.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountId(Long accountId);

    List<Account> findByUserId(Long userId);

}

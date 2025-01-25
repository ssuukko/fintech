package jpa.fintech.service;

import jpa.fintech.entity.Transaction;
import jpa.fintech.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Transactional
    public Long createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return transaction.getId();
    }

    public Transaction findOne(Long transactionId) {
        return transactionRepository.findById(transactionId).get();
    }

    public List<Transaction> findByAccountId(Long accountId) {
        return transactionRepository.findByAccountIdOrderByTransactionDateDesc(accountId);
    }
}

package jpa.fintech.service;

import jpa.fintech.entity.Transaction;
import jpa.fintech.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    // 계좌 내역
    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}

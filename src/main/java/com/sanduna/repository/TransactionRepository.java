package com.sanduna.repository;

import com.sanduna.dao.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Long > {
}

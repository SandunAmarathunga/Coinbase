package com.sanduna.repository;

import com.sanduna.dao.Coins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinbaseRepository extends JpaRepository<Coins, Long> {
}

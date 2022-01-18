package com.sanduna.service;

import com.sanduna.dao.Coins;
import com.sanduna.dao.Transactions;
import com.sanduna.repository.CoinbaseRepository;
import com.sanduna.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinbaseService {

    @Autowired
    private CoinbaseRepository coinbaseRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Coins> getAllCoins() {
        List<Coins> coins = coinbaseRepository.findAll();
        return coins;
    }

    public void addCoin(Coins coin) {
        coinbaseRepository.save(coin);
    }

    public void updateCoin(Coins coin) {
        coinbaseRepository.save(coin);
    }

    public void buyCoin(Transactions transaction) {
        transaction.setType("BUY");
        transactionRepository.save(transaction);
    }

    public void sellCoin(Transactions transaction) {
        transaction.setType("SELL");
        transactionRepository.save(transaction);
    }

    public void updateCoinTransaction(Transactions transaction) {
        transactionRepository.save(transaction);
    }

    public void cancelTransaction(Transactions transaction) {
        transactionRepository.delete(transaction);
    }

//    public void cancelTransaction(Long id) {
//        transactionRepository.deleteById(id);
//    }

    public List<Transactions> getAllTransactions() {
        return transactionRepository.findAll();
    }
}

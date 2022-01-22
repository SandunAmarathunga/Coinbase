package com.sanduna.controller;

import com.sanduna.dao.Coins;
import com.sanduna.dao.Transactions;
import com.sanduna.service.CoinbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CoinbaseController {

    @Autowired
    private CoinbaseService coinbaseService;

    @RequestMapping("/coins")
    public List<Coins> getAllCoins(){
        return coinbaseService.getAllCoins();
    }

    @RequestMapping(method = RequestMethod.POST, value="/coins")
    public void addCoin(@RequestBody Coins coin){
        coinbaseService.addCoin(coin);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/coins/update")
    public void updateCoin(@RequestBody Coins coin){
        coinbaseService.updateCoin(coin);
    }

    @RequestMapping(method = RequestMethod.POST, value="/buy")
    public void buyCoin(@RequestBody Transactions transaction){
        coinbaseService.buyCoin(transaction);
    }

    @RequestMapping(method = RequestMethod.POST, value="/sell")
    public void sellCoin(@RequestBody Transactions transaction){
        coinbaseService.sellCoin(transaction);
    }

    @RequestMapping(method = RequestMethod.GET, value="/transactions")
    public List<Transactions> getAllTransactions(){
        return coinbaseService.getAllTransactions();
    }

    @RequestMapping(method = RequestMethod.POST, value="/update")
    public void updateTransaction(@RequestBody Transactions transaction){
        coinbaseService.updateCoinTransaction(transaction);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/cancel")
    public void cancelTransaction(@RequestBody Transactions transaction){
        coinbaseService.cancelTransaction(transaction);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/cancel/{id}")
    public void cancelTransaction(@PathVariable Long id){
        coinbaseService.cancelTransaction(id);
    }

}

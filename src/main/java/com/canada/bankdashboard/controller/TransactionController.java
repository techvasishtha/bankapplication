package com.canada.bankdashboard.controller;

import com.canada.bankdashboard.dto.AccountTransactionRequest;
import com.canada.bankdashboard.entity.AccountInfo;
import com.canada.bankdashboard.entity.AccountTransaction;

import com.canada.bankdashboard.services.AccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TransactionController {


    @Autowired
    AccountTransactionService accountTransactionService;


    /*
     *
     * Get Transactions API */

    @PostMapping("/getTransactions")
    public List<AccountTransaction> getTransactions(@RequestBody AccountTransactionRequest accountTransactionRequest) {

        List<AccountTransaction> accountTransactionList = null;

        if(accountTransactionRequest!=null) {
            accountTransactionList = accountTransactionService.getTransactionsByRange(accountTransactionRequest);

        }

        return accountTransactionList;

    }

    /*
     *
     * Post Transactions API */

    @PostMapping("/doTransaction")
    public String doTransaction(@RequestBody AccountTransaction accountTransaction) {


        String message = "";
        if(accountTransaction!=null) {
          message =   accountTransactionService.saveTransaction(accountTransaction);
        }

       return message;
    }

    /*
     *
     * Adding New Account API
     * accountType = 1- cheq, 2- business, 3-current, 4- saving
     * */

    @PostMapping("/addAccount")
    public String addAccount(@RequestBody AccountInfo accountInfo) {


        String message = "Request Invalid";
        if(accountInfo!=null) {
            message =   accountTransactionService.addAccount(accountInfo);
        }

        return message;
    }


}

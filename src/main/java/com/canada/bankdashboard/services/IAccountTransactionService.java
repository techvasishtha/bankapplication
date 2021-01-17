package com.canada.bankdashboard.services;

import com.canada.bankdashboard.dto.AccountTransactionRequest;
import com.canada.bankdashboard.entity.AccountInfo;
import com.canada.bankdashboard.entity.AccountTransaction;

import java.util.List;

public  interface IAccountTransactionService {

    String saveTransaction(AccountTransaction accountTransaction);

    List<AccountTransaction> getTransactionsByRange(AccountTransactionRequest accountTransactionRequest);

    String addAccount(AccountInfo accountInfo);
}

package com.canada.bankdashboard.services;
import com.canada.bankdashboard.dto.AccountTransactionRequest;
import com.canada.bankdashboard.entity.AccountInfo;
import com.canada.bankdashboard.entity.AccountTransaction;
import com.canada.bankdashboard.repository.AccountInfoRepository;
import com.canada.bankdashboard.repository.AccountTransactionRepository;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public  class AccountTransactionService implements IAccountTransactionService{


    private  final AccountTransactionRepository accountTransactionRepository;

    private  final AccountInfoRepository accountInfoRepository;


    public AccountTransactionService(AccountTransactionRepository accountTransactionRepository, AccountInfoRepository accountInfoRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
        this.accountInfoRepository  = accountInfoRepository;
    }


    @Override
    public List<AccountTransaction>getTransactionsByRange(AccountTransactionRequest accountTransactionRequest) {

        Date startDate = accountTransactionRequest.getStartDate();
        Date endDate = accountTransactionRequest.getEndDate();
        String transType = accountTransactionRequest.getTransType();
        int accountNumber  = accountTransactionRequest.getAccountNumber();
        List<AccountTransaction> accountTransactionList = null;

        if(startDate!=null && endDate!=null && transType!=null){
            accountTransactionList =  accountTransactionRepository.findByAll(
                    accountNumber,
                    transType,
                    startDate,
                    endDate
            );

        } else if(startDate==null && endDate==null && transType!=null) {
            accountTransactionList =  accountTransactionRepository.findByTransType(accountNumber, transType);

        } else if(startDate!=null && endDate!=null && transType==null) {
            accountTransactionList =  accountTransactionRepository.findByDates(accountNumber, startDate, endDate);

        }

        return accountTransactionList;


    }

    @Override
    public String saveTransaction(AccountTransaction accountTransaction){
        try {
            int accountNumber = accountTransaction.getAccountNumber();
            int userId = accountTransaction.getCreatedBy();
            String transType = accountTransaction.getTransType();
            int currentBalance=0;
            int transAmt = accountTransaction.getTransAmt();
            int accountType = accountTransaction.getAccountType();
            accountTransactionRepository.save(accountTransaction);

           AccountInfo accountInfo =  accountInfoRepository.findByAccountNumberAndAccountType(accountNumber, accountType);
            int previousBalance = accountInfo.getBalance();
           if(transType.equals("D")) {
                currentBalance = previousBalance + transAmt;
            } else if(transType.equals("W")) {
                currentBalance = previousBalance - transAmt;
            }

            accountInfo.setBalance(currentBalance);
            this.updateAccountInfo(accountInfo);
            return "Transaction Successfully Executed ";
        }
        catch(Exception e){
            return "Transaction Not Successfully Executed";
        }


    }


    private void updateAccountInfo(AccountInfo accountInfo){
        try {

            accountInfoRepository.save(accountInfo);

        }
        catch(Exception e){

        }
    }

    @Override
    public String addAccount(AccountInfo accountInfo){
        try {

            accountInfoRepository.save(accountInfo);


            return "Successfully Account Created";
        }
        catch(Exception e){
            return "Account Not created Successfully";
        }

    }



}

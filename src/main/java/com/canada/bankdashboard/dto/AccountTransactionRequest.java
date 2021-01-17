package com.canada.bankdashboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public  class AccountTransactionRequest {

    private int accountNumber;
    private String transType;
    private Date startDate;
    private Date endDate;

}

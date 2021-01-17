package com.canada.bankdashboard.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="Account_Transaction")

public class AccountTransaction {

    @Id
    @Column(name="trans_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trans_id_generator")
    @SequenceGenerator(name="trans_id_generator", initialValue = 1, allocationSize = 1,sequenceName = "trans_id_seq")
    private int transId;


    @Column(name="account_number")
    private int accountNumber;

    @Column(name="trans_type")
    private String transType;

    @Column(name="trans_amt")
    private int transAmt;

    @Column(name="account_type")
    private int accountType;

    @Column(name="created_date")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name="created_by")
    private int createdBy;



    public AccountTransaction(int accountNumber, String transType, int transAmt, int accountType, Date createdDate, int createdBy) {
        this.accountNumber = accountNumber;
        this.transType = transType;
        this.transAmt = transAmt;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.accountType = accountType;
    }

    public AccountTransaction() {
    }



}

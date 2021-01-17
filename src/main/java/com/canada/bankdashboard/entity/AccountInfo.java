package com.canada.bankdashboard.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="Account_Info")

public class AccountInfo {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_info_id_generator")
    @SequenceGenerator(name="account_info_id_generator", initialValue = 1, allocationSize = 1,sequenceName = "account_info_id_seq")
    private int id;


    @Column(name="account_number")
    private int accountNumber;

    @Column(name="account_type")
    private int accountType;

    @Column(name="user_id")
    private int userId;

    @Column(name="balance")
    private int balance;

    @Column(name="created_date")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name="created_by")
    private int createdBy;

    @Column(name="last_updated_date")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date lastUpdatedDate;

    @Column(name="last_updated_by")
    private int lastUpdatedBy;


    public AccountInfo(int accountNumber, int accountType, int user_id, int balance, Date createdDate, int createdBy, Date lastUpdatedDate, int lastUpdatedBy) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.userId = user_id;
        this.balance = balance;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public AccountInfo() {
    }



}

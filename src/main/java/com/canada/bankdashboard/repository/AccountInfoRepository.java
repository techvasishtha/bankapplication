package com.canada.bankdashboard.repository;

import com.canada.bankdashboard.entity.AccountInfo;
import com.canada.bankdashboard.entity.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AccountInfoRepository extends CrudRepository<AccountInfo, Long> {

   AccountInfo findByAccountNumberAndAccountType(int accountNumber, int accountType);


}

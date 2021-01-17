package com.canada.bankdashboard.repository;

import com.canada.bankdashboard.entity.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

  @Query(value = " Select trans_id, account_number, trans_type, trans_Amt, account_type, created_by, created_date FROM account_transaction at WHERE account_number = ?1  And created_date Between ?2 And ?3", nativeQuery = true)
   List<AccountTransaction> findByDates(
            int accountNumber,
            Date startDate,
            Date endDate
   );

    @Query(value = " Select trans_id, account_number, trans_type, trans_Amt, account_type, created_by, created_date FROM account_transaction at WHERE account_number = ?1 OR trans_type = ?2 And created_date Between ?3 And ?4", nativeQuery = true)
    List<AccountTransaction> findByAll(
            int accountNumber,
            String transType,
            Date startDate,
            Date endDate
    );

    @Query(value = " Select trans_id, account_number, trans_type, trans_Amt, account_Type, created_by, created_date FROM account_transaction at WHERE account_number = ?1 And trans_type = ?2", nativeQuery = true)
    List<AccountTransaction> findByTransType(int accountNumber, String transType);


}

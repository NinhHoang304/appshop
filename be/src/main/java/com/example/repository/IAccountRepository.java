package com.example.repository;

import com.example.dto.IAccountDTO;
import com.example.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findAccountById(Long id);

    Account findAccountByEmail(String email);

    @Query(value = "SELECT c.id as cartId FROM account a join cart c on a.account_id = c.account_id where c.account_id = :accountId ", nativeQuery = true)
    IAccountDTO findCartIdByAccountId(@Param("accountId") Long accountId);
}

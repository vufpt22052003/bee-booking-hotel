package com.example.beebookinghotel.repository;

import com.example.beebookinghotel.entity.Account;
import com.example.beebookinghotel.model.dto.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("select u from users u where  u.email = ?1 ")
    Optional<Account> findByEmail(String sdt);


}

package com.example.beebookinghotel.Service;

import com.example.beebookinghotel.entity.Account;
import com.example.beebookinghotel.model.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountService {
    public Optional<Account> findByEmail(String email);


}

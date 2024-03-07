package com.example.beebookinghotel.Service.impl;

import com.example.beebookinghotel.Service.AccountService;
import com.example.beebookinghotel.entity.Account;
import com.example.beebookinghotel.mapper.UserMapper;
import com.example.beebookinghotel.model.dto.AccountDto;
import com.example.beebookinghotel.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<Account> findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }


}

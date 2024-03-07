package com.example.beebookinghotel.mapper;


import com.example.beebookinghotel.entity.Account;
import com.example.beebookinghotel.model.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class UserMapper implements Function<Account, AccountDto> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public AccountDto apply(Account user) {
        return AccountDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .phone(user.getPhone()==null ?"":user.getPhone())
                .email(user.getEmail())
                .password(user.getPassword())
                .active(user.isActive())
                .role(user.getRole()).build();

        
    }

    public Account applyToUser(AccountDto userDto){
        return Account.builder()
                .fullname(userDto.getFullname())
                .phone(userDto.getPhone())
                .role(userDto.getRole())
                .id(userDto.getId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .active(userDto.isActive())
                .isDelete(false)
                .build();
    }
}

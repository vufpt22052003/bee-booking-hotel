package com.example.beebookinghotel.Service;

import com.example.beebookinghotel.entity.Account;
import com.example.beebookinghotel.enums.Role;
import com.example.beebookinghotel.mapper.UserMapper;
import com.example.beebookinghotel.model.dto.AccountDto;
import com.example.beebookinghotel.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final AccountRepository accountRepository;

    public void processOAuthPostLogin(OAuth2User oAuth2User) {
        String email = oAuth2User.getAttribute("email");
        String avatar = oAuth2User.getAttribute("picture");
        String username = oAuth2User.getAttribute("name");
        Optional<Account> existingUser = accountRepository.findByEmail(email);

        if (!existingUser.isPresent()) {
            Account newUser = new Account();
            newUser.setUsername(username != null ? username : email);
            newUser.setFullname(username != null ? username : email);
            newUser.setEmail(email);
            newUser.setDelete(false);
            newUser.setPhone("LOGIN GOOGLE");
            newUser.setPassword("LOGIN GOOGLE");
            newUser.setRole(Role.ROLE_USER);
            accountRepository.save(newUser);
        } else {
            // Người dùng đã tồn tại trong cơ sở dữ liệu, cập nhật thông tin
            Account existingUserAccount = existingUser.get();
            existingUserAccount.setUsername(username != null ? username : email);
            existingUserAccount.setEmail(email);
            accountRepository.save(existingUserAccount);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findByEmail(email);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            String role = account.getRole().toString();
            if (role.startsWith("ROLE_")) {
                role = role.substring("ROLE_".length());
            }
            return User.withUsername(account.getEmail())
                    .password(account.getPassword())
                    .roles(role)
                    .build();
        } else {
            throw new UsernameNotFoundException("user not found: " + email);
        }
    }


}

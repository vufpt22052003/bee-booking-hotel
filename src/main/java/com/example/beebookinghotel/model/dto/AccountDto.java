package com.example.beebookinghotel.model.dto;

import com.example.beebookinghotel.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

    private Long id;

    private String username;

    private String fullname;

    private String phone;

    private String email;

    private String password;

    private boolean isDelete;

    private boolean active;

    private String confirmPassword;

    private Role role;

}

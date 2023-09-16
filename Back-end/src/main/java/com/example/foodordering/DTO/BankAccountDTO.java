package com.example.foodordering.DTO;

import com.example.foodordering.DTO.BaseDTO.AccountDTO;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString()
public class BankAccountDTO extends AccountDTO {
    private String captcha;
}

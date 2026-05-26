package com.springlearning.spring_practice_may_26.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String refreshToken;
    private String accessToken;
}

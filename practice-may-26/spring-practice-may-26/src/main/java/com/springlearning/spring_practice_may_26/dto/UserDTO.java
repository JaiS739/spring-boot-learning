package com.springlearning.spring_practice_may_26.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String email;
}

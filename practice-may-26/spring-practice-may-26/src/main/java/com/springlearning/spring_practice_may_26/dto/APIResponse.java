package com.springlearning.spring_practice_may_26.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class APIResponse<T> {
    private String message;

    private T data;
}

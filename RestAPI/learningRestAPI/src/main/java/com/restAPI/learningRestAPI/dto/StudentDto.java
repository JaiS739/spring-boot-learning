package com.restAPI.learningRestAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class StudentDto {
    private long id;
    private String name;
    private String email;

    // no-args constructor
    public StudentDto() {}

    // all-args constructor
    public StudentDto(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // getters
    public long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    // setters
    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}

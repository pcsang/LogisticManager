package com.express.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String email;
    private String name;
    private String password;
    private String gender;
    private String address;
    private String numbersPhone;

    public String getEmail() {
         return this.email;
    }
}

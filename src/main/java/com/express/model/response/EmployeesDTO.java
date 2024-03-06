package com.express.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesDTO {
    private String id;
    private String email;
    private String name;
    private String password;
    private String gender;
    private String address;
    private String numbersPhone;
}

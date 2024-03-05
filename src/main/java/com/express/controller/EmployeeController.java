package com.express.controller;

import com.express.model.UserEmployee;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/employee/v1")
public class EmployeeController {


    @GetMapping("")
    public Set<UserEmployee> getAll() {
        Set<UserEmployee> userEmployees = new HashSet<>(  );
        return userEmployees;
    }

    @GetMapping("")
    public UserEmployee getEmployeeById(@RequestParam String id) {
        return new UserEmployee();
    }

    @PostMapping("/register")
    public UserEmployee registerEmployee(@RequestBody UserEmployee userEmployee) {
        return userEmployee;
    }

    @PostMapping("/update")
    public UserEmployee updateEmployee(@RequestBody UserEmployee userEmployee) {
        return userEmployee;
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestParam String idEmployee) {

    }
}

package com.express.service;

import com.express.model.UserEmployee;
import com.express.model.request.Employee;
import com.express.model.response.EmployeesDTO;
import com.express.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    /**
     * Constructor of EmployeeService
     *
     * @param employeeRepository employeeRepository
     */
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeesDTO> getAllEmployees() {
        List<UserEmployee> employees = employeeRepository.findAll();
        List<EmployeesDTO> employeesDTOS = new ArrayList<>();
        for(UserEmployee u : employees) {
            EmployeesDTO employeesDTO = new EmployeesDTO();
            BeanUtils.copyProperties(u, employeesDTO);
            employeesDTOS.add(employeesDTO);
        }
        return employeesDTOS;
    }


    public EmployeesDTO getEmployeeById(String id) {
        UserEmployee employee = employeeRepository.getReferenceById(id);
        EmployeesDTO employeesDTO = new EmployeesDTO();
        BeanUtils.copyProperties(employee, employeesDTO);

        return employeesDTO;
    }

    public EmployeesDTO postEmployee(Employee userEmployee) {
        List<UserEmployee> employeeExisted = employeeRepository.findEmployeeByEmail(userEmployee.getEmail());
        if (!ObjectUtils.isEmpty(employeeExisted)) {
            throw new IllegalArgumentException("Email existed!");
        }
        String idEmployee = UUID.randomUUID().toString();
        UserEmployee user = new UserEmployee();
        BeanUtils.copyProperties(userEmployee, user);
        user.setId(idEmployee);

        UserEmployee userSaved = employeeRepository.save(user);

        EmployeesDTO employeesDTO = new EmployeesDTO();
        BeanUtils.copyProperties(userSaved, employeesDTO);
        return employeesDTO;
    }
}

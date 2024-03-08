package com.express.repository;

import com.express.model.UserEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<UserEmployee, String> {
//    @Query("SELECT e  FROM user_employee e WHERE e.email = ?1")
//    UserEmployee findByEmail(String email);

}

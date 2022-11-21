package it.fornaroale.SpringbootCrud.repo;

import it.fornaroale.SpringbootCrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
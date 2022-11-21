package it.fornaroale.SpringbootCrud.service;

import it.fornaroale.SpringbootCrud.model.Employee;

import java.util.List;

public interface IEmployeeService {

    void saveEmployee(Employee emp);
    List<Employee> getAllEmployees();
    void deleteEmployeeById(Integer id);
    Employee getEmployeeById(Integer id);
    void updateEmployee(Employee emp);
}
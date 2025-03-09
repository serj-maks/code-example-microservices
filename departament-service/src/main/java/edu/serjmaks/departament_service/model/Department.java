package edu.serjmaks.departament_service.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private Long id;
    private String name;
    private List<Employee> empoyees =  new ArrayList<>();

    public Department() {
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmpoyees() {
        return empoyees;
    }

    public void setEmpoyees(List<Employee> empoyees) {
        this.empoyees = empoyees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empoyees=" + empoyees +
                '}';
    }
}

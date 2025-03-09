package edu.serjmaks.departament_service.repository;

import edu.serjmaks.departament_service.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private List<Department> departmens = new ArrayList<>();

    public Department addDepartment(Department department) {
        departmens.add(department);
        return department;
    }

    public List<Department> findAll() {
        return departmens;
    }

    public Department findById(Long id) {
        return departmens.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}

package edu.serjmaks.departament_service.controller;

import edu.serjmaks.departament_service.client.EmployeeClient;
import edu.serjmaks.departament_service.model.Department;
import edu.serjmaks.departament_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department) {
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("find all departments with the employees");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> department.setEmpoyees(
                employeeClient.findByDepartment(department.getId())
        ));
        return departments;
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        LOGGER.info("find department by id: {}", id);
        return departmentRepository.findById(id);
    }
}

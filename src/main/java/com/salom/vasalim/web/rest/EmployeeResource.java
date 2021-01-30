package com.salom.vasalim.web.rest;

import com.salom.vasalim.demain.Employee;
import com.salom.vasalim.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    public final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
     public ResponseEntity save(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

    @PutMapping("/employees")
    public ResponseEntity update(@RequestBody Employee employee){
        Employee employee1 =employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }
    @GetMapping("/employees/all")
    public ResponseEntity findAll() {
        List<Employee> employeeList = employeeService.findAll();
          return ResponseEntity.ok(employeeList);
    }
    @GetMapping("/employees/{name}")
    public ResponseEntity findAll(@PathVariable String name) {
        List<Employee> employeeList = employeeService.findByName(name);
        return ResponseEntity.ok(employeeList);
    }
    @GetMapping("/employees/search")
    public ResponseEntity getAllSearch(@RequestParam String name) {
        List<Employee> employeeList = employeeService.findAllByParam(name);
        return ResponseEntity.ok(employeeList);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("qator o`chirildi");
    }
}

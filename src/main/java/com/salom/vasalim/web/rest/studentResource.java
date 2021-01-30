package com.salom.vasalim.web.rest;

import com.salom.vasalim.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class studentResource {

    @GetMapping("/students/all")
    public ResponseEntity getAll(){
        Student student = new Student(1L,"Ali","Aliev","2-course");
        Student student1 = new Student(2L,"Aziz","Azizov","2-course");
        Student student2 = new Student(3L,"Akbar","Akbarov","2-course");
        Student student3 = new Student(4L,"Amin","Aminov","2-course");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);

        return ResponseEntity.ok(students);
    }

//    @GetMapping("/students/{id}")
//    public ResponseEntity getOne(@PathVariable Long id){
//        Student student = new Student(id,"Aziz","Azizov","2-course");
//        return ResponseEntity.ok(student);
//    }

    @GetMapping("/students")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam String course){
        Student student = new Student(id,name,lastName,course);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Student studentNew){
        Student student = new Student(3L,"Akbar","Akbarov","2-course");
        student.setId(id);
        student.setName(studentNew.getName());
        student.setLastName(studentNew.getLastName());
        return ResponseEntity.ok(student);
    }
}

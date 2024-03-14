package org.example.quiz2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.quiz2.Api.ApiMessage;
import org.example.quiz2.Model.Student;
import org.example.quiz2.Model.Teacher;
import org.example.quiz2.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/studentq")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getstudent(){
        ArrayList<Student> stud=studentService.getStudents();
        return ResponseEntity.status(200).body(stud);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student , Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiMessage("Student added successfully "));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id ,@RequestBody @Valid Student student,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=studentService.updateStudent(id, student);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiMessage("Student updated"));
        }
        return ResponseEntity.status(400).body(new ApiMessage("Not found id "));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        boolean isDeleted =studentService.deleteStudent(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiMessage("Deleted"));
        }
        return ResponseEntity.status(400).body("Not found Id");
    }


    @GetMapping("/search/{name}")
    public ResponseEntity searchStudent(@PathVariable String name){
        Student  student=studentService.searchStudent(name);
        if (student == null) {
            return ResponseEntity.status(400).body("Not found student");

        }
        return ResponseEntity.status(200).body(student);
    }

    @GetMapping("/search/major/{major}")
    public ResponseEntity searchSalary(@PathVariable String major){
        ArrayList<Student> list=studentService.searchMajor(major);
        if (list.isEmpty()){
            return ResponseEntity.status(400).body("Not found match major");
        }
        return ResponseEntity.status(200).body(list);
    }

}

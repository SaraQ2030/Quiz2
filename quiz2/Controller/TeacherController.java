package org.example.quiz2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.quiz2.Api.ApiMessage;
import org.example.quiz2.Model.Student;
import org.example.quiz2.Model.Teacher;
import org.example.quiz2.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/teacherq")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher> teachers=teacherService.getTeacher();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiMessage("Teacher added successfully "));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id ,@RequestBody @Valid Teacher teacher,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdated=teacherService.updateTeacher(id, teacher);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiMessage("Teacher updated"));
        }
        return ResponseEntity.status(400).body(new ApiMessage("Not found id "));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        boolean isDeleted =teacherService.deleteTeacher(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiMessage("Deleted"));
        }
        return ResponseEntity.status(400).body("Not found Id");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchTeacher(@PathVariable int id){
        Teacher teacher=teacherService.searchTeacher(id);
        if (teacher == null) {
            return ResponseEntity.status(400).body("Not found id");

        }
        return ResponseEntity.status(200).body(teacher);
    }

    @GetMapping("/search/salary/{salary}")
    public ResponseEntity searchSalary(@PathVariable int salary){
        ArrayList<Teacher> list=teacherService.searchSalary(salary);
        if (list.isEmpty()){
            return ResponseEntity.status(400).body("Not found");
        }
        return ResponseEntity.status(200).body(list);
    }
}

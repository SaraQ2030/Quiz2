package org.example.quiz2.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {
    @NotNull( message = "the id should not be empty")
    @Positive
    private int id;
    @NotBlank(message = "the name should not be empty")
    private String name;
    @NotNull( message = "the salary should not be empty")
    @Positive
    @Min(value = 3000 ,message ="the salary should not be more 3000" )
    private int salary;

}

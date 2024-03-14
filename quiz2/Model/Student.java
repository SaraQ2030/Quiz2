package org.example.quiz2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
   @NotNull ( message ="the age should not be empty")
   @Positive
//    @Pattern(regexp = "^[0-9]$" ,message = "The id should be numbers")
    private int id;
    @NotBlank(message = "the name should not be empty")
    private String name;
    @NotNull(message ="the age should not be empty")
    @Min(value = 14 ,message = "age should be more than 14")
   // @Max(19)
    private int age ;
    @NotBlank(message = "the major should not be empty")
    private String major;
}

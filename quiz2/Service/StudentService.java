package org.example.quiz2.Service;

import org.example.quiz2.Model.Student;
import org.example.quiz2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students=new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(int id,Student student){
        for (Student s:students){
            if (s.getId()==id){
                students.set(students.indexOf(s),student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id){
        for (Student s:students){
            if (s.getId()==id){
                students.remove(students.indexOf(s));
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(String name){
        for (Student s:students){
            if (s.getName().equalsIgnoreCase(name)){
                return s;
            }
        }
        return null;
    }

    public ArrayList<Student> searchMajor(String major){
        ArrayList<Student> list=new ArrayList<>();
        for (Student s:students){
            if (s.getMajor().equalsIgnoreCase(major)){
                list.add(s);
            }
        }
        return list;
    }
}

package org.example.quiz2.Service;

import org.example.quiz2.Model.Student;
import org.example.quiz2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher> teachers=new ArrayList<>();

    public ArrayList<Teacher> getTeacher(){
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeacher(int id,Teacher teacher){
        for (Teacher t:teachers){
            if (t.getId()==id){
                teachers.set(teachers.indexOf(t),teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id){
        for (Teacher t:teachers){
            if (t.getId()==id){
                teachers.remove(teachers.indexOf(t));
                return true;
            }
        }
        return false;
    }

    public Teacher searchTeacher(int id){
        for (Teacher t:teachers){
            if (t.getId()==id){
                return t;
            }
        }
        return null;
    }


    public ArrayList<Teacher> searchSalary(int salary){
        ArrayList<Teacher> list=new ArrayList<>();
        for (Teacher t:teachers){
            if (t.getSalary()>= salary){
                list.add(t);
            }
        }
       return list;
    }

}

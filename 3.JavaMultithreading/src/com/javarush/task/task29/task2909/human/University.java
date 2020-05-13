package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {

    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for(Student s : students) {
            if (s.getAverageGrade() == averageGrade) {
                return s;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxValue = Double.MIN_VALUE;
        for(Student s : students) {
            if (s.getAverageGrade() > maxValue) {
                maxValue = s.getAverageGrade();
            }
        }
        for(Student s : students) {
            if (s.getAverageGrade() == maxValue) {
                return s;
            }
        }
        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        double minValue = Double.MAX_VALUE;
        for(Student s : students) {
            if (s.getAverageGrade() < minValue) {
                minValue = s.getAverageGrade();
            }
        }
        for(Student s : students) {
            if (s.getAverageGrade() == minValue) {
                return s;
            }
        }
        return null;
    }
    public void expel(Student student){
        students.remove(student);
    }
}
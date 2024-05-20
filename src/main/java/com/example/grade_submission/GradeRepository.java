package com.example.grade_submission;

import com.example.grade_submission.pojo.Grade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class GradeRepository {
    private List<Grade> studentGrades;

    GradeRepository() {
        studentGrades = new ArrayList<>();
    }
    public List<Grade> getStudentGrades() {
        studentGrades.sort(Comparator.comparing(Grade::getName));
        return studentGrades;
    }

    public void setStudentGrades(Grade grade) {
        studentGrades.removeIf(g -> g.getName().equals(grade.getName()));
        this.studentGrades.add(grade);
    }

    public Grade getIndex(String name) {
        for (Grade grade: studentGrades) {
            if (grade.getName().equals(name))
                return grade;
        }
        return new Grade();
    }
}

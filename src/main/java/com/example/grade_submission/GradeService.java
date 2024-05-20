package com.example.grade_submission;

import com.example.grade_submission.pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    public List<Grade> getGrades() {
        return gradeRepository.getStudentGrades();
    }

    public void addGrades(Grade grade) {
        gradeRepository.setStudentGrades(grade);
    }

    public Grade getIndex(String name) {
        return gradeRepository.getIndex(name);
    }
}

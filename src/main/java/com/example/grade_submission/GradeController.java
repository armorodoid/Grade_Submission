package com.example.grade_submission;

import com.example.grade_submission.pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }

    @PostMapping("/handleSubmit")
    public String submitGrade(Grade grade) {
        gradeService.addGrades(grade);
        return "redirect:/grades";
    }

    @GetMapping("/")
    public String addGrades(Model model, @RequestParam(required = false) String name) {
        Grade grade = gradeService.getIndex(name);
        model.addAttribute("grade", grade);
        return "form";
    }
}

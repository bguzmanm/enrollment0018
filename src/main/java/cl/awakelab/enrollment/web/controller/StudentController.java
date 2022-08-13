package cl.awakelab.enrollment.web.controller;

import cl.awakelab.enrollment.model.domain.dto.Student;
import cl.awakelab.enrollment.model.domain.service.StudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/student")
public class StudentController {

    Log logger = LogFactory.getLog(StudentController.class);
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("students",
                service.findAll()
                        .orElse(new ArrayList<Student>()));
        return "studentList";
    }

    @GetMapping("/new")
    public String create(){
        return "studentNew";
    }

    @GetMapping("/edit/{studentId}")
    public String edit(@PathVariable("studentId") int studentId, Model model){
        model.addAttribute("student",
                service.findById(studentId)
                        .orElse(new Student()));

        return "studentEdit";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Student student){
        logger.info(student.toString());
        service.save(student);
        return "redirect:/student/all";
    }
    @GetMapping("/del/{studentId}")
    public String delete(@PathVariable("studentId") int studentId){
        service.delete(studentId);
        return "redirect:/student/all";
    }

}

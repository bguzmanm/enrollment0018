package cl.awakelab.enrollment.web.controller;

import cl.awakelab.enrollment.domain.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String findAll(Model model){

        model.addAttribute("teachers",
                service.findAll()
                        .orElse(new ArrayList<>()));

        return "teacherList";
    }

}

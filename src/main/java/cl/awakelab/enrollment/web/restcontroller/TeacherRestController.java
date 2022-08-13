package cl.awakelab.enrollment.web.restcontroller;

import cl.awakelab.enrollment.domain.dto.Teacher;
import cl.awakelab.enrollment.domain.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherRestController {

    private final TeacherService service;

    public TeacherRestController(TeacherService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> findAll(){
        return service.findAll()
                .map(teachers -> new ResponseEntity<>(teachers, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> findById(@PathVariable("teacherId") int teacherId){
        return service.findById(teacherId)
                .map(teacher -> new ResponseEntity<>(teacher, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

package cl.awakelab.enrollment.domain.service;

import cl.awakelab.enrollment.domain.dto.Enrollment;
import cl.awakelab.enrollment.domain.dto.Grade;
import cl.awakelab.enrollment.domain.dto.Student;
import cl.awakelab.enrollment.domain.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    private final EnrollmentRepository repository;
    private final StudentService studentService;
    private final GradeService gradeService;

    public EnrollmentService(EnrollmentRepository repository, StudentService studentService, GradeService gradeService) {
        this.repository = repository;
        this.studentService = studentService;
        this.gradeService = gradeService;
    }
    public Optional<List<Enrollment>> findAll(){
        return repository.findAll();
    }

    public Optional<Enrollment> findById(int studentId, int gradeId){
        return repository.findById(studentId, gradeId);
    }
    public Enrollment save(Enrollment enrollment){
        if (enrollment.getGrade() == null){
            enrollment.setGrade(
                    gradeService
                            .findById(enrollment.getGradeId())
                            .orElse(new Grade()));
        }

        if (enrollment.getStudent() == null){
            enrollment.setStudent(
                    studentService.findById(enrollment.getStudentId())
                            .orElse(new Student()));
        }

        return repository.save(enrollment);
    }

    public boolean delete(int studentId, int gradeId){
        return findById(studentId, gradeId)
                .map(register -> {
                    repository.delete(studentId, gradeId);
                    return true;
                })
                .orElse(false);
    }
}

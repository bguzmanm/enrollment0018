package cl.awakelab.enrollment.domain.service;

import cl.awakelab.enrollment.domain.dto.Teacher;
import cl.awakelab.enrollment.domain.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public Optional<List<Teacher>> findAll(){
        return repository.findAll();
    }
    public Optional<Teacher> findById(int teacherId){
        return repository.findById(teacherId);
    }
    public Teacher save(Teacher teacher){
        return repository.save(teacher);
    }
    public boolean delete(int teacherId){
        return findById(teacherId)
                .map(teacher -> {
                    repository.delete(teacherId);
                    return true;})
                .orElse(false);
    }

}

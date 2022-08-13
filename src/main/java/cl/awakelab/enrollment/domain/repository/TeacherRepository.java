package cl.awakelab.enrollment.domain.repository;

import cl.awakelab.enrollment.domain.dto.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository {

    Optional<List<Teacher>> findAll();
    Optional<Teacher> findById(int teacherId);
    Teacher save(Teacher teacher);
    void delete(int teacherId);

}

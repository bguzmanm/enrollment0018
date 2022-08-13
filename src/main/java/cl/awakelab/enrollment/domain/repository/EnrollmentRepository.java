package cl.awakelab.enrollment.domain.repository;


import cl.awakelab.enrollment.domain.dto.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {
    Optional<List<Enrollment>> findAll();
    Optional<Enrollment> findById(int studentId, int gradeId);
    Enrollment save(Enrollment enrollment);
    void delete(int studentId, int gradeId);

    boolean existsById(int studentId, int gradeId);
}

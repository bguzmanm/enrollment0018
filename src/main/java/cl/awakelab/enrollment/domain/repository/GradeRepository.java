package cl.awakelab.enrollment.domain.repository;

import cl.awakelab.enrollment.domain.dto.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeRepository {
    Optional<List<Grade>> findAll();
    Optional<Grade> findById(int gradeId);
    Grade save(Grade grade);
    void delete(int gradeId);
}

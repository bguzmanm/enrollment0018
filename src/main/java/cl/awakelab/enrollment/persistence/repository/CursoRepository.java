package cl.awakelab.enrollment.persistence.repository;
import cl.awakelab.enrollment.domain.dto.Grade;
import cl.awakelab.enrollment.domain.repository.GradeRepository;
import cl.awakelab.enrollment.persistence.crud.CursoCrud;
import cl.awakelab.enrollment.persistence.entity.Curso;
import cl.awakelab.enrollment.persistence.mapper.GradeMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CursoRepository implements GradeRepository {

    private final CursoCrud crud;
    private final GradeMapper mapper;

    public CursoRepository(CursoCrud crud, GradeMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Grade>> findAll() {
        return Optional.of(mapper.toGrades((List<Curso>) crud.findAll()));
    }

    @Override
    public Optional<Grade> findById(int gradeId) {
        return crud.findById(gradeId)
                .map(mapper::toGrade);
    }

    @Override
    public Grade save(Grade grade) {
        return mapper.toGrade(crud.save(mapper.toCurso(grade)));
    }

    @Override
    public void delete(int gradeId) {
        crud.deleteById(gradeId);
    }
}

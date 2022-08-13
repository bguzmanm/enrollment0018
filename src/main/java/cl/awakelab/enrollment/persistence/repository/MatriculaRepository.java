package cl.awakelab.enrollment.persistence.repository;

import cl.awakelab.enrollment.domain.dto.Enrollment;
import cl.awakelab.enrollment.domain.repository.EnrollmentRepository;
import cl.awakelab.enrollment.persistence.crud.MatriculaCrud;
import cl.awakelab.enrollment.persistence.entity.Matricula;
import cl.awakelab.enrollment.persistence.entity.MatriculaPK;
import cl.awakelab.enrollment.persistence.mapper.RegisterMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MatriculaRepository implements EnrollmentRepository {

    private final MatriculaCrud crud;
    private final RegisterMapper mapper;

    public MatriculaRepository(MatriculaCrud crud, RegisterMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Enrollment>> findAll() {
        return Optional.of(mapper.toRegisters((List<Matricula>) crud.findAll()));
    }

    @Override
    public Optional<Enrollment> findById(int studentId, int gradeId) {
        return crud.findById(new MatriculaPK(studentId, gradeId))
                .map(mapper::toRegister);
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return mapper.toRegister(crud.save(mapper.toMatricula(enrollment)));
    }

    @Override
    public void delete(int studentId, int gradeId) {
        crud.deleteById(new MatriculaPK(studentId, gradeId));
    }

    @Override
    public boolean existsById(int studentId, int gradeId) {
        return crud.existsById(new MatriculaPK(studentId, gradeId));
    }

}

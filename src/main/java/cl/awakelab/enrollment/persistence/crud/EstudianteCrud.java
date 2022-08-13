package cl.awakelab.enrollment.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import cl.awakelab.enrollment.persistence.entity.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteCrud extends CrudRepository<Estudiante, Integer> {
    Optional<List<Estudiante>> findByNombre(String nombre);

}

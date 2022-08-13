package cl.awakelab.enrollment.persistence.crud;


import cl.awakelab.enrollment.persistence.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoCrud extends CrudRepository<Curso, Integer> {
}

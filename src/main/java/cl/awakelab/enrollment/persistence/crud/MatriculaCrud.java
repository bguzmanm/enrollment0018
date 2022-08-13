package cl.awakelab.enrollment.persistence.crud;


import cl.awakelab.enrollment.persistence.entity.Matricula;
import cl.awakelab.enrollment.persistence.entity.MatriculaPK;
import org.springframework.data.repository.CrudRepository;

public interface MatriculaCrud extends CrudRepository<Matricula, MatriculaPK> {
}

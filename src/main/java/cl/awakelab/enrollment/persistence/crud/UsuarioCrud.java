package cl.awakelab.enrollment.persistence.crud;

import cl.awakelab.enrollment.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrud extends CrudRepository<UserEntity, String> {
    boolean existsByUsername(String username);
}

package cl.awakelab.enrollment.domain.repository;

import cl.awakelab.enrollment.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<List<User>> findAll();
    Optional<User> findByUsername(String username);
    User save(User user);
    void delete(String username);
    boolean existsByUsername(String username);
}

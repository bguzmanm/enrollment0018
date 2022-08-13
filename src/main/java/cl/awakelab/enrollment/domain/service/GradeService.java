package cl.awakelab.enrollment.domain.service;

import cl.awakelab.enrollment.domain.dto.Grade;
import cl.awakelab.enrollment.domain.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    private final GradeRepository repo;

    public GradeService(GradeRepository repo) {
        this.repo = repo;
    }

    public Optional<List<Grade>> findAll(){
        return repo.findAll();
    }

    public Optional<Grade> findById(Integer gradeId) {
        return repo.findById(gradeId);
    }
}

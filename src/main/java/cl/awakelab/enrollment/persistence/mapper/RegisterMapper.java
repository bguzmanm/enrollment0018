package cl.awakelab.enrollment.persistence.mapper;

import cl.awakelab.enrollment.domain.dto.Enrollment;
import cl.awakelab.enrollment.persistence.entity.Matricula;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, GradeMapper.class})
public interface RegisterMapper {
    
    @Mappings({
            @Mapping(source = "id.cursoId", target = "gradeId"),
            @Mapping(source = "id.estudianteId", target = "studentId"),
            @Mapping(source = "curso", target = "grade"),
            @Mapping(source = "estudiante", target = "student"),
            @Mapping(source = "fecha", target = "date"),
    })
    Enrollment toRegister(Matricula matricula);
    List<Enrollment> toRegisters(List<Matricula> matricula);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "gradeId", target = "id.cursoId"),
            @Mapping(source = "studentId", target = "id.estudianteId")
    })
    Matricula toMatricula(Enrollment enrollment);

}

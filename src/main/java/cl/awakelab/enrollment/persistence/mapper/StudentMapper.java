package cl.awakelab.enrollment.persistence.mapper;

import cl.awakelab.enrollment.domain.dto.Student;
import cl.awakelab.enrollment.persistence.entity.Estudiante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mappings({
            @Mapping(source = "id", target = "studentId"),
            @Mapping(source = "rut", target = "dni"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "telefono", target = "phone")
    })
    Student toStudent(Estudiante estudiante);
    List<Student> toStudents(List<Estudiante> estudiantes);

    @InheritInverseConfiguration
    Estudiante toEstudiante(Student student);

}

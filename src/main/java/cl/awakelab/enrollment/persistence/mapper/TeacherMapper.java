package cl.awakelab.enrollment.persistence.mapper;

import cl.awakelab.enrollment.domain.dto.Teacher;
import cl.awakelab.enrollment.persistence.entity.Facilitador;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mappings({
            @Mapping(source = "id", target = "teacherId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "banco", target = "bank"),
            @Mapping(source = "rut", target = "dni"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "ctaBancaria", target = "account"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "valorHora", target = "cost"),
    })
    Teacher toTeacher(Facilitador facilitador);
    List<Teacher> toTeachers(List<Facilitador> facilitadores);

    @InheritInverseConfiguration
    Facilitador toFacilitador(Teacher teacher);
}

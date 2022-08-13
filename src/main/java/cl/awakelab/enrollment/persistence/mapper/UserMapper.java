package cl.awakelab.enrollment.persistence.mapper;

import cl.awakelab.enrollment.domain.dto.User;
import cl.awakelab.enrollment.persistence.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "enabled", target = "enabled"),
            @Mapping(source = "roles", target = "roles"),
    })
    User toUser(UserEntity user);
    List<User> toUsers(List<UserEntity> users);
    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);

}

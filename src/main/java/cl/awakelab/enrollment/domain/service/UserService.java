package cl.awakelab.enrollment.domain.service;

import cl.awakelab.enrollment.domain.dto.Role;
import cl.awakelab.enrollment.domain.dto.User;
import cl.awakelab.enrollment.domain.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService { //} implements UserDetailsService {
//
//    private final UserRepository repo;
//
//    public UserService(UserRepository repo) {
//        this.repo = repo;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //return new User("brian", "{noop}kupita", new ArrayList<>());
//        User user = repo.findByUsername(username)
//                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),
//                user.getPassword(),
//                mapperRols(user.getRoles()));
//    }
//
//    private Collection<? extends GrantedAuthority> mapperRols(List<Role> roles){
//        return roles.stream()
//                .map(rol -> new SimpleGrantedAuthority(rol.getRoleName()))
//                .collect(Collectors.toList());
//    }
}

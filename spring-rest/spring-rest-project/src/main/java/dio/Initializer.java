package dio;

import java.util.Arrays;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dio.auth.entity.Role;
import dio.auth.entity.User;
import dio.auth.service.RoleService;
import dio.auth.service.UserService;

@Service
public class Initializer {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void criaUsuariosEPermissoes() {
        Role roleAdmin = new Role();

        roleAdmin.setName("USER");

        roleService.save(roleAdmin);

        User user = new User();
        user.setAtivo(true);
        user.setEmail("teste@teste.com");
        user.setNome("Joao Otavio");
        user.setSenha(new BCryptPasswordEncoder().encode("123456"));
        user.setUsername("joao");
        user.setRoles(Arrays.asList(roleAdmin));

        userService.save(user);

    }
}
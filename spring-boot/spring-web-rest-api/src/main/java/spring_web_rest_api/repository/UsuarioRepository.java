package spring_web_rest_api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import spring_web_rest_api.handler.CampoObrigatorioException;
import spring_web_rest_api.model.Usuario;

@RestController
public class UsuarioRepository {
    public void save(Usuario usuario){
        if(usuario.getLogin()==null)
            throw new CampoObrigatorioException("login");
        if(usuario.getPassword()==null)
            throw new CampoObrigatorioException("password");
        if(usuario.getId()==null)
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        else
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        
        System.out.println(usuario);
    }
    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
    }
    public List<Usuario> findAll(){
        System.out.println("LIST - Listando os usários do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("joschonarth","password"));
        usuarios.add(new Usuario("adm","masterpass"));
        return usuarios;
    }
    public Usuario findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
        return new Usuario("joschonarth","password");
    }
     public Usuario findByUsername(String username){
        System.out.println(String.format("FIND/username - Recebendo o usernamae: %s para localizar um usuário", username));
        return new Usuario("joschonarth","password");
    }
}

package sptech.school.login01221141matheus;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    List<Usuario> usuarios = new ArrayList<>();
    @PostMapping("/autenticacao/{usuario}/{senha}")
    public String autenticar(@PathVariable String usuario, @PathVariable String senha) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equalsIgnoreCase(usuario) && u.getSenha().equalsIgnoreCase(senha)) {
                u.setAutenticado(true);
                return String.format("%s | %s\n%s | %s", u.getUsuario(), usuario, u.getSenha(), senha);
            }
        }
        return null;
    }
}

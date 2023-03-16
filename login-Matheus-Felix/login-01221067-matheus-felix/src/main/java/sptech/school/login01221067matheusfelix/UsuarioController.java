package sptech.school.login01221067matheusfelix;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<Usuario> listaUsuarios;

    public UsuarioController() {
        listaUsuarios = new ArrayList<>();
    }

    @GetMapping
    public List<Usuario> mostrar() {
        return listaUsuarios;
    }

    @PostMapping()
    public Usuario criarUsuario(@RequestBody Usuario bodyUser) {
        listaUsuarios.add(bodyUser);
        return bodyUser;
    }

    @PostMapping("/autenticacao/{usuario}/{senha}")
    public Usuario criarUsuario(@PathVariable String usuario, @PathVariable String senha) {
        for (var user: listaUsuarios) {
            if (user.getUsuario().equals(usuario) && user.verificacaoSenha(senha)) {
                user.setAutenticacao(true);
            }
            return user;
        }
        return null;
    }

    @DeleteMapping("/autenticacao/{usuario}")
    public String deletarUsuario(@PathVariable String usuario) {
        for (var user: listaUsuarios) {
            if (user.getUsuario().equals(usuario) && user.isAutenticacao()) {
                user.setAutenticacao(false);
                return "Logoff do usuário " + user.getNome() + " concluído";
            } else if(user.getUsuario().equals(usuario)) {
                return "Usuário " + user.getNome() + " NÃO está autenticado";

            }
        }
        return "Usuário " + usuario + " não encontrado";
    }

    // Atualiza os campos do usuário e verifica se ele está autenticado
    // antes de executar as mudanças
    @PatchMapping("/{indice}")
    public Usuario atualizarUsuario(@PathVariable int indice, @RequestBody Usuario body) {
        var user = listaUsuarios.get(indice);

        if (user.isAutenticacao()) {
            user.setUsuario(body.getUsuario() != null ? body.getUsuario() : user.getUsuario());
            user.setNome(body.getNome() != null ? body.getNome() : user.getNome());

            return user;
        }

        return null;
    }
}

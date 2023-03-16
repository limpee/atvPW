package school.sptech.login01221167david;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")

public class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
        usuarios.add(new Usuario ("Rafael", "rafa@email.com", "12345"));
    }

    @GetMapping
    public List<Usuario> teste(){
        return usuarios;
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuarioNovo){
        usuarios.add(usuarioNovo);
        return usuarioNovo;
    }

    @DeleteMapping("{nome}")
    public String logoffUsuario(@PathVariable String nome){
        for(Usuario u : usuarios){
            if(u.getNome().equals(usuarios)){
                if(u.isAutenticado()) {
                    u.setAutenticado(false);
                    return "Logoff do usuário " + u.getNome() + " feito com sucesso!";
                }else{
                    return "Usuario " + u.getNome() + " não foi autenticado";
                }
            }
        }
        return "Usuário não encontrado";
    }

    @PostMapping("autenticar/{nome}/{senha}")
    public String autenticarUsuario(@PathVariable String nome, @PathVariable String senha){
        for (Usuario u: usuarios) {
            if(u.getNome().equals(usuarios) && u.verificaSenha(senha)){
                u.setAutenticado(true);
                return  "Usuário autenticado com sucesso!";
            }
        }
        return "Usuário não autenticado";
    }

    @PatchMapping("{indice}")
    public Usuario alterarUsuario(@PathVariable int indice, @RequestBody Usuario usuarioNovo){
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.set(indice, usuarioNovo);
            return usuarioNovo;
        }
        return null;
    }

    // VERIFICA SE O USUÁRIO ESTÁ NA LISTA
    @GetMapping("{nome}")
    public String usuarioExiste(@PathVariable String nome){
        for(Usuario u: usuarios){
            if(u.getNome().equals(nome)){
                return "Usuário " + u.getNome() + " está na lista";
            }
        }
        return "Usuario não encontrado";
    }
}
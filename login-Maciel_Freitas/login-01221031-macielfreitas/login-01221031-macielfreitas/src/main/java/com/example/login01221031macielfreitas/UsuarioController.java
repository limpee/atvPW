package com.example.login01221031macielfreitas;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    private static List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/usuarios")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }


    @PostMapping("/usuarios/autenticacao/{usuario}/{senha}")
    public Usuario autenticarUsuario(@RequestBody Usuario usuarioAutenticar) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equalsIgnoreCase(usuarioAutenticar.getUsuario()) && u.getSenha().equalsIgnoreCase(usuarioAutenticar.getSenha())) {
                u.setAutenticado(true);
                u.setSenha(null);

                return u;
            }
        }

        return null;
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuariosSemSenha = new ArrayList<>();
        for (Usuario u : usuarios) {
            Usuario usuarioSemSenha = new Usuario();
            usuarioSemSenha.setUsuario(u.getUsuario());
            usuarioSemSenha.setNome(u.getNome());
            usuarioSemSenha.setAutenticado(u.isAutenticado());
            usuariosSemSenha.add(usuarioSemSenha);
        }
        return usuariosSemSenha;
    }

    @DeleteMapping("/usuarios/autenticacao/{usuario}")
    public String logoffUsuario(@RequestBody Usuario usuarioAutenticado) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuarioAutenticado.getUsuario())) {
                if (u.isAutenticado()) {
                    u.setAutenticado(false);
                    return "Logoff do usuário " + u.getNome() + " concluído";
                } else {
                    return "Usuário " + u.getNome() + " NÃO está autenticado";
                }
            }
        }
        return "Usuário " + usuarioAutenticado.getUsuario() + " não encontrado";
    }

    @PutMapping("/usuarios/{usuario}")
    public Usuario atualizarUsuario(@PathVariable String usuario, @RequestBody Usuario usuarioAtualizado) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                u.setNome(usuarioAtualizado.getNome());
                return u;
            }
        }
        return null;
    }
}

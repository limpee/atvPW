package com.example.login01221106GustavoH;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
private List<Usuario> user;

    public UsuarioController() {
        this.user = new ArrayList<>();
    }

    @PostMapping()
public Usuario adcionarUser(@RequestBody Usuario usuario){
    user.add(usuario);
    return usuario;
    }
    @PostMapping("/autenticado/{nome}/{senha}")
    public Usuario autenticar(@PathVariable String nome, @PathVariable String senha){
        for (int i = 0; i < user.size() ; i++) {
                if(nome.equals(user.get(i).getNome()) && senha.equals(user.get(i).getSenha())) {
                    user.get(i).setAutenticado(true);

                    return user.get(i);
                }
        }
        return null;
    }
    @GetMapping()
    public Usuario retornaUser(){
        for (int i = 0; i < user.size() ; i++) {
           return user.get(i);
        }
     return null;
    }
    @DeleteMapping("/autenticacao/{usuario}")
    public String logOff(@PathVariable String usuario){
        for (int i = 0; i < user.size() ; i++) {
            if (usuario.equals(user.get(i).getUsuarioEmail())){

                if (user.get(i).isAutenticado() == true){
                    return String.format("LogOff do usuario %s concluido ", user.get(i).getNome());
                } else if (user.get(i).isAutenticado() == false) {
                    return String.format("usuario %s não está autenticado ", user.get(i).getNome());
                }


            }else{
                return String.format("usuario %s não encontrado ", usuario);
            }
        }
        return null;
    }
    @DeleteMapping("/deletar")
    public String deletarTodos(){
        for (int i = 0; i < user.size() ; i++) {
            user.remove(i);
            return "Todos usuarios apagados";
        }
        return null;
    }

}

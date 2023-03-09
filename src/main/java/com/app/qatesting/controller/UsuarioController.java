package com.app.qatesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.qatesting.entity.Usuario;
import com.app.qatesting.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService uService;

    @GetMapping
    public List<Usuario> todosUsuario(){
        return uService.todosUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario findUsuario(@PathVariable("id") Long id){
        return uService.buscarPorId(id);
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario){
        return uService.novoUsuario(usuario);
    }

}

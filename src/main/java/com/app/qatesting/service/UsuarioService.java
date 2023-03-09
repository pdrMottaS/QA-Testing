package com.app.qatesting.service;

import java.util.List;

import com.app.qatesting.entity.Usuario;

public interface UsuarioService {
    
    public Usuario novoUsuario(Usuario usuario);
    public List<Usuario> todosUsuarios();
    public Usuario buscarPorId(Long id);

}

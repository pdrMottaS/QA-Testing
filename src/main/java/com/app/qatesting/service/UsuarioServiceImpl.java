package com.app.qatesting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.qatesting.entity.Usuario;
import com.app.qatesting.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository uRepository;

    public UsuarioServiceImpl(UsuarioRepository uRepository){
        this.uRepository = uRepository;
    }

    @Override
    public Usuario novoUsuario(Usuario usuario) {
        if(usuario.getName()==null||usuario.getName().isEmpty()||usuario.getPassword()==null||usuario.getPassword().isEmpty()){
            throw new IllegalArgumentException("Parâmetros inválidos");
        }
        return uRepository.save(usuario);
    }

    @Override
    public List<Usuario> todosUsuarios() {
        return uRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = uRepository.findById(id);
        if(usuario.isEmpty()){
            throw new IllegalArgumentException("ID não existente");
        }
        return usuario.get();
    }
    
}

package com.app.qatesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.qatesting.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
}

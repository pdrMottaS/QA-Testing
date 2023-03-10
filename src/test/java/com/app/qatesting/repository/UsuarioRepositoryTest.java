package com.app.qatesting.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.app.qatesting.entity.Usuario;

@SpringBootTest
@Transactional
@Rollback
public class UsuarioRepositoryTest {
    
    @Autowired
    private UsuarioRepository uRepository;

    @Test
    public void novoUsuario(){
        Usuario usuario = new Usuario();
        usuario.setName("userTest");
        usuario.setPassword("123");
        usuario = uRepository.save(usuario);
        assertNotNull(usuario.getId());
    }

}

package com.app.qatesting.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;

import com.app.qatesting.entity.Usuario;

@SpringBootTest
@Transactional
@Rollback
public class UsuarioRepositoryTest {
    
    @Autowired
    private UsuarioRepository uRepository;

    @Test
    public void novoUsuarioOK(){
        Usuario usuario = new Usuario();
        usuario.setName("userTest");
        usuario.setPassword("123");
        usuario = uRepository.save(usuario);
        assertNotNull(usuario.getId());
    }

    @Test
    public void novoUsuarioNotOK(){
        Usuario usuario = new Usuario();
        usuario.setName("user");
        usuario.setPassword("123");
        assertThrows(DataIntegrityViolationException.class, ()->{
            uRepository.save(usuario);
        });
    }

    @Test
    public void novoUsuarioBlank(){
        Usuario usuario = new Usuario();
        usuario.setName(null);
        usuario.setPassword("123");
        assertThrows(DataIntegrityViolationException.class, ()->{
            uRepository.save(usuario);
        });
    }

    @Test
    public void findUsuarioOK(){
        Usuario usuario = uRepository.findById(1L).get();
        assertEquals("user", usuario.getName());
    }

}

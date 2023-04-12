package com.app.qatesting.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.qatesting.entity.Usuario;
import com.app.qatesting.repository.UsuarioRepository;

@SpringBootTest
public class UsuarioServiceTest {
    
    @Autowired
    private UsuarioService uService;

    @MockBean
    private UsuarioRepository uRepository;

    private List<Usuario> usuarios = new ArrayList<>();

    @BeforeEach
    public void setup(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setName("Teste");
        usuario.setPassword("123");
        Optional<Usuario> userOp = Optional.of(usuario);
        this.usuarios.add(usuario);
        Mockito.when(uRepository.findAll()).thenReturn(usuarios);
        Mockito.when(uRepository.findById(1L)).thenReturn(userOp);
        Mockito.when(uRepository.save(any())).thenReturn(usuario);
    }

    @Test
    public void listarUsuarios(){
        assertEquals(this.usuarios, uService.todosUsuarios());
    }

    @Test
    public void buscarUsuarioPorIDOK(){
        assertEquals("Teste", uService.buscarPorId(1L).getName());
    }

    @Test
    public void buscarUsuarioPorIDNotOK(){
        assertThrows(IllegalArgumentException.class, ()->{
            uService.buscarPorId(2L);
        });
    }

}

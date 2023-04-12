package com.app.qatesting.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.app.qatesting.entity.Usuario;
import com.app.qatesting.service.UsuarioService;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UsuarioService sevice;

    @Test
    public void novoUsuarioTesteOK() throws Exception{
        Usuario usuario = new Usuario("user", "123");
        usuario.setId(1L);
        Mockito.when(sevice.novoUsuario(any())).thenReturn(usuario);

        mvc.perform(post("/usuario")
            .content("{\"name\":\"teste\",\"password\":\"senha\"}")
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L)
        );
    }

    @Test
    public void listarUsuariosOK() throws Exception{
        Usuario usuario = new Usuario("user","123");
        usuario.setId(1L);
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario);
        Mockito.when(sevice.todosUsuarios()).thenReturn(usuarios);
    
        mvc.perform(get("/usuario"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].id").value(1L));
    }

    @Test
    public void findUsuarioByIdOK() throws Exception{
        Usuario usuario = new Usuario("user","123");
        usuario.setId(1L);
        Mockito.when(sevice.buscarPorId(1L)).thenReturn(usuario);

        mvc.perform(get("/usuario/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L)
        );
    }

    @Test
    public void findUsuarioByIdNotOK() throws Exception{
        Usuario usuario = new Usuario("user","123");
        usuario.setId(1L);
        Mockito.when(sevice.buscarPorId(1L)).thenReturn(usuario);

        mvc.perform(get("/usuario/2"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").doesNotExist());
    }

}

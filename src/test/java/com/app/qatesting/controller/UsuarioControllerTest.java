package com.app.qatesting.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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

}

package com.app.qatesting.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.app.qatesting.entity.Anotacao;
import com.app.qatesting.entity.Usuario;
import com.app.qatesting.service.AnotacaoService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(AnotacaoController.class)
public class AnotacaoControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AnotacaoService aService;

    @Test
    public void listarAnotacaoporUsuarioOK() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setName("teste");
        usuario.setPassword("teste");
        Anotacao anotacao = new Anotacao();
        anotacao.setText("anotacao teste");
        anotacao.setUsuario(usuario);
        List<Anotacao> anotacoes = new ArrayList<>();
        anotacoes.add(anotacao);
        Mockito.when(aService.listarAnotacao(1L)).thenReturn(anotacoes);
        
        mvc.perform(get("/anotacao?id=1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(1));
    }

}

package com.app.qatesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.qatesting.entity.Anotacao;
import com.app.qatesting.entity.Usuario;
import com.app.qatesting.repository.AnotacaoRepository;

@SpringBootTest
public class AnotacaoServiceTest {
    
    @Autowired
    AnotacaoService aService;

    @MockBean
    private AnotacaoRepository aRepository;

    @BeforeEach
    public void setup(){
        Usuario usuario = new Usuario("usr1","123");
        usuario.setId(1L);
        Anotacao anotacao = new Anotacao("anotacao1",usuario);
        anotacao.setId(1L);
        List<Anotacao> anotacoes = new ArrayList<Anotacao>();
        anotacoes.add(anotacao);
        Mockito.when(aRepository.save(any())).thenReturn(anotacao);
        Mockito.when(aRepository.findbyUsuarioID(1L)).thenReturn(anotacoes);
    }

    @Test
    public void listarAnotacaoByUsrIDOK(){
        assertEquals(1L, aService.listarAnotacao(1L).get(0).getId());
    }

    @Test
    public void novaAnotacaoNotOK(){
        assertThrows(IllegalArgumentException.class,()->{
            aService.novaAnotacao(new Anotacao());
        });
    }

}

package com.app.qatesting.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;

import com.app.qatesting.entity.Anotacao;
import com.app.qatesting.entity.Usuario;

@SpringBootTest
@Transactional
@Rollback
public class AnotacaoRepositoryTest {

    @Autowired
    AnotacaoRepository aRepository;

    @Autowired
    UsuarioRepository uRepository;
    
    @Test
    public void newAnotacaoOK(){
        Usuario usuario = uRepository.findById(1L).get();
        Anotacao anotacao = new Anotacao();
        anotacao.setText("teste");
        anotacao.setUsuario(usuario);
        anotacao = aRepository.save(anotacao);
        assertNotNull(anotacao.getId());
    }

    @Test
    public void newAnotacaoNotOK(){
        Anotacao anotacao = new Anotacao();
        anotacao.setText("teste");
        assertThrows(DataIntegrityViolationException.class, ()->{
            aRepository.save(anotacao);
        });
    }

}

package com.app.qatesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.qatesting.entity.Anotacao;
import com.app.qatesting.repository.AnotacaoRepository;

@Service
public class AnotacaoServiceImpl implements AnotacaoService{

    @Autowired
    AnotacaoRepository aRepository;

    public AnotacaoServiceImpl(AnotacaoRepository aRepository){
        this.aRepository = aRepository;
    }

    @Override
    public Anotacao novaAnotacao(Anotacao anotacao) {
        if(anotacao.getText() == null || anotacao.getText().isBlank()){
            throw new IllegalArgumentException("A anotação deve ter algum texto");
        }
        return aRepository.save(anotacao);
    }

    @Override
    public List<Anotacao> listarAnotacao(Long usuarioID) {
        if(usuarioID == null){
            return aRepository.findAll();
        }else{
            return aRepository.findbyUsuarioID(usuarioID);
        }
    }

    
}

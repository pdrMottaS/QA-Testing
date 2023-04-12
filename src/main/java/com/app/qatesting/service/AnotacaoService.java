package com.app.qatesting.service;

import java.util.List;

import com.app.qatesting.entity.Anotacao;

public interface AnotacaoService {

    public Anotacao novaAnotacao(Anotacao anotacao);
    public List<Anotacao> listarAnotacao(Long usuarioID);
    
}

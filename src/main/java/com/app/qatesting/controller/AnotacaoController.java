package com.app.qatesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.qatesting.entity.Anotacao;
import com.app.qatesting.service.AnotacaoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/anotacao")
public class AnotacaoController {

    @Autowired
    private AnotacaoService aService;

    @PostMapping()
    public Anotacao novaAnotacao(@RequestBody Anotacao anotacao){
        return aService.novaAnotacao(anotacao);
    }

    @GetMapping()
    public List<Anotacao> listarAnotacao(@RequestParam(required = false) Long id){
        return aService.listarAnotacao(id);
    }

}

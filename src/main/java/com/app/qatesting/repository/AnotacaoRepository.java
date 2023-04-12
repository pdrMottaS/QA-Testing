package com.app.qatesting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.qatesting.entity.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao,Long>{

    @Query( "SELECT a FROM Anotacao a WHERE a.usuario.id = :usrID")
    List<Anotacao> findbyUsuarioID(@Param("usrID") Long usrID);

}

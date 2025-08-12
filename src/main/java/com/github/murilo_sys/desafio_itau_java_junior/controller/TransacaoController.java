package com.github.murilo_sys.desafio_itau_java_junior.controller;


import com.github.murilo_sys.desafio_itau_java_junior.model.Transacao;
import com.github.murilo_sys.desafio_itau_java_junior.service.TransacaoServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transacao")
public class TransacaoController {

    //Injetando TransacaoServices
    private final TransacaoServices services;
    public TransacaoController(TransacaoServices transacaoServices) {
        this.services = transacaoServices;
    }


    //Criar Transacao
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> criarTransacao (@Valid @RequestBody Transacao transacao) {
        services.criarTransacao(transacao);
      return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

package com.github.murilo_sys.desafio_itau_java_junior.controller;


import com.github.murilo_sys.desafio_itau_java_junior.model.Transacao;
import com.github.murilo_sys.desafio_itau_java_junior.service.TransacaoServices;
import com.github.murilo_sys.desafio_itau_java_junior.util.NumberVerify;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transacao")
public class TransacaoController {

    //Injetando TransacaoServices
    private final TransacaoServices services;

    public TransacaoController(TransacaoServices transacaoServices) {
        this.services = transacaoServices;
    }





    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Transacao criarTransacao (@RequestBody Transacao transacao) {
        return services.criarTransacao(transacao);
    }

}

package com.github.murilo_sys.desafio_itau_java_junior.service;

import com.github.murilo_sys.desafio_itau_java_junior.model.Transacao;
import com.github.murilo_sys.desafio_itau_java_junior.util.Verifications;
import org.springframework.stereotype.Service;

@Service
public class TransacaoServices {


    public Transacao criarTransacao(Transacao transacao){

        Verifications.isValid(transacao.valor());

        return transacao;
    }

}

package com.projeto.VHL.teste.service;

import com.projeto.VHL.teste.Service.SeloDigitalService;
import com.projeto.VHL.teste.model.EntesDeclaradosDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SeloDigitalServiceTeste {

    @Autowired
    private SeloDigitalService seloDigitalService;

    @Test
    public void deveRetornarListaDeEntesNaoVazia() throws Exception {
        List<EntesDeclaradosDTO> lista = seloDigitalService.listarEntesDeclarados();
        assertNotNull(lista, "A lista retornada não deve ser nula");
        assertFalse(lista.isEmpty(), "A lista retornada não deve estar vazia");
    }
}

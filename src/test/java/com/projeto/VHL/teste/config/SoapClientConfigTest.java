package com.projeto.VHL.teste.config;

import br.jus.tjsc.selo.SeloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SoapClientConfigTest {

    @Autowired
    private SeloService seloService;

    @Test
    public void testeSeloServiceBeanExiste() {
        assertNotNull(seloService, "O bean SeloService deve ser criado e injetado pelo Spring");
    }
}

package com.projeto.VHL.teste.controller;

import com.projeto.VHL.teste.Service.SeloDigitalService;
import com.projeto.VHL.teste.model.EntesDeclaradosDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SeloDigitalController.class)
public class SeloDigitalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SeloDigitalService seloDigitalService;

    @Test
    public void testGetEntes() throws Exception {
        var entes = List.of(
                new EntesDeclaradosDTO(1L, "Lei 123", "Entidade A")
        );

        when(seloDigitalService.listarEntesDeclarados()).thenReturn(entes);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/selo-digital/entes")
                        .param("page", "0")
                        .param("size", "10"))
                .andDo(org.springframework.test.web.servlet.result.MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].codigo").value(1))
                .andExpect(jsonPath("$.content[0].lei").value("Lei 123"))
                .andExpect(jsonPath("$.content[0].nomeEntidade").value("Entidade A"));
    }
}

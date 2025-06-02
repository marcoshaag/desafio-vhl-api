package com.projeto.VHL.teste.controller;

import br.jus.tjsc.selo.Exception_Exception;
import com.projeto.VHL.teste.Service.SeloDigitalService;
import com.projeto.VHL.teste.model.EntesDeclaradosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/selo-digital")
public class SeloDigitalController {

    @Autowired
    private SeloDigitalService seloDigitalService;

    @GetMapping("/entes")
    public Page<EntesDeclaradosDTO> listarEntesFiltrados(String codigo, String nome, Pageable pageable) throws Exception_Exception {
        List<EntesDeclaradosDTO> lista = seloDigitalService.listarEntesDeclarados();

        List<EntesDeclaradosDTO> filtrado = lista.stream()
                .filter(e -> codigo == null || codigo.equals(e.getCodigo()))
                .filter(e -> nome == null || (e.getNomeEntidade() != null && e.getNomeEntidade().toLowerCase().contains(nome.toLowerCase())))
                .collect(Collectors.toList());

        int inicio = Math.toIntExact(pageable.getOffset());
        int fim = Math.min(inicio + pageable.getPageSize(), filtrado.size());

        List<EntesDeclaradosDTO> paginado = (inicio > filtrado.size()) ? List.of() : filtrado.subList(inicio, fim);

        return new PageImpl<>(paginado, pageable, filtrado.size());
    }
}

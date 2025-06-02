package com.projeto.VHL.teste.Service;


import br.jus.tjsc.selo.EnteDeclaradoUtilidadePublicaEstadual;
import br.jus.tjsc.selo.Exception_Exception;
import br.jus.tjsc.selo.SeloService;
import com.projeto.VHL.teste.model.EntesDeclaradosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeloDigitalService {

    @Autowired
    private SeloService seloService;

    public List<EntesDeclaradosDTO> listarEntesDeclarados() throws Exception_Exception {
        List<EnteDeclaradoUtilidadePublicaEstadual> resposta = seloService.getEntesDeclaradosUtilidadePublicaEstadual();

        if (resposta == null || resposta.isEmpty()) {
            return List.of();
        }

        return resposta.stream()
                .map(e -> new EntesDeclaradosDTO(
                        e.getCdentepub(),
                        e.getLei(),
                        e.getNomeEntidade()
                ))
                .collect(Collectors.toList());
    }

}

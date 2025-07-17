package com.pw.projetofinal.controller;
import com.pw.projetofinal.mapper.CamisaMapper;
import com.pw.projetofinal.domain.Camisa;
import com.pw.projetofinal.dto.CamisaResponseDto;
import com.pw.projetofinal.service.CamisaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/camisas")
public class camisaController {

    final CamisaService service;
    final CamisaMapper mapper;

    public camisaController(CamisaService service, CamisaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CamisaResponseDto> listar() {

        List<Camisa> camisa = service.listar();
        List<CamisaResponseDto> dtos = new ArrayList<>();
        for (Camisa cam : camisa) {
            CamisaResponseDto localDto = mapper.doDto(cam);
            localDto.loadLinks(cam);
            dtos.add(localDto);
        }
        return dtos;
    }

}

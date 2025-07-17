package com.pw.projetofinal.controller;
import com.pw.projetofinal.core.exception.CamisaNotFoundExpection;
import com.pw.projetofinal.dto.CamisaRequestDto;
import com.pw.projetofinal.mapper.CamisaMapper;
import com.pw.projetofinal.domain.Camisa;
import com.pw.projetofinal.dto.CamisaResponseDto;
import com.pw.projetofinal.service.CamisaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/camisas")
public class camisaController {

    final CamisaService service;
    final CamisaMapper mapper;

    public camisaController(CamisaService service, CamisaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


//Listar Tudo
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

// Busca Por ID
    @GetMapping("/{id}")
    public ResponseEntity<CamisaResponseDto> getCamisaById(@PathVariable long id){
        Optional<Camisa> c = service.buscarPorId(id);
        if(c.isPresent()){

            CamisaResponseDto dto = mapper.doDto(c.get());

            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

// Criar Camisa
    @PostMapping
    public ResponseEntity<?> createCamisa(@RequestBody CamisaRequestDto c) throws URISyntaxException {
        Camisa cEntity = mapper.toEntity(c);
        Camisa camisa = service.adicionar(cEntity);

        return ResponseEntity.created(new URI("/pessoas/"+camisa.getId())).build();
    }

//Deletar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJoiaById(@PathVariable long id) throws CamisaNotFoundExpection {

        Optional<Camisa> c = service.buscarPorId(id);
        if(c.isEmpty()){
            throw new CamisaNotFoundExpection("Camisa com id " + id + " não encontrada.");
        }
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    //Atualizar por ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCamisa(@RequestBody Camisa c, @PathVariable long id){

        Optional<Camisa> camisa = service.buscarPorId(id);
        if(camisa.isPresent()){
            return ResponseEntity.ok(service.alterar(c));
        }
        return ResponseEntity.notFound().build();
    }

}

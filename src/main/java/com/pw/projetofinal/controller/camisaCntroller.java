package com.pw.projetofinal.controller;


import com.pw.projetofinal.domain.Camisa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/camisas")
public class camisaCntroller {

    @GetMapping
    public List<Camisa> listar(){
        return null;
    }

}

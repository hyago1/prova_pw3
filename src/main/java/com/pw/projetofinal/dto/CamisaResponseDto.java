package com.pw.projetofinal.dto;


import com.pw.projetofinal.controller.camisaController;
import com.pw.projetofinal.domain.Camisa;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Data
public class CamisaResponseDto extends RepresentationModel<CamisaResponseDto> {
    private String marca;
    private String tamanho;//gg, g, m, p, pp
    private String categoria;
    private Long isDeleted;
    private Float valor;

    public void loadLinks(Camisa camisa) {
        this.add(WebMvcLinkBuilder.linkTo(camisaController.class).slash(camisa.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(camisaController.class).withRel("camisas"));
        this.add(WebMvcLinkBuilder.linkTo(camisaController.class).slash(camisa.getId()).withRel("delete"));
    }
}
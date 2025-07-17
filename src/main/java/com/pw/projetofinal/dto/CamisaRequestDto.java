package com.pw.projetofinal.dto;

import lombok.Data;

import java.util.List;

@Data
public class CamisaRequestDto {
    private String imageURL;
    private String marca;
    private String tamanho; // ex: "P", "M", "G", "GG"
    private String categoria;
    private Float valor;
}
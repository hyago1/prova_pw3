package com.pw.projetofinal.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CamisaRequestDto {
    private String imageURL;
    private String marca;
    private String tamanho; // ex: "P", "M", "G", "GG"
    @NotBlank(message = "Categoria não pode estar em branco ou vazio.")
    private String categoria;
    private Float valor;
}
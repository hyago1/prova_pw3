package com.pw.projetofinal.mapper;
import com.pw.projetofinal.dto.CamisaRequestDto;
import com.pw.projetofinal.dto.CamisaResponseDto;
import org.mapstruct.Mapper;
import com.pw.projetofinal.domain.Camisa;
import org.springframework.context.annotation.Bean;


@Mapper(componentModel = "spring")
public interface CamisaMapper {
    Camisa toEntity(CamisaRequestDto CamisaRequestDto);
    CamisaResponseDto doDto(Camisa camisa);
}

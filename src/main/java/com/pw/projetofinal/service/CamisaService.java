package com.pw.projetofinal.service;


import org.springframework.stereotype.Service;
import com.pw.projetofinal.domain.Camisa;
import com.pw.projetofinal.repository.CamisaRepository;

@Service
public class CamisaService extends AbstractService<Camisa, CamisaRepository>{
    public CamisaService(CamisaRepository repository) {
        super(repository);
    }
}




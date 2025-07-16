package com.pw.projetofinal.service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class AbstractService <T, R extends JpaRepository<T, Long>> implements ICrudService<T> {
    R repo;
    public AbstractService(R repo) {
        this.repo = repo;
    }

    @Override
    public List<T> listar() {
        return repo.findAll();
    }

    public Optional<T> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public T adicionar(T entity ) {
        return repo.save(entity);
    }

    public T alterar(T entity) {
        return repo.save(entity);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }
}
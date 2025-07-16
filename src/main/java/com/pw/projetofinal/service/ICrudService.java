package com.pw.projetofinal.service;
 import com.pw.projetofinal.domain.Camisa ;
import java.util.List;
import java.util.Optional;
public interface ICrudService<T> {
    public List<T> listar();
    public Optional<T> buscarPorId(Long id);
    public T adicionar(T p);
    public T alterar(T p);
    public void remover(Long id);
}

package br.edu.usj.nomilk.dao;

import java.util.List;

public interface NoMilkDAO<T> {
    boolean salvar(T objeto);
    long update(T objeto);
    boolean remover (String id);
    T obter(String id);
    List<T> listarPorId(String id);
    List<T> listarTodos();
    void fecharConexao();
}

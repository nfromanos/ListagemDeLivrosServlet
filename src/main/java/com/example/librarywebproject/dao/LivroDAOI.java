package com.example.librarywebproject.dao;

import com.example.librarywebproject.Model.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroDAOI {
    Livro save(Livro livro);
    List<Livro> findAll();
    Livro findById(String id);
    void remove(Livro livro);
    Optional<Livro> update(Livro livro);

}

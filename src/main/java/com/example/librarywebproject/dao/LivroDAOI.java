package com.example.librarywebproject.dao;
import com.example.librarywebproject.Model.Livro;
import java.util.List;

public interface LivroDAOI {
    Livro save(Livro livro);
    List<Livro> findAll();

}

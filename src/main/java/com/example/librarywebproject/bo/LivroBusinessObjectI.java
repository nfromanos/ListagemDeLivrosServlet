package com.example.librarywebproject.bo;
import com.example.librarywebproject.Model.Livro;
import java.util.List;

public interface LivroBusinessObjectI {
    Livro save(Livro livro);
    List<Livro> findAll();
}

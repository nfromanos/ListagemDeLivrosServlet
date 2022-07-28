package com.example.librarywebproject.dao;

import com.example.librarywebproject.Model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDAOIImpl implements LivroDAOI {

    public static List<Livro> listaLivros = new ArrayList<>();

    private static long contadorID;

    @Override
    public Livro save(Livro livro) {
        contadorID++;
        livro.setId(contadorID);
        listaLivros.add(livro);
        return livro;
    }

    @Override
    public List<Livro> findAll() {
        return listaLivros;
    }
}

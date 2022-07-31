package com.example.librarywebproject.Model;
import lombok.Data;

@Data
public class Livro {

    private Long id;
    private String nomeLivro;
    private String nomeAutor;

    public Livro(String nomeLivro, String nomeAutor) {
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
    }
}
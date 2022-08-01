package com.example.librarywebproject.dao;
import com.example.librarywebproject.Model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class LivroDAOImpl implements LivroDAOI {

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

    @Override
    public Livro findById(String id) {
        Optional<Livro> livroEncontrado = listaLivros.stream()
                .filter(p -> p.getId().equals(Long.valueOf(id)))
                .findFirst();

        return livroEncontrado.orElse(null);
    }

    public void remove(Livro livro){
        listaLivros.remove(livro);
    }

    @Override
    public Optional<Livro> update(Livro livroNovo) {
        Livro livroAlterado = listaLivros.stream()
                .filter(p -> p.getId().equals(livroNovo.getId()))
                .findFirst().get();

        modificaLivro(livroAlterado, livroNovo);
        return Optional.of(livroNovo);
    }

    private void modificaLivro(Livro livroAlterado, Livro livroNovo) {
        livroAlterado.setId(livroNovo.getId());
        livroAlterado.setNomeLivro(livroNovo.getNomeLivro());
        livroAlterado.setNomeAutor(livroNovo.getNomeAutor());
    }


}

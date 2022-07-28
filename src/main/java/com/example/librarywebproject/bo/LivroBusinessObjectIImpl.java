package com.example.librarywebproject.bo;
import com.example.librarywebproject.Model.Livro;
import com.example.librarywebproject.dao.LivroDAOI;
import javax.inject.Inject;
import java.util.List;

public class LivroBusinessObjectIImpl implements LivroBusinessObjectI {

    LivroDAOI livroDAO;

    @Inject
    public LivroBusinessObjectIImpl(LivroDAOI livroDAOI) {
        this.livroDAO = livroDAOI;
    }

    @Override
    public Livro save(Livro livro) {
        valida(livro);
        livroDAO.save(livro);
        return livro;
    }

    public void valida(Livro livro){
        if (livro.getNomeLivro().isEmpty()){
            throw new IllegalArgumentException("Nome ou autor inválido!");
        }
    }

    @Override
    public List<Livro> findAll() {
        return livroDAO.findAll();
    }
}
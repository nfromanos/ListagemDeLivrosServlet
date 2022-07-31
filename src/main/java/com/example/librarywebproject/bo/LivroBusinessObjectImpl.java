package com.example.librarywebproject.bo;
import com.example.librarywebproject.dao.LivroDAOI;
import com.example.librarywebproject.Model.Livro;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class LivroBusinessObjectImpl implements LivroBusinessObjectI {

    @Inject
    private LivroDAOI livroDAO;

    @Inject
    public LivroBusinessObjectImpl(LivroDAOI livroDAOI) {
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

    @Override
    public Livro findById(String id) {
        Livro livro = livroDAO.findById(id);
        if(livro==null){
            throw new IllegalArgumentException("Livro não encontrado");
        }
        return livro;
    }

    public void remove(Livro livro){
        livroDAO.remove(livro);
    }

    @Override
    public Livro update(Livro livro) {
        Optional<Livro> optionalLivro = livroDAO.update(livro);
        return optionalLivro.get();
    }
}
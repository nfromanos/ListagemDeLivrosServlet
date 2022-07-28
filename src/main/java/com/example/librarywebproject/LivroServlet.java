package com.example.librarywebproject;
import com.example.librarywebproject.Model.Livro;
import com.example.librarywebproject.bo.LivroBusinessObjectI;
import com.example.librarywebproject.bo.LivroBusinessObjectIImpl;
import com.example.librarywebproject.dao.LivroDAOI;
import com.example.librarywebproject.dao.LivroDAOIImpl;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "livroservlet", value = "/livro-servlet")
public class LivroServlet extends HttpServlet {


    LivroDAOI livroDAOI = new LivroDAOIImpl();
    LivroBusinessObjectI businessObject = new LivroBusinessObjectIImpl(livroDAOI);
//
//    @Inject
//    public LivroServlet(LivroBusinessObjectI livroBusinessObjectI){
//        this.businessObject = livroBusinessObjectI;
//    }

    @Override
    public void init() {
        System.out.println("Início");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        businessObject.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cadastro-livros.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String nomeLivro = req.getParameter("nomeLivro");
        String nomeAutor = req.getParameter("nomeAutor");
        Livro livro = new Livro(nomeLivro, nomeAutor);

        Livro livroSalvo = businessObject.save(livro);

        List<Livro> listaDosLivros = businessObject.findAll();

        req.setAttribute("livros", listaDosLivros);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("lista-livros.jsp");
        requestDispatcher.forward(req, resp);


    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

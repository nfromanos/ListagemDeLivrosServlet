package com.example.librarywebproject.servlets;
import com.example.librarywebproject.bo.LivroBusinessObjectI;
import com.example.librarywebproject.Model.Livro;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "livroservlet", value = "/livro-servlet/*")
public class LivroServlet extends HttpServlet {

    @Inject
    private LivroBusinessObjectI businessObject;
    @Inject
    public LivroServlet(LivroBusinessObjectI livroBusinessObjectI){
        this.businessObject = livroBusinessObjectI;
    }

    @Override
    public void init() {
        System.out.println("Início");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getPathInfo();

        switch (path) {
            case "/cadastro-livros":
                doPost(request, response);
                break;
            case "/edicao-livro":
                carregarUpdate(request, response);
                break;
            case "/atualizar-livro":
                doPut(request, response);
                break;
            case "/excluir-livro":
                doDelete(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Chamando método.");
        response.setContentType("text/html");

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamando método.");
        resp.setContentType("text/html");

        Livro livro = criarLivro(req);
        businessObject.save(livro);
        List<Livro> listaDosLivros = businessObject.findAll();
        req.setAttribute("livros", listaDosLivros);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lista-livros.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Livro livro = businessObject.findById(id);
        businessObject.remove(livro);

        List<Livro> listaDosLivros = businessObject.findAll();
        req.setAttribute("livros", listaDosLivros);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lista-livros.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Livro livro = criarLivro(req);
        livro.setId(Long.parseLong(id));
        businessObject.update(livro);

        List<Livro> listaDosLivros = businessObject.findAll();
        req.setAttribute("livros", listaDosLivros);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lista-livros.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void carregarUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String idLivro = req.getParameter("id");
        Livro livro = businessObject.findById(idLivro);

        req.setAttribute("livro", livro);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/atualizar-livro.jsp");
        dispatcher.forward(req,resp);
    }

    public Livro criarLivro(HttpServletRequest req){
        String nomeLivro = req.getParameter("nomeLivro");
        String nomeAutor = req.getParameter("nomeAutor");
        return new Livro(nomeLivro, nomeAutor);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

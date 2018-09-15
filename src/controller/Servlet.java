package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaDao;
import model.Pessoa;

@WebServlet("/cadastrar")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pessoa p = new Pessoa();
		p.setNome(request.getParameter("NomePessoa"));
		p.setTelefone(request.getParameter("telefonePessoa"));
		p.setEmail(request.getParameter("enderecoPessoa"));
		p.setEndereco(request.getParameter("emailPessoa"));
		// Proc. Persistência
		PessoaDao dao = new PessoaDao();
		System.out.println("Id da pessoa armazenado: " + dao.gravar(p));
		
		response.sendRedirect("confirmacao.html");
}
	
}

package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grupo;
import persistence.GenericDao;
import persistence.GrupoDao;
import persistence.IGrupoDao;

@WebServlet("/ServletGrupo")
public class ServletGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IGrupoDao grpDao;

	public ServletGrupo() throws ClassNotFoundException, SQLException {
		super();
		this.grpDao = new GrupoDao(new GenericDao());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String botao = request.getParameter("gerar_grupo");
		List<Grupo> grupos = new ArrayList<Grupo>();
		String erro = "";
		String saida = "";
		try {
			if (botao.equals("Gerar Grupos")) {
				grpDao.gerarGrupos();
				grupos = this.grpDao.listarGrupos();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			request.setAttribute("grupos", grupos);
			rd.forward(request, response);
		}
	}

}

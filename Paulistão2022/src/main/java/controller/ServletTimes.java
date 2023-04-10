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

import model.Times;
import persistence.GenericDao;
import persistence.ITimesDao;
import persistence.TimeDao;

@WebServlet("/ServletTimes")
public class ServletTimes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ITimesDao cDao;

	public ServletTimes() throws ClassNotFoundException, SQLException {
		super();
		this.cDao = new TimeDao(new GenericDao());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String botao = request.getParameter("gerar_times");
		List<Times> times = new ArrayList<Times>();
		String erro = "";
		String saida = "";
		try {
			if (botao.equals("Visualizar Times")) {
				cDao.listaTimes();
				times = this.cDao.listaTimes();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("times.jsp");
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			request.setAttribute("times", times);
			rd.forward(request, response);
		}
	}

}

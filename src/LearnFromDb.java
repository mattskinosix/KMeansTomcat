
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import data.Data;
import data.OutOfRangeSampleSize;
import database.DatabaseConnectionException;
import database.EmptySetException;
import mining.KMeansMiner;

@WebServlet("/LearnFromDb")
public class LearnFromDb extends HttpServlet {

	/**
	 * 
	 */
	KMeansMiner mining = null;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws IOException, ServletException {
		response.setContentType("text/html");
		String nomeFile = request.getParameter("nomeFile");
		if (nomeFile != null & nomeFile!="") {
			try {
				mining.salva(nomeFile);
			} catch (FileNotFoundException | NullPointerException e) {
				request.getSession().setAttribute("salva", "0");
				request.setAttribute("mining", "nome vuoto, non salvato");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			request.getSession().setAttribute("salva", "0");
			request.setAttribute("mining", "Salvato con successo");
			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} else {
			if(request.getSession().getAttribute("salva")=="1") {
				request.getSession().setAttribute("salva", "0");
				request.setAttribute("mining", "non salvato");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				
			}else {
			String table = request.getParameter("table");
			int number = 0;
			try {

				number = Integer.parseInt(request.getParameter("k"));
			} catch (NumberFormatException e) {
				number = 0;
			}

			if (number < 0 | table == null) {
				request.setAttribute("mining", "Inserisce tabella e numero riprova");
				request.getRequestDispatcher("/index.jsp").forward(request, response);

			} else {
				Data data = null;

				try {
					data = new Data(table);

					try {
						mining = new KMeansMiner(number);
						mining.kmeans(data);
						request.getSession().setAttribute("selectedTab", "db");
						request.setAttribute("mining", mining.getC().toString(data));
						request.getSession().setAttribute("salva", "1");
						request.getRequestDispatcher("/index.jsp").forward(request, response);
					} catch (OutOfRangeSampleSize | NegativeArraySizeException e) {
						request.getSession().setAttribute("salva", "0");
						request.setAttribute("mining",
								"Error il numero di k richiesti è troppo elevato o negativo, riprova");
						request.getSession().setAttribute("selectedTab", "db");
						request.getRequestDispatcher("/index.jsp").forward(request, response);
					}
				} catch (DatabaseConnectionException | SQLException e1) {
					request.getSession().setAttribute("salva", "0");
					request.setAttribute("mining",
							"Connesione database fallita, controllare nome tabella e servizio mysql");
					request.getSession().setAttribute("selectedTab", "db");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				} catch (EmptySetException e1) {
					request.getSession().setAttribute("salva", "0");
					request.setAttribute("mining",
							"La tabella risulta essere vuota, chiedi allìamministratore di inserire i tuoi dati");
					request.getSession().setAttribute("selectedTab", "db");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}

			}
		}}
	}
}
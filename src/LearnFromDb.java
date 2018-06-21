
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import data.Data;
import data.OutOfRangeSampleSize;
import database.DatabaseConnectionException;
import mining.KMeansMiner;

@WebServlet("/LearnFromDb")
public class LearnFromDb extends HttpServlet {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)

			throws IOException, ServletException {
		response.setContentType("text/html");
		String table = request.getParameter("table");
		int i = Integer.parseInt(request.getParameter("k"));
		if( i==0 | table==null) {
			request.setAttribute("mining", "Inserisce tabella e numero riprova");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else {
		PrintWriter out = response.getWriter();
		Data data = null;
		KMeansMiner mining = null;
		request.getSession().setAttribute("selectedTab", "db");
		try {
			data = new Data(table);
			mining = new KMeansMiner(i);

			try {
				mining.kmeans(data);
				request.setAttribute("mining", mining.getC().toString(data));
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (OutOfRangeSampleSize e) {
				request.setAttribute("mining", "Error il numero di k richiesti � troppo elevato, riprova");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (DatabaseConnectionException |  SQLException e1) {
			System.out.println("CAPOCHCHIAHIHSHIAHIHSI");
			request.setAttribute("mining", "Connesione database fallita, controllare nome tabella e servizio mysql");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}
	}
}
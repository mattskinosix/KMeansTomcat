import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import data.Data;
import database.DatabaseConnectionException;
import database.EmptySetException;
import mining.KMeansMiner;

public class LearnFromFile extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		
		String namefile=request.getParameter("name");
		try {
			request.getSession().setAttribute("selectedTab","file");
			Data data = null;
			try {
				data = new Data("playtennis");
			} catch (MySQLSyntaxErrorException e) {
				request.setAttribute("miningFile","A quanto pare il programmatore ha sbagliato a formulare la query, Licenziatelo! ");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			} catch (SQLException e) {
				request.setAttribute("miningFile","Abbiamo problemi con il Database :(");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			} catch (EmptySetException e) {
				request.setAttribute("miningFile","tabella vuota");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			}
			KMeansMiner mining = new KMeansMiner(namefile);
			request.setAttribute("miningFile",mining.getC().toString(data));
			request.getRequestDispatcher("/index.jsp").forward(request, response);			
			
		}catch( FileNotFoundException | ClassNotFoundException e) {
			
			request.setAttribute("miningFile","File non trovato");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		
			e.printStackTrace();
		} catch (DatabaseConnectionException e) {
			request.setAttribute("miningFile","Connessione db fallita");
			e.printStackTrace();
		}
		
	}
	
	
	
}

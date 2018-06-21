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
				
			} catch (SQLException e) {
				
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

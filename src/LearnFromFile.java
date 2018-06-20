import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Data;
import mining.KMeansMiner;

public class LearnFromFile extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		
		String namefile=request.getParameter("name");
		try {
			Data data = new Data("playtennis");
			KMeansMiner mining = new KMeansMiner(namefile);
			request.setAttribute("mining",mining.getC().toString(data));
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);			
			
			
		}catch( FileNotFoundException | ClassNotFoundException e) {
			request.setAttribute("mining","Erroor");
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			
			e.printStackTrace();
		}
		
	}
	
	
	
}

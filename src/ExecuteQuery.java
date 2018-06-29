import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseConnectionException;
import database.DbAccess;
import database.TableData;

@SuppressWarnings("serial")
public class ExecuteQuery extends HttpServlet  {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		String nameTable=request.getParameter("query");
		DbAccess x = new DbAccess();
		request.getSession().setAttribute("selectedTab","store");
		try {
			x.initConnection();
		} catch (DatabaseConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		x.getConnection();
		TableData x3 = new TableData(x);
		try { 
			//
			//System.out.println("create table "+ nameTable+" ( "+ nameVar+" "+type+")");
			
			x3.creteNewTable(nameTable);
			request.getSession().setAttribute("error","Query corretta");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.getSession().setAttribute("error","Query sbagliata");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}finally {
			x.closeConnection();
		}
		
	}
	
	
	
}

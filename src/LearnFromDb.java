
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import data.Data;
import data.OutOfRangeSampleSize;
import mining.KMeansMiner;
@WebServlet("/LearnFromDb")
public class LearnFromDb extends HttpServlet {

    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    
	throws IOException, ServletException
    {
		
        response.setContentType("text/html");
      
        String table= request.getParameter("table");
        int i= Integer.parseInt(request.getParameter("k"));
        PrintWriter out = response.getWriter();
        Data data = new Data(table);
		KMeansMiner mining = new KMeansMiner(i);
		try {
			mining.kmeans(data);
		} catch (OutOfRangeSampleSize e) {
			e.printStackTrace();
			 out.println("<h1><font color= \"red\" >Error il numero di k richiesti è troppo elevato, riprova</h1></font><br/>");
		}
		request.setAttribute("mining",mining.getC().toString(data));
		//request.getRequestDispatcher("/index.jsp").forward(request, response);		
		/*
		System.out.println("ciaoooooo");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
     //   out.println("Antonio gAY");
        out.println(data);
        out.println(mining.getC().toString(data));
        mining.salva("mirko");
        out.println("</body>");
        out.println("</html>");
        */
    }

}
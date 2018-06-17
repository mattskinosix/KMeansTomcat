import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import data.Data;
import data.OutOfRangeSampleSize;
import mining.KMeansMiner;
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {

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
			int numIt = mining.kmeans(data);
		} catch (OutOfRangeSampleSize e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("ciaoooooo");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(data);
        out.println(mining.getC().toString(data));
        out.println("</body>");
        out.println("</html>");
    }
}
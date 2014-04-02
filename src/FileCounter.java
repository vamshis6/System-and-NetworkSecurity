

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FileCounter
 */
@WebServlet("/FileCounter")
public class FileCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	FileReader dao=null; 
    int count;
	public FileCounter() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        dao = new FileReader();
        try {
          count = dao.getCount();
        } catch (Exception e) {
          getServletContext().log("An exception occurred in FileCounter", e);
          throw new ServletException("An exception occurred in FileCounter"
              + e.getMessage());
        }
      }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		HttpSession httpSession=request.getSession(true);
		
		httpSession.setMaxInactiveInterval(5);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		    if (httpSession.isNew()) {
		      count++;
		    }
		    out.println("This site has been accessed " + count + " times.");
		  }
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

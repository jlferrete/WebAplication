package es.studium.LoginServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.studium.modelo.Editorial;
/**
 * Servlet implementation class HazAlgo
 */
public class MuestraEditorial extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MuestraEditorial()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException
	{

		try
		{

			HttpSession session = request.getSession(false);

				synchronized(session)
				{
										
					Editorial editorial = new Editorial();
					
					List <Editorial> editoriales = editorial.listarEditorial();
					
					session.setAttribute("editoriales", editoriales);
					
					response.sendRedirect("./vistas/listEditorial.jsp");
					
								
				}
		
		}catch(Exception E){
			System.out.println(E.getMessage());
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException
	{
		// TODO Auto-generated method stub
		doPost(request, response);
	}
}
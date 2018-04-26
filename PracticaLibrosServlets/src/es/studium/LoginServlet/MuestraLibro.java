package es.studium.LoginServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.studium.modelo.Libro;
/**
 * Servlet implementation class HazAlgo
 */
public class MuestraLibro extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MuestraLibro()
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

				Libro libro = new Libro();

				List <Libro> libros = libro.listarLibro();

				session.setAttribute("libros", libros);

				response.sendRedirect("./vistas/listLibro.jsp");

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
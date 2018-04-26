package es.studium.LoginServlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.studium.modelo.Libro;
/**
 * Servlet implementation class HazAlgo
 */
public class ModificarLibro extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarLibro()
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

				String todo = request.getParameter("todo");
				if(todo==null)
				{

				}
				else if(todo.equals("modify"))
				{
					
					Libro nuevoLibro = new Libro(
							Integer.parseInt(request.getParameter("idLibro")),
							(request.getParameter("tituloLibro")), 
							Double.parseDouble(request.getParameter("precioLibro")),
							Integer.parseInt(request.getParameter("cantidadLibro")), 
							Integer.parseInt(request.getParameter("idEditorialFK")), 
							Integer.parseInt(request.getParameter("idAutorFK")));

					if(nuevoLibro.modificarLibro(nuevoLibro))
					{

						response.sendRedirect("/PracticaLibrosServlets/muestraLibro");
					}
					else
					{

					}

				}

			}

		}catch(Exception E){
			System.out.println(E.getMessage());
		}

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

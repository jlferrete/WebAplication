package es.studium.LoginServlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.studium.modelo.Pedido;
/**
 * Servlet implementation class HazAlgo
 */
public class ModificarPedido extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarPedido()
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
				
					
					Pedido nuevoPedido = new Pedido(
							Integer.parseInt(request.getParameter("idPedido")));

					if(nuevoPedido.modificarPedido(nuevoPedido))
					{
						response.sendRedirect("/PracticaLibrosServlets/muestraPedido");
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

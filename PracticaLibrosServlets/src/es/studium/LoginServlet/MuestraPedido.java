package es.studium.LoginServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.studium.modelo.Pedido;
/**
 * Servlet implementation class HazAlgo
 */
public class MuestraPedido extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MuestraPedido()
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
										
					Pedido pedido = new Pedido();
					
					List <Pedido> pedidos = pedido.listarPedido();
					
					session.setAttribute("pedidos", pedidos);
					
					response.sendRedirect("./vistas/listPedido.jsp");
								
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
		
		doPost(request, response);
	}
}
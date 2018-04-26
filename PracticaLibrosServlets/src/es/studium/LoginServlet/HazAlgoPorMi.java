package es.studium.LoginServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class HazAlgo
 */
public class HazAlgoPorMi extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HazAlgoPorMi()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try
		{
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Haciendo algo</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Haciendo algo...</h2>");
			// Recuperar el nombre de usuario
			String usuario;
			HttpSession session = request.getSession(false);
			if(session == null)
			{
				out.println("<h3>No has iniciado sesión</h3>");
			}
			else
			{
				synchronized(session)
				{
					usuario = (String)
							session.getAttribute("usuario");
				}
				out.println("<table>");
				out.println("<tr>");
				out.println("<td>Usuario:</td>");
				out.println("<td>"+usuario+"</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<p><a href='logout'>Salir</a></p>");
			}
			out.println("</body>");
			out.println("</html>");
		}
		finally
		{
			// Cerramos objetos
			out.close();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
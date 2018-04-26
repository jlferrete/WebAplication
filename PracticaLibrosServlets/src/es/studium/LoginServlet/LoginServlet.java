package es.studium.LoginServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.sun.istack.internal.logging.Logger;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	// Pool de conexiones a la base de datos
	private DataSource pool;
	// Determina a qué página jsp se redirigirá
	String nextPage = "";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet()
	{
		super();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			// Obtener una conexión del pool
			conn = pool.getConnection();
			stmt = conn.createStatement();
			//Recuperar los parámetros usuario y password de la petición request
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			//Validar los parámetros de la petición request
			if(usuario.length()==0)
			{
				
			}
			else if(password.length()==0)
			{
				
			}
			else
			{
				//Verificar que existe el usuario y su correspondiente clave
				StringBuilder sqlStr = new StringBuilder();
				sqlStr.append("SELECT * FROM usuarios WHERE ");
				sqlStr.append("STRCMP(usuarios.loginUsuario, '").append(usuario).append("') = 0");
				sqlStr.append(" AND STRCMP(usuarios.passUsuario, PASSWORD('").append(password).append("')) = 0");
				//out.println("<p>"+sqlStr.toString()+"</p>");
				ResultSet rset = stmt.executeQuery(sqlStr.toString());
				if(!rset.next())
				{
									
					nextPage= "errorLogin.jsp";
				}
				else
				{
					HttpSession session = request.getSession(false);
					if(session != null)
					{
						session.invalidate();
					}
					session = request.getSession(true);
					synchronized(session)
					{
						session.setAttribute("usuario", usuario);
					}
					
					nextPage = "menu.jsp";
				}
			}
			
		}
		catch(SQLException ex)
		{
			
		}
		finally
		{
			try
			{
				if(stmt != null)
				{
					stmt.close();
				}
				if(conn != null)
				{
					// Esto devolvería la conexión al pool
					conn.close();
				}
			}
			catch(SQLException ex)
			{
			
			}
		}
				
		response.sendRedirect(nextPage);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException
	{
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	public void init(ServletConfig config) throws ServletException
	{
		try
		{
			// Crea un contecto para poder luego buscar el recurso DataSource
			InitialContext ctx = new InitialContext();
			// Busca el recurso DataSource en el contexto
			pool = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql_tiendalibros");
			if(pool == null)
			{
				throw new ServletException("DataSource desconocida 'mysql_tiendalibros'");
			}
		}
		catch(NamingException ex)
		{
			
		}
	}
}
package es.studium.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Editorial {

	private int idEditorial;
	private String nombreEditorial;
	private DataSource pool;

	public Editorial(){
		this.idEditorial = 0;
		this.nombreEditorial = null;
	}
	
	public Editorial(int idEditorial, String nombreEditorial){
		this.idEditorial = idEditorial;
		this.nombreEditorial = nombreEditorial;
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getNombreEditorial() {
		return nombreEditorial;
	}

	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}

	public List<Editorial> listarEditorial()
	{
		List<Editorial> listaEditoriales = new ArrayList<Editorial>();
		String sql = "SELECT * FROM editoriales";
		// Aquí deberiamos de hacer la conexión
		try
		{
			Connection conn = null;
			Statement stmt = null;
			
			InitialContext ctx = new InitialContext();
			pool = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql_tiendalibros");
			conn = pool.getConnection();
			//Aqui creamos el statement
			stmt = conn.createStatement();
			ResultSet resulSet = stmt.executeQuery(sql);
			//Recorremos la base de datos y mientras queden resultados realizaremos lo siguiente
			while (resulSet.next()) 
			{
				int idEditorial = resulSet.getInt("idEditorial");
				String nombreEditorial = resulSet.getString("nombreEditorial");
				Editorial editorial = new Editorial(idEditorial, nombreEditorial);
				listaEditoriales.add(editorial);
			}

		}
		catch (Exception E)
		{
			System.out.println(E.getMessage()+E.getStackTrace());
		}
		return listaEditoriales;
	}
}


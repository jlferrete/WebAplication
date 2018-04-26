package es.studium.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Autor {

	private int idAutor;
	private String nombreAutor;
	private String apellido1Autor;
	private String apellido2Autor;
	private DataSource pool;

	public Autor()
	{

		this.idAutor = 0;
		this.nombreAutor = null;
		this.apellido1Autor = null;
		this.apellido2Autor = null;
	}

	public Autor(int idAutor, String nombreAutor, String apellido1Autor, String apellido2Autor){
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.apellido1Autor = apellido1Autor;
		this.apellido2Autor = apellido2Autor;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getApellido1Autor() {
		return apellido1Autor;
	}

	public void setApellido1Autor(String apellido1Autor) {
		this.apellido1Autor = apellido1Autor;
	}

	public String getApellido2Autor() {
		return apellido2Autor;
	}

	public void setApellido2Autor(String apellido2Autor) {
		this.apellido2Autor = apellido2Autor;
	}

	public List<Autor> listarAutor()
	{
		List<Autor> listaAutores = new ArrayList<Autor>();
		String sql = "SELECT * FROM autores";
		//TODO Aquí deberiamos de hacer la conexión
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
			while (resulSet.next()) 
			{
				int idAutor = resulSet.getInt("idAutor");
				String nombreAutor = resulSet.getString("nombreAutor");
				String apellido1Autor = resulSet.getString("apellido1Autor");
				String apellido2Autor = resulSet.getString("apellido2Autor");

				Autor autor = new Autor(idAutor, nombreAutor, apellido1Autor, apellido2Autor);
				listaAutores.add(autor);
			}

		}
		catch (Exception E)
		{
			System.out.println(E.getMessage()+E.getStackTrace());
		}
		return listaAutores;
	}
}
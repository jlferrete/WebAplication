package es.studium.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class Libro {

	private int idLibro;
	private String tituloLibro;
	private double precioLibro;
	private int cantidadLibro;
	private int idEditorialFK;
	private int idAutorFK;
	private String nombreEditorial;
	private String nombreAutor;
	private String apellido1Autor;
	private String apellido2Autor;
	private DataSource pool;

	public Libro(){
		this.idLibro = 0;
		this.tituloLibro= null;
		this.precioLibro = 0.0;
		this.cantidadLibro= 0;
		this.idEditorialFK = 0;
		this.idAutorFK= 0;
	}
	
	public Libro(int idLibro, String tituloLibro, double precioLibro, int cantidadLibro, int idEditorialFK, int idAutorFK){
		this.idLibro = idLibro;
		this.tituloLibro= tituloLibro;
		this.precioLibro = precioLibro;
		this.cantidadLibro= cantidadLibro;
		this.idEditorialFK = idEditorialFK;
		this.idAutorFK= idAutorFK;

	}
	
	public Libro(int idLibro, String tituloLibro, double precioLibro, int cantidadLibro, String nombreEditorial, String nombreAutor, String apellido1Autor, String apellido2Autor){
		this.idLibro = idLibro;
		this.tituloLibro= tituloLibro;
		this.precioLibro = precioLibro;
		this.cantidadLibro= cantidadLibro;
		this.nombreEditorial = nombreEditorial;
		this.nombreAutor = nombreAutor;
		this.apellido1Autor = apellido1Autor;
		this.apellido2Autor = apellido2Autor;
	
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public double getPrecioLibro() {
		return precioLibro;
	}

	public void setPrecioLibro(double precioLibro) {
		this.precioLibro = precioLibro;
	}

	public int getCantidadLibro() {
		return cantidadLibro;
	}

	public void setCantidadLibro(int cantidadLibro) {
		this.cantidadLibro = cantidadLibro;
	}

	public int getIdEditorialFK() {
		return idEditorialFK;
	}

	public void setIdEditorialFK(int idEditorialFK) {
		this.idEditorialFK = idEditorialFK;
	}

	public int getIdAutorFK() {
		return idAutorFK;
	}

	public void setIdAutorFK(int idAutorFK) {
		this.idAutorFK = idAutorFK;
	}
	
	public String getNombreEditorial() {
		return nombreEditorial;
	}

	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
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
	
	public List<Libro> listarLibro()
	{
		List<Libro> listaLibros = new ArrayList<Libro>();

		String sql = "SELECT idLibro,tituloLibro,precioLibro,cantidadLibro,nombreEditorial,nombreAutor,apellido1Autor,apellido2Autor "
				+ "from Libros INNER JOIN Autores ON Libros.idAutorFK = Autores.idAutor INNER JOIN Editoriales ON Libros.idEditorialFK "
				+ "= Editoriales.idEditorial";

		try
		{
			Connection conn = null;
			Statement stmt = null;
			
			InitialContext ctx = new InitialContext();
			pool = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql_tiendalibros");
			conn = pool.getConnection();

			stmt = conn.createStatement();

			ResultSet resulSet = stmt.executeQuery(sql);

			while (resulSet.next()) 
			{
				int idLibro = resulSet.getInt("idLibro");
				String tituloLibro = resulSet.getString("tituloLibro");
				Double precioLibro = resulSet.getDouble("precioLibro");
				int cantidadLibro = resulSet.getInt("cantidadLibro");
				String nombreEditorial = resulSet.getString("nombreEditorial");
				String nombreAutor = resulSet.getString("nombreAutor");
				String apellido1Autor = resulSet.getString("apellido1Autor");
				String apellido2Autor = resulSet.getString("apellido2Autor");
				Libro libro = new Libro(idLibro, tituloLibro, precioLibro, cantidadLibro, nombreEditorial, nombreAutor, apellido1Autor, apellido2Autor);
				listaLibros.add(libro);
			}


		}
		catch (Exception E)
		{
			System.out.println(E.getMessage()+E.getStackTrace());
		}
		return listaLibros;
	}

	public boolean insertarLibro(Libro libro) throws SQLException {

		try
		{
			Connection conn = null;
			Statement stmt = null;
			InitialContext ctx = new InitialContext();
			pool = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql_tiendalibros");
			conn = pool.getConnection();
			stmt = conn.createStatement();
			String sql2 = "INSERT INTO libros VALUES (null,"+"'"+libro.getTituloLibro()+"'"+","+
			libro.getPrecioLibro()+","+libro.getCantidadLibro()+","+libro.getIdEditorialFK()+","+libro.getIdAutorFK()+");";
			int resultado = stmt.executeUpdate(sql2);
			stmt.close();
			return true;						

		
		}
		catch (Exception E)
		{
			System.out.println(E.getMessage()+E.getStackTrace());
		}
		return false;
	}
	
	public boolean modificarLibro(Libro libro) throws SQLException {
		
		try
		{
			Connection conn = null;
			Statement stmt = null;
			
			InitialContext ctx = new InitialContext();
			pool = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql_tiendalibros");
			conn = pool.getConnection();
			stmt = conn.createStatement();
			String sql3 = "UPDATE libros SET tituloLibro='"+libro.getTituloLibro()+"', precioLibro="+libro.getPrecioLibro()+", cantidadLibro="+libro.getCantidadLibro()+", idEditorialFK="+libro.getIdEditorialFK()+", idAutorFK="+libro.getIdAutorFK()+" WHERE idlibro="+libro.getIdLibro()+";";
			int resultado = stmt.executeUpdate(sql3);
			stmt.close();
			return true;						

		}
		catch (Exception E)
		{
			System.out.println(E.getMessage()+E.getStackTrace());
		}
		return false;
	}

	
}
		
		



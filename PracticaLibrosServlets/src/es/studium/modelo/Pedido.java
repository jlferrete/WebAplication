package es.studium.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Pedido {
	
	private int idPedido;
	private Date fechaEnvioPedido;
	private Date fechaPedido;
	private int cantidadPedido;
	private String loginUsuario;
	private String tituloLibro;
	private DataSource pool;
	
	private int idUsuarioFK;
	private int idLibroFK;

	public Pedido(){
		this.idPedido = 0;
		this.fechaEnvioPedido = null;
		this.fechaPedido = null;
		this.cantidadPedido = 0;
		this.loginUsuario = null;
		this.tituloLibro = null;
		this.idUsuarioFK = 0;
		this.idLibroFK = 0;
	}
	
	public Pedido (int idPedido){
		this.idPedido = idPedido;
	}
	
	public Pedido (int idPedido, Date fechaEnvioPedido, Date fechaPedido, int cantidadPedido, String loginUsuario, String tituloLibro){
		this.idPedido = idPedido;
		this.fechaEnvioPedido = fechaEnvioPedido;
		this.fechaPedido = fechaPedido;
		this.cantidadPedido = cantidadPedido;
		this.loginUsuario = loginUsuario;
		this.tituloLibro = tituloLibro;
	}
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFechaEnvioPedido() {
		return fechaEnvioPedido;
	}

	public void setFechaEnvioPedido(Date fechaEnvioPedido) {
		this.fechaEnvioPedido = fechaEnvioPedido;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public int getCantidadPedido() {
		return cantidadPedido;
	}

	public void setCantidadPedido(int cantidadPedido) {
		this.cantidadPedido = cantidadPedido;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public int getIdUsuarioFK() {
		return idUsuarioFK;
	}

	public void setIdUsuarioFK(int idUsuarioFK) {
		this.idUsuarioFK = idUsuarioFK;
	}

	public int getIdLibroFK() {
		return idLibroFK;
	}

	public void setIdLibroFK(int idLibroFK) {
		this.idLibroFK = idLibroFK;
	}

	public List<Pedido> listarPedido()
	{
		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		String sql = "SELECT idPedido,fechaEnvioPedido,fechaPedido,cantidadPedido,loginUsuario,tituloLibro "
				+ "FROM Pedidos INNER JOIN Usuarios ON Pedidos.idUsuarioFK = usuarios.idUsuario "
				+ "INNER JOIN Libros ON Pedidos.idLibroFK = Libros.idLibro;";
		
		try
		{
			Connection conn = null;
			Statement stmt = null;
			
			InitialContext ctx = new InitialContext();
			pool = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql_tiendalibros");
			conn = pool.getConnection();
			
			stmt = conn.createStatement();
			ResultSet resulSet = stmt.executeQuery(sql);
			//Recorremos la base de datos y mientras queden resultados realizaremos lo siguiente
			while (resulSet.next()) 
			{
				int idPedido = resulSet.getInt("idPedido");
				Date fechaEnvioPedido = resulSet.getDate("fechaEnvioPedido");
				Date fechaPedido = resulSet.getDate("fechaPedido");
				int cantidadPedido = resulSet.getInt("cantidadPedido");
				String loginUsuario = resulSet.getString("loginUsuario");
				String tituloLibro = resulSet.getString("tituloLibro");
				Pedido pedido = new Pedido(idPedido, fechaEnvioPedido, fechaPedido, cantidadPedido, loginUsuario, tituloLibro);
				listaPedidos.add(pedido);
			}

		}
		catch (Exception E)
		{
			System.out.println(E.getMessage()+E.getStackTrace());
		}
		return listaPedidos;
	}
	
public boolean modificarPedido(Pedido pedido) throws SQLException {
		
		//Aqui debe ir la conexion
		try
		{
			Connection conn = null;
			Statement stmt = null;
			InitialContext ctx = new InitialContext();
			pool = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql_tiendalibros");
			conn = pool.getConnection();
			
			stmt = conn.createStatement();
			
			String sql = "UPDATE pedidos SET fechaEnvioPedido= CURDATE() "+"WHERE idPedido="+pedido.getIdPedido()+";";
			
			int resultado = stmt.executeUpdate(sql);
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



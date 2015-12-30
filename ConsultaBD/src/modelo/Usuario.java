package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.BeanUsuario;

public class Usuario {
	
	public static BeanUsuario consultarUsuario(String usuario){
		BeanUsuario busuario=null;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from Usuario where usuario='"+usuario+"'");
			while(rs.next()){
				busuario=new BeanUsuario(rs.getString(2), rs.getString(3), rs.getInt(4)+"", rs.getString(5), usuario, rs.getString(7));
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return busuario;
	}

}

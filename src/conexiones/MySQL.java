/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author raulsantiago
 */
public class MySQL {
    
    
    
   
    
    
    public ArrayList<Libros> listadolibros() {

                Boolean conectado = false;
		//Declaración del vector de la clase Avión 
		ArrayList<Libros> listadobiblioteca = new ArrayList<Libros>();
                
		// Parametros
		String driver = "com.mysql.cj.jdbc.Driver";
		String database = "biblioteca";
		String hostname = "localhost";
		String port = "3306";
		String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&serverTimeZone=CEST";
		String usr = "root";
		String pwd = "12345678";
		//Referencias de las clases de las bases de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;


		try {
			//Se levanta el driver
			Class.forName(driver);
		
			//Se establece conexión con la base de datos
			conn = DriverManager.getConnection(url, usr, pwd);
			
			//Se define la consulta
			String sql = "SELECT titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura, observaciones, informe FROM libros";
			
			//Se prepara la sentencia a ejecutar
			pstm = conn.prepareStatement(sql);
			
			//Se ejecuta la sentencia y recogen los resultados
			rs = pstm.executeQuery();
			
			//Se itere por lo resultados
			while (rs.next()) {
				
				//Instancio la clase Avión
				Libros nuevo = new Libros();
				
				//Asigna el numbre, origen y destino de las columnas de la tabla al avión
				nuevo.setTitulo(rs.getString("titulo"));
				nuevo.setAutor(rs.getString("autor"));
				nuevo.setRevista(rs.getString("revista"));
                                nuevo.setEditorial(rs.getString("editorial"));
				nuevo.setCategoria(rs.getString("categoria"));
				nuevo.setNrevista(rs.getInt("nRevista"));
                                nuevo.setAño(rs.getInt("ano"));
				nuevo.setISBN(rs.getString("ISBN"));
				nuevo.setLugar(rs.getString("lugar"));
                                nuevo.setDeposito_legal(rs.getString("deposito_legal"));
				nuevo.setEstante(rs.getString("estante"));
				nuevo.setUbicacion(rs.getString("ubicacion"));
                                nuevo.setSignatura(rs.getString("signatura"));
                                nuevo.setObservaciones(rs.getString("observaciones"));
				nuevo.setInforme(rs.getString("informe"));
				
				listadobiblioteca.add(nuevo);
                                

			}

		} catch (ClassNotFoundException | SQLException e) {

			System.out.println(e);

		} finally {

			try {
				
				//Se cierran los recursos en åorden inverso a su creación
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
                                
                              
                             
				//devuelve el vector de aviones
                                
                                //new Datosalmacenados(listadobiblioteca);
				return listadobiblioteca;
                                
			} catch (SQLException e) {
				System.out.println(e);
			}

		}
		return null;

	}
    	
}

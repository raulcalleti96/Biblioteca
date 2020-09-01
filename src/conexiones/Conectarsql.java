package conexiones;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.corba.se.pept.transport.Connection;

public class Conectarsql {

	// Librería de MySQL
	public String driver = "com.mysql.jdbc.Driver";

	// Nombre de la base de datos
	public String database = "databasemovies";

	// Host
	public String hostname = "localhost";

	// Puerto
	public String port = "3306";

	// Ruta de nuestra base de datos (desactivamos el uso de SSL con
	// "?useSSL=false")
	public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

	// Nombre de usuario
	public String username = "root";

	// Clave de usuario
	public String password = "123456789";

	public Connection conectarMySQL() {
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}

package conexiones;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase MySQL
 *
 * Contiene los métodos encargados de recibir los datos de la base de datos
 * local con los datos de los libros
 *
 * @author raulsantiago
 * @version 1.0
 */
public class MySQL {

    /**
     * ArrayList donde se almacenarán los datos recibidos de la base de datos de
     * tipo Libros
     */
    ArrayList<Libros> listadobiblioteca = new ArrayList<>();

    /**
     * Variable que almacenará las idlibros con el objetivo de que almacene la
     * id del último libro almacenado para poder añadir uno nuevo detrás
     */
    int ultimaID;

    /**
     * Devuelve un Array con todos los libros de la base de datos
     *
     * @param valor <ul>
     * <li>Si pasa un valor con el cual el método mostrará en la JTable los
     * registros con ese valor</li>
     * <li>Si pasa como valor <i>null</i> el método devolverá todos los
     * registros</li>
     * </ul>
     * @param filtro<ul>
     * <li>Si pasa un filtro ayudará a buscar los registros con el valor y
     * filtro para mostrarlos</li>
     * <li>Si pasa como valor <i>null</i> el método devolverá todos los
     * registros</li>
     * </ul>
     * @return listadoLibros Devuelve los registros solicitados
     */
    public ArrayList<Libros> listadoLibros(String valor, String filtro) {

        //Si no se recibe ni un valor y ningún valor de filtro mostrará todos los registros
        if (valor == null && filtro == null) {

            //Elimina los registros actuales del array 
            listadobiblioteca.removeAll(listadobiblioteca);

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
                String sql = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros";

                //Se prepara la sentencia a ejecutar
                pstm = conn.prepareStatement(sql);

                //Se ejecuta la sentencia y recogen los resultados
                rs = pstm.executeQuery();

                //Se itere por lo resultados
                while (rs.next()) {

                    //Instancio la clase Avión
                    Libros nuevo = new Libros();

                    //Asigna el numbre, origen y destino de las columnas de la tabla al avión
                    nuevo.setIdlibros(rs.getInt("idlibros"));
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
                    ultimaID = rs.getInt("idlibros");

                    //Añade el libro leido al array
                    listadobiblioteca.add(nuevo);

                }
                //Recoge las posibles excepciones que se pueden ocasionar
            } catch (ClassNotFoundException | SQLException e) {

                System.out.println(e);

            } finally {

                try {

                    //Se cierran los recursos en orden inverso a su creación
                    if (rs != null) {
                        rs.close();
                    }
                    if (pstm != null) {
                        pstm.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }

                    //Devuelve el array con todos los registros
                    return listadobiblioteca;

                    //Recoge la posible excepción que pueda proporcionar la SQL 
                } catch (SQLException e) {
                    System.out.println(e);
                }

            }

            //En caso de que se pase como parametro un valor y filtro se mostrará los registros con ese valor
        } else {

            //Declaración de la variable que almacenará la sentencia 
            String SSQL = "";

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

            //Condiciones dependiendo del filtro que busca y su sentencia SQL
            if (filtro.equalsIgnoreCase("titulo")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE titulo LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("autor")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE autor LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("revista")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE revista LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("editorial")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE editorial LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("categoria")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE categoria LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("nRevista")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE nRevista LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("ano")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE ano LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("ISBN")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE ISBN LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("lugar")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE lugar LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("deposito_legal")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE deposito_legal LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("estante")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE estante LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("ubicacion")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE ubicacion LIKE '%" + valor + "%'";

            } else if (filtro.equalsIgnoreCase("signatura")) {

                SSQL = "SELECT idlibros, titulo, autor, revista, editorial, categoria, nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura FROM libros WHERE signatura LIKE '%" + valor + "%'";

            }

            try {

                //Se levanta el driver
                Class.forName(driver);
                //Se establece conexión con la base de datos
                conn = DriverManager.getConnection(url, usr, pwd);
                //Se define la consulta
                pstm = conn.prepareStatement(SSQL);
                //Se ejecuta la sentencia y recogen los resultados
                rs = pstm.executeQuery();

                //Se itere por lo resultados
                while (rs.next()) {
                    Libros nuevo = new Libros();

                    nuevo.setIdlibros(rs.getInt("idlibros"));
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

                    //Devuelve el array con todos los registros
                    listadobiblioteca.add(nuevo);

                }

                //Recoge las posibles excepciones que se pueden ocasionar
            } catch (ClassNotFoundException | SQLException e) {

                System.out.println(e);

            } finally {

                try {

                    //Se cierran los recursos en orden inverso a su creación
                    if (rs != null) {
                        rs.close();
                    }
                    if (pstm != null) {
                        pstm.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }

                    //Devuelve el array con todos los registros
                    return listadobiblioteca;
                    //Recoge la posible excepción que pueda proporcionar la SQL 
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }

        }
        return null;

    }

    /**
     * Método que permitirá cambiar el dato proporcionado al registro de la base
     * de datos
     *
     * @param libro un libro con los datos a modificar
     */
    public void cambioDatos(Libros libro) {

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

            //Se define la actualización
            String sql = "UPDATE libros SET titulo='" + libro.getTitulo() + "', autor='" + libro.getAutor() + "', revista='" + libro.getRevista() + "', editorial='" + libro.getEditorial() + "', categoria= '" + libro.getCategoria() + "" + "', nRevista='" + String.valueOf(libro.getNrevista()) + "', ano='" + String.valueOf(libro.getAño()) + "', ISBN='" + libro.getISBN() + "', deposito_legal='" + libro.getDeposito_legal() + "', estante='" + libro.getEstante() + "', ubicacion='" + libro.getUbicacion() + "', signatura='" + libro.getSignatura() + "' WHERE (idlibros= '" + libro.getIdlibros() + "');";

            //Se prepara la actualización
            pstm = conn.prepareStatement(sql);

            //Se ejecuta la sentencia
            pstm.executeUpdate(sql);

            //Recoge la posible excepción que pueda proporcionar la SQL 
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println(e);

        } finally {

            try {

                //Se cierran los recursos en orden inverso a su creación
                if (pstm != null) {

                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
                //Recoge la posible excepción que pueda proporcionar la SQL 
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    }

    /**
     * Método para añadir un nuevo registro a la base de datos
     *
     * @param libro Se pasa los valores del nuevo libros a registrar
     */
    public void nuevoLibro(Libros libro) {
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

            //Se define la sentencia
            String sql = "INSERT INTO libros (idlibros, titulo, autor, revista, editorial, categoria,nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura)" + " VALUES ('" + (ultimaID + 1) + "', '" + libro.getTitulo() + "', '" + libro.getAutor() + "', '" + libro.getRevista() + "', '" + libro.getEditorial() + "', '" + libro.getCategoria() + "', '" + String.valueOf(libro.getNrevista()) + "', '" + String.valueOf(libro.getAño()) + "', '" + libro.getISBN() + "', '" + libro.getLugar() + "', '" + libro.getDeposito_legal() + "', '" + libro.getEstante() + "', '" + libro.getUbicacion() + "', '" + libro.getSignatura() + "');";

            //Se prepara la sentencia
            pstm = conn.prepareStatement(sql);

            //Se ejecuta la sentecia
            pstm.executeUpdate(sql);
            //Recoge la posible excepción que pueda proporcionar la SQL 
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println(e);

        } finally {

            try {

                //Se cierran los recursos en åorden inverso a su creación
                if (pstm != null) {

                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
                //Recoge la posible excepción que pueda proporcionar la SQL 
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    }

}

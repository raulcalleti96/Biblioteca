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

    ArrayList<Libros> listadobiblioteca = new ArrayList<>();
    int valorprimario;

    public ArrayList<Libros> listadolibros(String valor, String filtro) {

        if (valor == null && filtro == null) {

            listadobiblioteca.removeAll(listadobiblioteca);
            Boolean conectado = false;
            //Declaración del vector de la clase Avión 

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
                    valorprimario = rs.getInt("idlibros");
                    

                    listadobiblioteca.add(nuevo);

                }

            } catch (ClassNotFoundException | SQLException e) {

                System.out.println(e);

            } finally {

                try {

                    //Se cierran los recursos en åorden inverso a su creación
                    if (rs != null) {
                        rs.close();
                    }
                    if (pstm != null) {
                        pstm.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }

                    //devuelve el vector de aviones
                    //new Datosalmacenados(listadobiblioteca);
                    return listadobiblioteca;

                } catch (SQLException e) {
                    System.out.println(e);
                }

            }

        } else {

            String SSQL = "";
            //Declaración del vector de la clase Avión 
            ArrayList<Libros> listadobiblioteca = new ArrayList<>();

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

                Class.forName(driver);
                conn = DriverManager.getConnection(url, usr, pwd);
                pstm = conn.prepareStatement(SSQL);
                rs = pstm.executeQuery();

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



                    listadobiblioteca.add(nuevo);

                }

            } catch (ClassNotFoundException | SQLException e) {

                System.out.println(e);

            } finally {

                try {

                    //Se cierran los recursos en åorden inverso a su creación
                    if (rs != null) {
                        rs.close();
                    }
                    if (pstm != null) {
                        pstm.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }

                    //devuelve el vector de aviones
                    //new Datosalmacenados(listadobiblioteca);
                    return listadobiblioteca;

                } catch (SQLException e) {
                    System.out.println(e);
                }
            }

        }
        return null;

    }

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

            String sql = "UPDATE libros SET titulo='" + libro.getTitulo() + "', autor='" + libro.getAutor() + "', revista='" + libro.getRevista() + "', editorial='" + libro.getEditorial() + "', categoria= '" + libro.getCategoria() + "" + "', nRevista='" + String.valueOf(libro.getNrevista()) + "', ano='" + String.valueOf(libro.getAño()) + "', ISBN='" + libro.getISBN() + "', deposito_legal='" + libro.getDeposito_legal() + "', estante='" + libro.getEstante() + "', ubicacion='" + libro.getUbicacion() + "', signatura='" + libro.getSignatura() + "' WHERE (idlibros= '" + libro.getIdlibros() + "');";

            pstm = conn.prepareStatement(sql);

            int rows = pstm.executeUpdate(sql);

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

            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    }

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

            String sql;
            sql = "INSERT INTO libros (idlibros, titulo, autor, revista, editorial, categoria,nRevista, ano, ISBN, lugar, deposito_legal, estante, ubicacion, signatura)"+ " VALUES ('"+ (valorprimario+1)+ "', '" + libro.getTitulo() + "', '" + libro.getAutor() +"', '"+libro.getRevista() +"', '" + libro.getEditorial() + "', '" + libro.getCategoria() + "', '"+ String.valueOf(libro.getNrevista()) +"', '" + String.valueOf(libro.getAño()) + "', '" + libro.getISBN() + "', '" + libro.getLugar() + "', '" + libro.getDeposito_legal() + "', '" + libro.getEstante() + "', '" + libro.getUbicacion() +"', '"+ libro.getSignatura() + "');";
      
            pstm = conn.prepareStatement(sql);

            int rows = pstm.executeUpdate(sql);

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

            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    }

}

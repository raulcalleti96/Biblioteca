package conexiones;

/**
 * Clase Libros
 *
 * Contiene la información de cada libro o revista
 *
 * @author Raul Santiago Prieto
 * @version 1.0
 */
public class Libros {

    /**
     * ID del libro o revista
     */
    private int idlibros;

    /**
     * Título del libro
     */
    private String titulo;

    /**
     * Autor del libro
     */
    private String autor;

    /**
     * Nombre de la revista
     */
    private String revista;

    /**
     * Editorial del libro o revista
     */
    private String editorial;

    /**
     * Categoría del libro o revista
     */
    private String categoria;

    /**
     * Número de publicación de la revista
     */
    private int nRevista;

    /**
     * Año de publicación del libro o revista
     */
    private int año;

    /**
     * ISBN del libro
     */
    private String ISBN;

    /**
     * Lugar de creación del libro o revista
     */
    private String lugar;

    /**
     * Deposito Legal donde se almacena la copia del libro o revista
     */
    private String deposito_legal;

    /**
     * Estante donde el cliente tiene almacenado el libro de forma física
     */
    private String estante;

    /**
     * Ubicación donde tiene el cliente el libro
     */
    private String ubicacion;

    /**
     * Signatura que se le ha colocado al libro
     */
    private String signatura;

    /**
     * Proporciona la id del libro
     *
     * @return valor de la variable idlibros
     */
    public int getIdlibros() {

        return idlibros;
    }

    /**
     * Asigna un valor a la variable idlibros
     *
     * @param idlibros ID del libro o revista
     */
    public void setIdlibros(int idlibros) {

        this.idlibros = idlibros;
    }

    /**
     * Proporciona el titulo del libro
     *
     * @return valor de la variable titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Asigna un valor a la variable titulo
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Proporciona el autor del libro
     *
     * @return valor de la variable autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Proporciona el titulo de la revista
     *
     * @return valor de la variable revista
     */
    public String getRevista() {
        return revista;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param revista
     */
    public void setRevista(String revista) {
        this.revista = revista;
    }

    /**
     * Proporciona la editorial de la revista
     *
     * @return valor de la variable editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Proporciona la categoría del libro o revista
     *
     * @return valor de la variable categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Proporciona el número de la revista
     *
     * @return valor de la variable nRevista
     */
    public int getNrevista() {
        return nRevista;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param nrevista
     */
    public void setNrevista(int nrevista) {
        this.nRevista = nrevista;
    }

    /**
     * Proporciona el año de publicación del libro o revista
     *
     * @return valor de la variable año
     */
    public int getAño() {
        return año;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param año
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * Proporciona el ISBN del libro
     *
     * @return valor de la variable ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param iSBN
     */
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    /**
     * Proporciona el lugar de publicación del libro
     *
     * @return valor de la variable lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Proporciona el deposito legal donde se almacena la copia del libro
     *
     * @return valor de la variable deposito_legal
     */
    public String getDeposito_legal() {
        return deposito_legal;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param deposito_legal
     */
    public void setDeposito_legal(String deposito_legal) {
        this.deposito_legal = deposito_legal;
    }

    /**
     * Proporciona el estante donde se almacena el libro físicamente
     *
     * @return valor de la variable estante
     */
    public String getEstante() {
        return estante;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param estante
     */
    public void setEstante(String estante) {
        this.estante = estante;
    }

    /**
     * Proporciona la ubicación donde se encuentra la publicación
     *
     * @return valor de la variable ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param ubicacion
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Proporciona la signatura de la publicación
     *
     * @return valor de la variable signatura
     */
    public String getSignatura() {
        return signatura;
    }

    /**
     * Asigna un valor a la variable
     *
     * @param signatura
     */
    public void setSignatura(String signatura) {
        this.signatura = signatura;
    }

}

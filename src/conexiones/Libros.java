/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

/**
 *
 * @author raulsantiago
 */
public class Libros {
    
   private int idlibros;
   private  String titulo;
   private String autor;
   private String revista;
   private String editorial;
   private String categoria;
   private int nRevista;
   private int año;
   private String ISBN;
   private String lugar;
   private String deposito_legal;
   private String estante;
   private String ubicacion;
   private String signatura;

   
        public int getIdlibros(){
            
            return idlibros;
        }
        
        public void setIdlibros(int idlibros){
            
            this.idlibros = idlibros;
        }
   	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getRevista() {
		return revista;
	}
	public void setRevista(String revista) {
		this.revista = revista;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getNrevista() {
		return nRevista;
	}
	public void setNrevista(int nrevista) {
		this.nRevista = nrevista;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getDeposito_legal() {
		return deposito_legal;
	}
	public void setDeposito_legal(String deposito_legal) {
		this.deposito_legal = deposito_legal;
	}
	public String getEstante() {
		return estante;
	}
	public void setEstante(String estante) {
		this.estante = estante;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getSignatura() {
		return signatura;
	}
	public void setSignatura(String signatura) {
		this.signatura = signatura;
	}

    
    
}

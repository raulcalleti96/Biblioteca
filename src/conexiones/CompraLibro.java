package conexiones;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Clase CompraLibro
 *
 * Proporciona el método que navegará hasta la web de Google Books para que el
 * cliente pueda comprarlo si lo desea
 *
 * @author raulsantiago
 * @version 1.0
 */
public class CompraLibro {

    /**
     * Método que ejecuta la acción automática para buscar el libro en la web de
     * Google Books, mediante el navegador Chrome
     *
     * @param libro Proporciona la información del libro que se deséa buscar
     */
    public void ejecuta(Libros libro) {

        //Variable con el nombre del Driver del navegador
        String exepath = "chromedriver";
        //se le añade la propiedad al sistema con el driver del navegador
        System.setProperty("webdriver.chrome.driver", exepath);

        //Se instancia la clase con el driver
        WebDriver driver = new ChromeDriver();
        //Métodos de la clase WebDriver para abrir la pentalla y maximizarla
        driver.manage().window().maximize();
        //Web que buscará el driver
        driver.get("https://books.google.es");

        //Buscará en la página proporcionada un buscador
        WebElement searchbox = driver.findElement(By.name("q"));

        //Limpiará el buscador
        searchbox.clear();

        //Escribirá en el buscador los valores del libro pasado como parametro 
        searchbox.sendKeys(libro.getTitulo() + "-" + libro.getAutor() + "-" + libro.getISBN());

        //Se ejecuta la busqueda
        searchbox.submit();

        //Segundos que esperará el driver para ser ejecutado
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}

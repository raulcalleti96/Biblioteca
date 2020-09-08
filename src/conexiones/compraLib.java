/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author raulsantiago
 */
public class compraLib {


    
    public void ejecuta(Libros libro) {
        String exepath = "chromedriver";
        System.setProperty("webdriver.chrome.driver", exepath);
    
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://books.google.es");
        
        WebElement searchbox = driver.findElement(By.name("q"));
        
        searchbox.clear();
        
        searchbox.sendKeys(libro.getTitulo() + "-" + libro.getAutor()+ "-"+ libro.getISBN());
        
        searchbox.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        

    }
}

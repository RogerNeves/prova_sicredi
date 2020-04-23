package ProvaSicrediTest;

import ProvaSicredi.Cadastrar;
import ProvaSicredi.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class cadastratarTest {

    private WebDriver driver;
    private Cadastrar cadastrar;

    @Before
    public void beforeTest() {
        driver = Driver.iniciarWebDriver();
        String url = "https://www.grocerycrud.com/demo/bootstrap_theme";
        driver.get(url);

        WebElement selectVersion = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("switch-version-select")));
        selectVersion.sendKeys("Bootstrap V4 Theme", Keys.ENTER);

        WebElement addButton = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#gcrud-search-form .floatL a")));
        addButton.click();

        cadastrar = new Cadastrar(driver);
    }

    @After
    public void afterTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void desafio() throws InterruptedException {

        String successText = cadastrar.fillFields();

        Thread.sleep(2000);

        Assert.assertEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list", successText);

        List<WebElement> goBack = driver.findElements(By.cssSelector("#report-success a"));
        goBack.forEach(it -> {
                    if (it.getText().equals("Go back to list")) {
                        it.click();
                    }
                }
        );

        WebElement searchField = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.name("customerName")));
        searchField.sendKeys("Teste Sicredi");

        Thread.sleep(2000);

        WebElement allCheckBox = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.className("select-all-none")));
        allCheckBox.click();

        WebElement deleteButton = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.className("delete-selected-button")));
        deleteButton.click();

        WebElement confirmeDeleteText = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.className("alert-delete-multiple-one")));
        confirmeDeleteText.getText();
        Assert.assertEquals("Are you sure that you want to delete this 1 item?", confirmeDeleteText.getText());

        WebElement confirmeDeleteButton = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.className("delete-multiple-confirmation-button")));
        confirmeDeleteButton.click();

        WebElement confirmedDeleteText = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".alert-success p")));
        Assert.assertEquals("Your data has been successfully deleted from the database.", confirmedDeleteText.getText());
    }
}

package ProvaSicredi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cadastrar {
    private WebDriver driver;

    public Cadastrar(WebDriver driver) {
        this.driver = driver;
    }

    public String fillFields(){
        WebElement nameInput = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field-customerName")));
        nameInput.sendKeys("Teste Sicredi");

        WebElement lastNameInput = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field-contactLastName")));
        lastNameInput.sendKeys("Teste");

        WebElement contactNameInput = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field-contactFirstName")));
        contactNameInput.sendKeys("Róger");

        WebElement phoneInput = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field-phone")));
        phoneInput.sendKeys("51 9999-9999");

        WebElement addressLine1Input = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field-addressLine1")));
        addressLine1Input.sendKeys("Av Assis Brasil, 3970");

        WebElement addressLine2Input = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field-addressLine2")));
        addressLine2Input.sendKeys("Torre D");

        WebElement cityInput = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field-city")));
        cityInput.sendKeys("Porto Alegre");

        WebElement stateInput = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field-state")));
        stateInput.sendKeys("RS");

        WebElement postalCodeInput = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field-postalCode")));
        postalCodeInput.sendKeys("91000-000");

        WebElement countryInput = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field-country")));
        countryInput.sendKeys("Brasil");

        WebElement employeeSelect = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field_salesRepEmployeeNumber_chosen")));
        employeeSelect.click();
        Actions action = new Actions(driver);
        action.sendKeys("fixter" + Keys.ENTER).perform();

        WebElement creditLimitInput = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("field-creditLimit")));
        creditLimitInput.sendKeys("200");

        WebElement saveButton = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id("form-button-save")));
        saveButton.click();

        WebElement successText = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#report-success p")));
        return successText.getText();
    }
}

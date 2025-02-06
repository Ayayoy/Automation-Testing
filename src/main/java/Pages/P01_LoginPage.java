package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P01_LoginPage {
    // WebDriver instance
     SHAFT.GUI.WebDriver driver;
     // Constructors
    public P01_LoginPage(SHAFT.GUI.WebDriver driver){
    this.driver = driver;
    }
    // Locators
    By loginBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    By userName = By.xpath("//input[@name='username']");
    By passwordInput = By.xpath("//input[@name='password']");
    // Methods
    public P02_HomePage loginSteps(String username, String password){
        driver.element().type(userName, username)
                .and().type(passwordInput, password)
                .and().click(loginBtn);
        return new P02_HomePage(driver);

    }
}

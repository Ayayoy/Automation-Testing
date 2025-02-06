package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P04_AddNewUser {
    // WebDriver instance
    private SHAFT.GUI.WebDriver driver;
    // Constructors
    public P04_AddNewUser(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    // Locators
    By UserRoleDropDown = By.xpath("//label[contains(.,'User Role')]/../following-sibling::div");
    By selectUserRole = By.xpath("//div[@class='oxd-select-option'][contains(.,'Admin')]");
    By EmployeeNameInput = By.xpath("(//label[contains(.,'Employee Name')]//following::input)[1]");
    By EmployeeName = By.xpath("//span[@class='oxd-userdropdown-tab']//p");
    By selectEmployee = By.xpath("//div[@role='option'][1]");
    By StatusDropDown = By.xpath("//label[contains(.,'Status')]/../following-sibling::div");
    By selectStatus = By.xpath("//div[@class='oxd-select-option'][contains(.,'Enabled')]");
    By userNameInput = By.xpath("(//label[contains(.,'Username')]//following::input)[1]");
    By PasswordInput = By.xpath("(//label[contains(.,'Password')]//following::input)[1]");
    By ConfirmPasswordInput = By.xpath("(//label[contains(.,'Confirm Password')]//following::input)[1]");
    By saveButton = By.xpath("//button[@type='submit']");
    // Methods

    public P03_AdminPage fillForm(String newUser, String newPassword){
        driver.element().click(UserRoleDropDown).
                and().click(selectUserRole).
                and().type(EmployeeNameInput,getEmployeeName());
        WebDriverWait wait= new WebDriverWait(driver.getDriver(), Duration.ofSeconds(5));
        wait.until(d->driver.element().waitUntilPresenceOfAllElementsLocatedBy(selectEmployee));
        driver.element().click(selectEmployee).
                and().click(StatusDropDown).click(selectStatus).
                and().type(userNameInput,newUser).
                and().type(PasswordInput,newPassword).
                and().type(ConfirmPasswordInput,newPassword).
                and().click(saveButton);
        driver.browser().captureScreenshot();
        return new P03_AdminPage(driver);
    }
    public String getEmployeeName(){
        return driver.element().getText(EmployeeName);
    }

}

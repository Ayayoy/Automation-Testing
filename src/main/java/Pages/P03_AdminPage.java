package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P03_AdminPage {
    // WebDriver instance
    private SHAFT.GUI.WebDriver driver;
    static int originalNumOfRecords , numberOfRecordsAfterAddingUser;
    // Constructors
    public P03_AdminPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By numberOfRecord = By.xpath("//span[contains(@class,\"oxd-text--span\")]//parent::div[contains(@class,\"orangehrm-horizontal-padding orangehrm-vertical-padding\")]");
    By addButton = By.xpath("//i[contains(@class,\"oxd-button-icon\")]//parent::button");
    By SuccessMsg = By.xpath("//div[@class='oxd-toast-start']//p[contains(.,'Successfully Saved')]");
    // Methods

    public String getNumbersOfRecords() {

        return driver.element().getText(numberOfRecord);
    }

    public int printNumberOfRecords() {
        // Retrieve the text, filtering out non-numeric characters
        int recordCount = Integer.parseInt(getNumbersOfRecords().replaceAll("[^0-9]", ""));
        System.out.println("Number Of Records: " + recordCount);
        return recordCount;
    }
    public P03_AdminPage getOriginalRecords(){
        originalNumOfRecords = printNumberOfRecords();
        System.out.println("Number of Original Records Found: "+ originalNumOfRecords);
        return this;
    }
    public P03_AdminPage getNumOfRecordsAfterAddingUser() {

        numberOfRecordsAfterAddingUser = printNumberOfRecords();
        System.out.println("Number of Records After adding User Found: " + numberOfRecordsAfterAddingUser);
        return this;
    }
    public P04_AddNewUser clickOnAddButton(){
        driver.element().click(addButton);
       return new P04_AddNewUser(driver);
    }
    public P03_AdminPage formSubmittedSuccessfully(){
        driver.element().assertThat(SuccessMsg).exists().perform();
        return this;
    }
    public void verifyNumOfRecordsIncreasedBy1(){
        SHAFT.Validations.verifyThat().object(numberOfRecordsAfterAddingUser).
                isEqualTo(originalNumOfRecords+1).perform();
    }

}

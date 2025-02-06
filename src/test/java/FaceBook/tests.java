package FaceBook;

import Pages.P01_LoginPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class tests {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("OrangeTestdata.json");
        driver.browser().navigateToURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void OrangeTests() {
        new P01_LoginPage(driver).loginSteps(testData.getTestData("userName"),
                        testData.getTestData("password"))
                .clickOnAdminTab()
                .getOriginalRecords()
                .clickOnAddButton()
                .fillForm(testData.getTestData("newUser"), testData.getTestData("newPassword"))
                .formSubmittedSuccessfully()
                .getNumOfRecordsAfterAddingUser()
                .verifyNumOfRecordsIncreasedBy1();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}

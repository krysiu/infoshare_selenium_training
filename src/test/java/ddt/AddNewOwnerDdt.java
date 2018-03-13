package ddt;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobject.pages.AddOwnerPage;
import utils.driver.WebDriverCreators;
import utils.driver.WebDriverProvider;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.GetRandomData.RandomData.*;



@RunWith(DataProviderRunner.class)
public class AddNewOwnerDdt {
    private static final String PAGE_URL = "http://localhost:8080/";

    private WebDriver driver;

    private AddOwnerPage addOwnerPage;

    /* Instead of String[] we can use Object[] or other type. */
    @DataProvider
    public static Object[][] testDataForRegistration() {
        return new String[][] {
                new String[] {firstName, lastName, address, city, telephone },
                new String[] {firstName, lastName, address, city, telephone },
                new String[] {firstName, lastName, address, city, telephone },
                new String[] {firstName, lastName, address, city, telephone },
                new String[] {firstName, lastName, address, city, telephone },
                new String[] {firstName, lastName, address, city, telephone },
                new String[] {firstName, lastName, address, city, telephone },
                new String[] {firstName, lastName, address, city, telephone },
        };
    }

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();
        addOwnerPage = PageFactory.initElements(driver, AddOwnerPage.class);
        driver.get(PAGE_URL);
    }

    @Test
    @UseDataProvider("testDataForRegistration")
    public void registerNewUserTest(String firstName, String lastName, String address, String city, String telephone) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        addOwnerPage.addNewOwner(firstName, lastName, address, city, telephone);

        WebElement alertElement = driver.findElement(By.xpath("//h2[contains(text(),'Owner Information')]"));

        String alert = alertElement.getText();

        assertThat(alert).contains("Owner Information").as("Użytkownik nie został dodany");
    }

    @After
    public void tearDown() {
        driver.close();
    }
}

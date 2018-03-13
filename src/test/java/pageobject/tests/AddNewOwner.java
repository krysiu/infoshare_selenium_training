package pageobject.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobject.pages.AddOwnerPage;
import utils.driver.WebDriverCreators;
import utils.driver.WebDriverProvider;
import utils.waits.CustomWait;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.GetRandomData.RandomData.*;



public class AddNewOwner {
    private static final String PAGE_URL = "http://localhost:8080/";
    private AddOwnerPage addOwnerPage;
    private WebDriver driver;
    private CustomWait customWait;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();
        customWait = new CustomWait(driver);
        addOwnerPage = PageFactory.initElements(driver, AddOwnerPage.class);
        driver.get(PAGE_URL);

    }

    @Test
    public void register()  {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        addOwnerPage.addNewOwner(firstName, lastName, address, city, telephone);

        WebElement alertElement = driver.findElement(By.xpath("//h2[contains(text(),'Owner Information')]"));

        String alert = alertElement.getText();

        assertThat(alert).contains("Owner Information").as("Użytkownik nie został dodany");
        
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

package pageobject.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class AddOwnerPage {


    @FindBy(xpath = "//a[@href='/owners/find']")
    private WebElement findOwnerTab;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    private WebElement addOwnerButton;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement fieldFirstName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement fieldLastName;

    @FindBy(xpath = "//input[@id='address']")
    private WebElement fieldAddress;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement fieldCity;

    @FindBy(xpath = "//input[@id='telephone']")
    private WebElement fieldTelephone;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement finalAddOwnerButton;

    public void clickOnFindOwnerTab() { findOwnerTab.click(); }

    public void clickOnAddOwnerButton() { addOwnerButton.click(); }

    public void typeInFirstName(String firstName) {
        fieldFirstName.sendKeys(firstName);
    }

    public void typeInLastName(String lastName) {
        fieldLastName.sendKeys(lastName);
    }

    public void typeInAddress(String address) { fieldAddress.sendKeys(address); }

    public void typeInCity(String city) {
        fieldCity.sendKeys(city);
    }

    public void typeInTelephone(String telephone) {
        fieldTelephone.sendKeys(telephone);
    }

    public void clickOnFinalAddOwnerButton() { finalAddOwnerButton.click(); }

    public void addNewOwner(String firstName, String lastName, String address, String city, String telephone) {
        clickOnFindOwnerTab();
        clickOnAddOwnerButton();
        typeInFirstName(firstName);
        typeInLastName(lastName);
        typeInAddress(address);
        typeInCity(city);
        typeInTelephone(telephone);
        clickOnFinalAddOwnerButton();
    }






}

package AutomationTesting.PageObjects;

import org.openqa.selenium.*;

public class LoginPage extends BasePage {

    private static String userNameLoc = "#login:not([style=\"display:none\"])";
    private static String passwordLoc = "#password";
    private static String submitLoc = "#submit";

    public LoginPage() {
        super();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to the login page
     *
    */
    public void goToLogin () {
        driver.get("https://release.staging.redbooth.com/login");
    }

    /**
     * Does login with the specified username and password
     *
     * @param userName username of the user to login with
     * @param password password with the one the user will login
     *
     * @return [Boolean] true if the user did login correctly
    */
    public Boolean doLogin (String userName, String password) {
        goToLogin();

        getUserName().sendKeys(userName);
        getPassword().sendKeys(password);
        getSubmit().click();

        return waitFor(
                () -> {
                    String expectedTitle = "My Tasks - Redbooth";
                    return driver.getTitle().contentEquals(expectedTitle);
                },
            5);
    }

    /**
     * Gets the element of the username text field
     *
     * @return [WebElement]
    */
    private WebElement getUserName () {
        return getElementByCss(userNameLoc);
    }

    /**
     * Gets the element of the password text field
     *
     * @return [WebElement]
    */
    private WebElement getPassword () {
        return getElementByCss(passwordLoc);
    }

    /**
     * Gets the element of the submit button
     *
     * @return [WebElement]
    */
    private WebElement getSubmit () {
        return getElementByCss(submitLoc);
    }

}

package AutomationTesting;

import AutomationTesting.PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidLoginSpec {

    public static void main(String[] args) {

        // Create a new instance of the driver
        WebDriver driver = new ChromeDriver();

        // Create a new instance of the Login Page
        LoginPage loginPage = new LoginPage(driver);

        // Does the login and get the response if the login has been done correctly
        Boolean response = loginPage.doLogin("catea", "papapa22");

        if (response) {
            System.out.println("Arrived to the dashboard page correctly");
        } else {
            System.out.println("Not arrived to the dashboard page");
        }

        driver.close();

        // exit the program explicitly
        System.exit(0);
    }
}

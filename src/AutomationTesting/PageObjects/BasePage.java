package AutomationTesting.PageObjects;

import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.*;

import static org.awaitility.Awaitility.*;

import static java.util.concurrent.TimeUnit.SECONDS;


class BasePage  {

    org.openqa.selenium.WebDriver driver;

    BasePage(){
        this.driver = null;
    }

    /**
     * Global declaration for every page that inherits from this class
     *
     * @param driver driver for webDriver actions
    */
    BasePage(WebDriver driver){
        this.driver = driver;
    }

    Boolean waitFor(Callable<Boolean> block, Integer time) {
        try {
            await().atMost(time, SECONDS).until(block);
            return true;
        } catch (ConditionTimeoutException ex) {
            return false;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    WebElement getElementByCss(String cssLocator) {
        return driver.findElement(By.cssSelector(cssLocator));
    }
}

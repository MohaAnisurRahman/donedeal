import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
public class Selenium {
    public static void main(String[] args) {
        // Locators
        By loginLinkLocator = By.xpath("//button[contains(text(),'Log In')]");
        By cookiePopUpLocator =  By.cssSelector("button[onclick*=acceptAll]");
        By loginUserNameInputLocator = By.cssSelector("input#email");
        By loginPasswordInputLocator = By.cssSelector("input#password");
        By loginButtonLocator = By.xpath("//button[contains(@data-testid,'login') and contains(@type, 'submit')]");
        // creating driver object
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //setting up url
        String baseUrl = "https://donedeal.ie";
        // launch chrome and execute the test steps
        driver.get(baseUrl);
        driver.findElement(cookiePopUpLocator).click();
        driver.findElement(loginLinkLocator).click();
        driver.findElement(loginUserNameInputLocator).sendKeys("yusufcit@gmail.com");
        driver.findElement(loginPasswordInputLocator).sendKeys("bangladesh");
        driver.findElement(loginButtonLocator).click();
        // get the actual value of the title
        String actualTitle = driver.getTitle();
        System.out.println("actual title is: " + actualTitle);
        String expectedTitle = "DoneDeal | Ireland's Largest Motor & Classifieds Marketplace";
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        // sleeping the execution for 4000 milly sec
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //close chrome
        driver.close();
    }
}
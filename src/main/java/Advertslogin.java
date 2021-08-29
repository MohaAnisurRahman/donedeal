import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Advertslogin {
    public static void main(String[] args) {
        // Locators
        By loginLinkLocator = By.xpath("//*[@id=\"header\"]/div/div/a[3]");
        By cookiePopUpLocator = By.xpath("//*[@id=\"js-cookie-modal-level-one\"]/div/main/div/button[2]");
        By loginUserNameInputLocator = By.xpath("//*[@id=\"email\"]");
        By loginPasswordInputLocator = By.xpath("//*[@id=\"password\"]");
        By loginButtonLocator = By.xpath("//*[@id=\"login_form\"]/div[4]/input");
        // creating driver object
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //setting up url
        String baseUrl = "https://adverts.ie";
        // launch chrome and execute the test steps
        driver.get(baseUrl);
        driver.findElement(cookiePopUpLocator).click();
        driver.findElement(loginLinkLocator).click();
        driver.findElement(loginUserNameInputLocator).sendKeys("aynis2003@yahoo.com");
        driver.findElement(loginPasswordInputLocator).sendKeys("Ayrinanis20");
        driver.findElement(loginButtonLocator).click();
        // get the actual value of the title
        String actualTitle = driver.getTitle();
        System.out.println("actual title is: " + actualTitle);
        String expectedTitle = "Adverts.ie | Buy and Sell Everything on Ireland's Trusted Marketplace";
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

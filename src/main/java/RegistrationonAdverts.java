import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class RegistrationonAdverts {
    public static void main(String[] args) {

        // Locators
        By cookiePopUpLocator = By.xpath("//*[@id=\"js-cookie-modal-level-one\"]/div/main/div/button[2]");
    By signupLinkLocator = By.xpath("//*[@id=\"header\"]/div/div/a[2]");
    By signupUserNameInputLocator = By.xpath("//*[@id=\"email\"]");
    By signupPasswordInputLocator = By.xpath("//*[@id=\"password\"]");
    By signupButtonLocator = By.xpath("//*[@id=\"signup-btn\"]");

    // creating driver object
    String currentDir = System.getProperty("user.dir");
       System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\Driver\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    //setting up url
    String baseUrl = "https://adverts.ie";
    // launch chrome and execute the test steps
        driver.get(baseUrl);
        driver.findElement(cookiePopUpLocator).click();
        driver.findElement(signupLinkLocator).click();
        driver.findElement(signupUserNameInputLocator).sendKeys("Ayaanrahman14@gmail.com");
        driver.findElement(signupPasswordInputLocator).sendKeys("Ayrinanis20");
        driver.findElement(signupButtonLocator).click();
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


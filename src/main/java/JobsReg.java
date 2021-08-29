import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class JobsReg {
    public static void main(String[] args) {

        // Locators
        By cookiePopUpLocator = By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/button[2]");
        By signupLinkLocator = By.xpath("//*[@id=\"action_insert_1620232045644710\"]");
        By signupFirstNameInputLocator = By.xpath("//*[@id=\"RegistrationData_FirstName\"]");
        By signupLastNameInputLocator = By.xpath("//*[@id=\"RegistrationData_LastName\"]");
        By signupEmailInputLocator = By.xpath("//*[@id=\"RegistrationData_Email\"]");
        By signupPasswordInputLocator = By.xpath("//*[@id=\"RegistrationData_Password\"]");
        By continueButtonLocator = By.xpath("//*[@id=\"btnContinue\"]");

        // creating driver object
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //setting up url
        String baseUrl = "https://jobs.ie";
        // launch chrome and execute the test steps
        driver.get(baseUrl);
        driver.findElement(cookiePopUpLocator).click();
        driver.findElement(signupLinkLocator).click();
        driver.findElement(signupFirstNameInputLocator).sendKeys("rasel");
        driver.findElement(signupLastNameInputLocator).sendKeys("ahmed");
        driver.findElement(signupEmailInputLocator).sendKeys("gents1000@yahoo.com");
        driver.findElement(signupPasswordInputLocator).sendKeys("8613691");
        driver.findElement(continueButtonLocator).click();
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


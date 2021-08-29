import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
    public class AdvertsReg {
        public static void main(String[] args) {
            // creating driver object
            String currentDir = System.getProperty("user.dir");
            System.out.println("Current dir using System:" + currentDir);
            System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\driver\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            // don't touch the code above this line.

            // Locators

            By cookiePopUpLocator = By.xpath("//*[@id=\"js-cookie-modal-level-one\"]/div/main/div/button[2]");
            //By signupLinkLocator = By.xpath("//*[@id=\"header\"]/div/div/a[2]");
            //By signupUserNameInputLocator = By.xpath("//*[@id=\"email\"]");
            //By signupPasswordInputLocator = By.xpath("//*[@id=\"password\"]");
            //By signupButtonLocator = By.xpath("//*[@id=\"signup-btn\"]");
            try {
                // launch chrome and go to url


                driver.get("https://adverts.ie");
                driver.findElement(cookiePopUpLocator).click();
                //driver.findElement(signupLinkLocator).click();
                //driver.findElement(signupUserNameInputLocator).sendKeys("Ayaanrahman14@gmail.com");
                //driver.findElement(signupPasswordInputLocator).sendKeys("Ayrinanis20");
                //driver.findElement(signupButtonLocator).click();

                // Don't touch the code below this line
                System.out.println("Your Test Passed");
                // sleeping the execution for 4000 milly sec
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            catch (Exception e) {
                System.out.println("Your Test Failed");
            }
            //close chrome
            driver.close();
        }
    }


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTvNetTest {
    private final By LOCATOR_BY_ID = By.id("elementID");
    private final By LOCATOR_BY_NAME = By.name("elementName");
    private final By LOCATOR_BY_TAGNAME = By.tagName("nameOfTag");
    private final By LOCATOR_BY_CLASS = By.className("elemnentClassName");
    private final By LOCATOR_BY_XPATH = By.xpath(".//*contains(@class, 'list-article__met-infoflex'");

    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");

    //------------------FOR----------------------
    // for (int i = 0; i < titles.size(); i = i + 1) {
    //  if (!titles.get(i).getText().isEmpty()) {  // !true = false  !false = true
    //       System.out.println(i + ": " + titles.get(i).getText());
    //  }

    //  }
    //------------------FOREACH------------------
    //for (WebElement we : titles) {
    //           if (!we.getText().isEmpty()) {
    //               System.out.println(we.getText());//
    //               } else {
    //               System.out.println("---------------");
    //          }
    // условие ? если true : false (else)
    //  System.out.println(we.getText().isEmpty() ? "-------" : we.getText());



    @Test
    public void firstTest() {
        //WebDriver = browser window
        System.setProperty("webdriver.chrome.driver", "c://driver/chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        browserWindow.findElement(ACCEPT_COOKIES_BTN);

        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        WebDriver mailWait = (WebDriver) new WebDriverWait(browserWindow, 60, 2000);

        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

//      WebElement acceptBtn = browserWindow.findElement(ACCEPT_COOKIES_BTN);
//      acceptBtn.click();

        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        //comment for GIT
    }
}

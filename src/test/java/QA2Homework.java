import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class QA2Homework {

    private final By FIRST_ARTICLE = By.xpath("(//article/div/a[1]/span)[1]");
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By COMMENTS_BTN = By.xpath("(.//img[@src='/v5/img/icons/comment-v2.svg'])[1]");

    private final By ALL_ARTICLES = By.className("list-article__headline");
    private final By ALL_COMMENTS = By.className("list-article__comment section-font-color");
    private final By WEBSITE_LOGO = By.xpath("//*[@class='flex header-logo flex--align-items-center']");
    private final By RUS_BTN = By.xpath("//*[starts-with(text(),'RUS')]");
    private final By HOME_PAGE_TITLE = By.xpath(".//span[contains(@class, 'list-article__headline')]");

    private final By HOME_PAGE_ARTICLE = By.tagName("article");

    private final Logger LOGGER = LogManager.getLogger(QA2Homework.class);

    private WebDriver browserWindow;

    @Test
    public void QA2Homework() {
        LOGGER.info("This Test is clicking on first home page title and its comments");

        LOGGER.info("Setting driver location");
        System.setProperty("webdriver.chrome.driver", "c://driver/chromedriver.exe");

        LOGGER.info("Opening browser window");
        browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();

        LOGGER.info("Opening home page");
        browserWindow.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        LOGGER.info("Clicking cookies btn");
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();
        LOGGER.info("Clicking first article");
        browserWindow.findElement(FIRST_ARTICLE).click();
        LOGGER.info("Clicking comments btn");
        browserWindow.findElement(COMMENTS_BTN).click();


    }


    @Test
    public void listTitles() {
        System.setProperty("webdriver.chrome.driver", "c://driver/chromedriver.exe");
        browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));

        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        LOGGER.info("Titles from home page is listed");
        List<WebElement> titles = browserWindow.findElements(HOME_PAGE_TITLE);
        List<WebElement> comments = browserWindow.findElements(ALL_COMMENTS);

        LOGGER.info("Printed all home page titles without empty spaces");
        for (int i = 0; i < titles.size(); i++) {
            if (!titles.get(i).getText().isEmpty()) {
                String commentsCount = titles.get(i).getText();
                System.out.println(i + ": " + titles.get(i).getText() + " and comments count = " + commentsCount);

                }
            }
        }
    @Test
    public void getTitleOfFirstArticle() {
        System.setProperty("webdriver.chrome.driver", "c://driver/chromedriver.exe");
        browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));

        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();
        LOGGER.info("Find and get text from first article");
        String articlePageTitle = browserWindow.findElement(FIRST_ARTICLE).getText();
        LOGGER.info("First article is printed");
        System.out.println(articlePageTitle);


    }
    @AfterEach
    private void closeBrowser() {
        browserWindow.close();
    }
}

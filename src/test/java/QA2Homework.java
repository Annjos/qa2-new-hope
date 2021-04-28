import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QA2Homework {

    private final By FIRST_ARTICLE = By.xpath("(//article/div/a[1]/span)[1]");
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By COMMENTS_BTN = By.xpath(".//*[@src='/v5/img/icons/comment-v2.svg']");

    private final By ALL_ARTICLES = By.className("list-article__headline");
    private final By ALL_COMMENTS = By.className("list-article__comment section-font-color");
    private final By WEBSITE_LOGO = By.xpath("//*[@class='flex header-logo flex--align-items-center']");
    private final By RUS_BTN = By.xpath("//*[starts-with(text(),'RUS')]");

    @Test
    public void QA2Homework(){
        System.setProperty("webdriver.chrome.driver", "c://driver/chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();
        browserWindow.findElement(FIRST_ARTICLE).click();
        browserWindow.findElement(COMMENTS_BTN).click();


    }
}

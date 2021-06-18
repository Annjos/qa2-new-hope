package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobject.tvnet.ArticlePage;
import pageobject.tvnet.CommentPage;
import pageobject.tvnet.HomePage;


public class TVNetArticleCommentsTest {

    private final Logger LOGGER = LogManager.getLogger(TVNetArticleCommentsTest.class);
    private final int ARTICLE_ID = 5;

    private WebDriver driver;
    private BaseFunc baseFunc;

    @Test
    public void tvNetTitleAndCommentsCountCheck () {
        LOGGER.info("This test is checking titles and comments count on home/article/comments pages");

       baseFunc = new BaseFunc();

        baseFunc.openPage("http://tvnet.lv");

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();

        CommentPage commentPage = new CommentPage(baseFunc);

//  -----------------------HOME PAGE----------------------------------

        String homePageTitle = homePage.getTitle(ARTICLE_ID);
        int homePageCommentsCount = homePage.getCommentsCount(ARTICLE_ID);

       ArticlePage articlePage = homePage.openArticle(ARTICLE_ID);

        //--------------------ARTICLE_PAGE------------------

      String articlePageTitle = articlePage.getTitle();
      int articlePageCommentsCount =  articlePage.getCommentsCount();

        Assertions.assertEquals(homePageTitle.replaceAll("\\s+\\(([^)]+)\\)",""), articlePageTitle, "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentsCount, "Wrong comments count!");

        articlePage.openCommentsPage();

        //---------------COMMENTS PAGE----------------------------------
        String commentsPageTitle = commentPage.getTitle();
        int commentsCountText = commentPage.getCommentsCount();

        Assertions.assertEquals(homePageTitle.replaceAll("\\s+\\(([^)]+)\\)",""), commentsPageTitle, "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, commentsCountText, "Wrong comments count!");
    }

    @AfterEach
    public void closBrowser () {
        baseFunc.closeBrowser();
    }
}

package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobject.pages.ArticlePage;
import pageobject.pages.CommentPage;
import pageobject.pages.HomePage;

public class DelfiArticleCommentsTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final int ARTICLE_ID = 4;

    private BaseFunc baseFunc;

    CommentPage commentPage = new CommentPage(baseFunc);

    @Test
    public void titleAndCommentsCountCheck() {
        LOGGER.info("This test is checking titles and comments count on home/article/comments pages");

        baseFunc = new BaseFunc();
        baseFunc.openPage("http://delfi.lv");

        //------------HOME PAGE-------------
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();

        String homePageTitle = homePage.getTitle(ARTICLE_ID);
        int homePageCommentsCount = homePage.getCommentsCount(ARTICLE_ID);

        ArticlePage articlePage = homePage.openArticle(ARTICLE_ID);

        //----------ARTICLE--------

        String articlePageTitle = articlePage.getTitle();
        int articlePageCommentsCount = articlePage.getCommentsCount();

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Wrong Title!");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentsCount, "Wrong comments count!");

        articlePage.openCommentsCount();

        //-------COMMENTS PAGE-------

        String commentPageTitle = commentPage.getTitle();
        int commentPageAnonimCommentCount = commentPage.getCommentsCount();
        int commentPageRegisterCommentCount = commentPage.getCommentsCount();

        Assertions.assertEquals(homePageTitle, commentPageTitle, "Wrong title!" );
        Assertions.assertEquals(homePageCommentsCount, commentPageAnonimCommentCount + commentPageRegisterCommentCount, "Wrong comments count!");

    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}

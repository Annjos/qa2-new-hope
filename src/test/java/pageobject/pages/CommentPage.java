package pageobject.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pageobject.BaseFunc;

public class CommentPage {

    private final By TITLE = By.xpath(".//h1[contains(@class, 'article-title')] ");
    private final By ANON_COMMENTS = By.xpath(".//li[contains(@class, 'as-link show-anon')]");
    private final By REGISTER_COMMENTS = By.xpath(".//li[contains(@class, 'as-link is-active show-reg')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public CommentPage(BaseFunc baseFunc) { this.baseFunc = baseFunc; }

    public String getTitle() {
        LOGGER.info("Waiting article title");
        return baseFunc.getText(TITLE);
    }

    public int getCommentsCount() {
        LOGGER.info("Getting article comments count");

        if (baseFunc.findElements(ANON_COMMENTS).isEmpty()) {
            return 0;
        } else {
            String commentsCountToParse = baseFunc.getText(ANON_COMMENTS);
            commentsCountToParse = commentsCountToParse.substring(1, commentsCountToParse.length() - 1);
            return Integer.parseInt(commentsCountToParse);
        }
    }

    public int getCommentsCountReg() {
        LOGGER.info("Getting article comments count");

        if (baseFunc.findElements(REGISTER_COMMENTS).isEmpty()) {
            return 0;
        } else {
            String commentsCountToParse = baseFunc.getText(REGISTER_COMMENTS);
            commentsCountToParse = commentsCountToParse.substring(1, commentsCountToParse.length() - 1);
            return Integer.parseInt(commentsCountToParse);
        }
    }

}

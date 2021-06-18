package pageobject.tvnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pageobject.BaseFunc;

public class CommentPage {
    private final By TITLE = By.xpath(".//h1[contains(@class, 'article-headline')] ");
    private final By COMMENTS = By.xpath(".//span[contains(@class, 'article-comments-heading__count')] ");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting article title");
        return baseFunc.getText(TITLE);
    }

    public int getCommentsCount () {
        LOGGER.info("Getting article comments count");

        if (baseFunc.findElements(COMMENTS).isEmpty())  {
            return 0;
        } else {
            String commentCountToParse = baseFunc.getText(COMMENTS);
//            commentCountToParse = commentCountToParse.substring(1, commentCountToParse.length() - 1);
            return Integer.parseInt(commentCountToParse);
        }
    }

}

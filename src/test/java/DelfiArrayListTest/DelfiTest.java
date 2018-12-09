package DelfiArrayListTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DelfiTest {
    private BaseFunk baseFunk = new BaseFunk();
    private final String HOME_PAGE = "https://rus.delfi.lv/";
    private final String MOBILE_HOME_PAGE = "https://m.rus.delfi.lv/";
    private static final Logger LOGGER = LogManager.getLogger(DelfiTest.class);

    @Test
    public void arrayList() {
        LOGGER.info("Going to Delfi Mobile Home Page");
        baseFunk.goToPage(MOBILE_HOME_PAGE);
        DelfiMobileHomePage mobileHomePage = new DelfiMobileHomePage(baseFunk);
        LOGGER.info("Counting first 5 articles from MobilePage");
        List<String> mobileArticles = mobileHomePage.mobArticles();
        LOGGER.info("Going to Delfi Web Home Page");
        baseFunk.goToPage(HOME_PAGE);
        DelfiHomePage delfiHomePage = new DelfiHomePage(baseFunk);
        LOGGER.info("Counting first 5 articles from webPage");
        List<String> webArticles = delfiHomePage.webHomePage();
        LOGGER.info("Comparing got it articles with each other, they are equal or not");
        Assertions.assertEquals(mobileArticles, webArticles, "Articles are not equal");
        LOGGER.info("Get it quantity of comments from Home Page");
        Integer commentCountOnHomePage = delfiHomePage.commentCountById(0);
        LOGGER.info("Going to first article page, by click");
        delfiHomePage.articleGetId(0).click();
        LOGGER.info("Going to comment page, by click on article");
        ArticlePage articlePage = new ArticlePage(baseFunk);
        articlePage.goToCommentPage(0);
        LOGGER.info("Getting quantity of comments on Comment page");
        CommentPage commentPage = new CommentPage(baseFunk);
        Integer totalCommentOnCommentPage = commentPage.sumCommentOnArticlePage();
        LOGGER.info("Checking equal are quantity of comments on both pages or not ");
        Assertions.assertEquals(commentCountOnHomePage, totalCommentOnCommentPage, "Comments are Equals");

    }
}

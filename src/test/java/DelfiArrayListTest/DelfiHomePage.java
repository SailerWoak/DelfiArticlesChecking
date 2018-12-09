package DelfiArrayListTest;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DelfiHomePage {
    BaseFunk baseFunk;
    private final By ARTICLE_WEB = By.xpath(".//h1[contains(@class, 'headline')]");
    private final By ARTICLES = By.xpath(".//span[@class = 'text-size-22']");
    private final By COMMENT_COUNT = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");

    public DelfiHomePage(BaseFunk baseFunk) {
        this.baseFunk = baseFunk;
    }

    public List<String> webHomePage() {
        List<WebElement> webArticles = baseFunk.getElements(ARTICLE_WEB);
        List<String> articles = new ArrayList<String>();

        Assertions.assertFalse(webArticles.isEmpty(), "Wrong article title");

        for (int i = 0; i < 4; i++) {
            articles.add(webArticles.get(i).getText());
        }

        return articles;
    }

    public WebElement articleGetId(int id) {
        List<WebElement> articles = baseFunk.getElements(ARTICLES);
        for (int i = 0; i < articles.size(); i++) {
            WebElement article = articles.get(i);
            return article;
        }
        return null;
    }

    public Integer commentCountById(int id) {
        WebElement article = articleGetId(id);
        String commentCount = article.findElement(COMMENT_COUNT).getText();
        commentCount = commentCount.substring(1, commentCount.length() - 1);
        return Integer.valueOf(commentCount);

    }
}


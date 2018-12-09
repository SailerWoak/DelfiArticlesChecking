package DelfiArrayListTest;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DelfiMobileHomePage {
    BaseFunk baseFunk;
    private final By ARTICLE_MOBILE = By.xpath(".//a[@class = 'md-scrollpos']");

    public DelfiMobileHomePage(BaseFunk baseFunk) { this.baseFunk = baseFunk; }

    public List<String> mobArticles() {
        List<WebElement> mobArticles = baseFunk.getElements(ARTICLE_MOBILE);
        List<String> articles = new ArrayList<String>();
        Assertions.assertFalse(mobArticles.isEmpty(), "Wrong article title");
        for (int i = 0; i < 4; i++) {
            articles.add(mobArticles.get(i).getText());
        }//dont need other return, firstly get and after return !!!
        return articles;
    }
}

